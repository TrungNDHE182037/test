/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Book;

/**
 *
 * @author Admin
 */
public class BookDAO extends DBContext {
    
    public List<Book> getBookByOrder(String orderid){
        String sql = "select * from book b\n" +
"join category c on c.category_id=b.category_id\n" +
"join order_line ol on ol.book_id = b.book_id\n" +
"where ol.order_id = "+orderid;
        List<Book> list = new ArrayList<>();
        
         try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Book s = new Book(rs.getInt("num_pages"), rs.getInt("quantity"), rs.getInt("book_id"), rs.getDouble("price"), rs.getString("title"), rs.getString("author_name"), rs.getString("isbn13"), rs.getString("language_name"), rs.getString("publication_date"), rs.getString("publisher_name"), rs.getString("img"), rs.getString("category_name"), rs.getString("description"));

                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }
    
    public int getTotalBook(){
        String sql = "select count(*) from book";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }
    
    public List<Book> pagingBook(int index){
        List<Book> list = new ArrayList<>();
        String sql = "select * from book b\n" +
"join category c on c.category_id=b.category_id\n" +
"order by book_id\n" +
"OFFSET ? ROWS FETCH NEXT 8 ROWS ONLY";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, (index-1)*8);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Book s = new Book(rs.getInt("num_pages"), rs.getInt("quantity"), rs.getInt("book_id"), rs.getDouble("price"), rs.getString("title"), rs.getString("author_name"), rs.getString("isbn13"), rs.getString("language_name"), rs.getString("publication_date"), rs.getString("publisher_name"), rs.getString("img"), rs.getString("category_name"), rs.getString("description"));

                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }
     
    public List<Book> searchBook(String title){
        List<Book> list = new ArrayList<>();
        String sql = "select * from book b \n"
                + "join category c on c.category_id=b.category_id \n"
                + " where title like '%"+title+"%'";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Book s = new Book(rs.getInt("num_pages"), rs.getInt("quantity"), rs.getInt("book_id"), rs.getDouble("price"), rs.getString("title"), rs.getString("author_name"), rs.getString("isbn13"), rs.getString("language_name"), rs.getString("publication_date"), rs.getString("publisher_name"), rs.getString("img"), rs.getString("category_name"), rs.getString("description"));

                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
        
    }

    public void deleteBook(String title) {
        String sql = "DELETE FROM [dbo].[order_line]\n" +
"      WHERE book_id = (select book_id from book where title='"+title+"');\n" +
"\n" +
"DELETE FROM [dbo].[book]\n" +
"      WHERE title = '"+title+"';";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void editBook(Book b, int id) {
        CategoryDAO dbc = new CategoryDAO();
        String cid = dbc.getIDByname(b.getCategory());
        String sql = "UPDATE [dbo].[book]\n"
                + "   SET [author_name] = '" + b.getAuthor() + "' \n"
                + "      ,[title] = '" + b.getTitle() + "' \n"
                + "      ,[isbn13] = '" + b.getIsbn() + "' \n"
                + "      ,[language_name] = '" + b.getLang() + "' \n"
                + "      ,[num_pages] = " + b.getNumPage() + " \n"
                + "      ,[publication_date] = '" + b.getPubDate() + "' \n"
                + "      ,[publisher_name] = '" + b.getPubName() + "' \n"
                + "      ,[quantity] = " + b.getQuantity() + " \n"
                + "      ,[category_id] = " + cid + " \n"
                + "      ,[price] = " + b.getPrice() + " \n"
                + "      ,[img] = '" + b.getImg() + "' \n"
                + "      ,[description] = '" + b.getDes() + "' \n"
                + " WHERE book_id='" + id + "'";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void addBook(Book b) {
        CategoryDAO dbc = new CategoryDAO();
        String id = dbc.getIDByname(b.getCategory());
        String sql = "INSERT INTO [dbo].[book]\n"
                + "           ([author_name]\n"
                + "           ,[title]\n"
                + "           ,[isbn13]\n"
                + "           ,[language_name]\n"
                + "           ,[num_pages]\n"
                + "           ,[publication_date]\n"
                + "           ,[publisher_name]\n"
                + "           ,[quantity]\n"
                + "           ,[category_id]\n"
                + "           ,[price]\n"
                + "           ,[img]\n"
                + "           ,[description])\n"
                + "     VALUES\n"
                + "           ( '" + b.getAuthor() + "' \n"
                + "           , '" + b.getTitle() + "' \n"
                + "           , '" + b.getIsbn() + "' \n"
                + "           , '" + b.getLang() + "' \n"
                + "           , " + b.getNumPage() + " \n"
                + "           , '" + b.getPubDate() + "' \n"
                + "           , '" + b.getPubName() + "' \n"
                + "           , " + b.getQuantity() + " \n"
                + "           , " + id + "\n"
                + "           , " + b.getPrice() + " \n"
                + "           , '" + b.getImg() + "' \n"
                + "           , '" + b.getDes() + "' )";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public Book getBookByTitle(String title) {
        String sql = "select * from book b\n"
                + "                   join category c on c.category_id=b.category_id\n"
                + "                   where title = '" + title + "'";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Book s = new Book(rs.getInt("num_pages"), rs.getInt("quantity"), rs.getInt("book_id"), rs.getDouble("price"), rs.getString("title"), rs.getString("author_name"), rs.getString("isbn13"), rs.getString("language_name"), rs.getString("publication_date"), rs.getString("publisher_name"), rs.getString("img"), rs.getString("category_name"), rs.getString("description"));
                return s;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }
    
    public Book getBookByID(String ID) {
        String sql = "select * from book b\n"
                + "                   join category c on c.category_id=b.category_id\n"
                + "                   where book_id = '" + ID + "'";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Book s = new Book(rs.getInt("num_pages"), rs.getInt("quantity"), rs.getInt("book_id"), rs.getDouble("price"), rs.getString("title"), rs.getString("author_name"), rs.getString("isbn13"), rs.getString("language_name"), rs.getString("publication_date"), rs.getString("publisher_name"), rs.getString("img"), rs.getString("category_name"), rs.getString("description"));
                return s;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Book> getAll() {
        List<Book> list = new ArrayList<>();
        String sql = """
                   select * from book b
                   join category c on c.category_id=b.category_id""";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Book s = new Book(rs.getInt("num_pages"), rs.getInt("quantity"), rs.getInt("book_id"), rs.getDouble("price"), rs.getString("title"), rs.getString("author_name"), rs.getString("isbn13"), rs.getString("language_name"), rs.getString("publication_date"), rs.getString("publisher_name"), rs.getString("img"), rs.getString("category_name"), rs.getString("description"));

                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public List<Book> getTop7Novels() {
        List<Book> list = new ArrayList<>();
        String sql = """
                     select * from
                     (select top 7 b.title,count(ol.line_id) as sale from book b
                     join category c on c.category_id=b.category_id
                     join order_line ol on b.book_id=ol.book_id
                     group by b.title order by sale desc) as a
                     join book b on b.title= a.title
                     join category c on c.category_id=b.category_id
                     order by sale desc""";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Book s = new Book(rs.getInt("num_pages"), rs.getInt("quantity"), rs.getInt("book_id"), rs.getDouble("price"), rs.getString("title"), rs.getString("author_name"), rs.getString("isbn13"), rs.getString("language_name"), rs.getString("publication_date"), rs.getString("publisher_name"), rs.getString("img"), rs.getString("category_name"), rs.getString("description"));

                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public List<Book> getLatestBook() {
        List<Book> list = new ArrayList<>();
        String sql = """
                   select top 3 * from book b
                   join category c on c.category_id=b.category_id
                   order by publication_date desc""";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Book s = new Book(rs.getInt("num_pages"), rs.getInt("quantity"), rs.getInt("book_id"), rs.getDouble("price"), rs.getString("title"), rs.getString("author_name"), rs.getString("isbn13"), rs.getString("language_name"), rs.getString("publication_date"), rs.getString("publisher_name"), rs.getString("img"), rs.getString("category_name"), rs.getString("description"));

                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    
    public int getTotalBookByCat(String category){
        String sql = "select count(*) from book b join category c on c.category_id=b.category_id where c.category_name = '"+category+"' ";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }
    
    public List<Book> getBookByCategory(String category, int index) {
        List<Book> list = new ArrayList<>();
        String sql = "select * from book b\n" +
"join category c on c.category_id=b.category_id\n" +
"where c.category_name = '"+category+"'\n" +
"order by book_id\n" +
"OFFSET "+(index-1)*8+" ROWS FETCH NEXT 8 ROWS ONLY";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Book s = new Book(rs.getInt("num_pages"), rs.getInt("quantity"), rs.getInt("book_id"), rs.getDouble("price"), rs.getString("title"), rs.getString("author_name"), rs.getString("isbn13"), rs.getString("language_name"), rs.getString("publication_date"), rs.getString("publisher_name"), rs.getString("img"), rs.getString("category_name"), rs.getString("description"));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }
    public static void main(String[] args) {
        BookDAO dbb = new BookDAO();
        List<Book> list = dbb.getBookByOrder("43");
        for(Book b : list){
            System.out.println(b.toString());
        }
    }
}
