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
import model.User;

/**
 *
 * @author Admin
 */
public class UserDAO extends DBContext{
    
    public void deleteUser(String username){
        String sql = "DELETE FROM [dbo].[order_line]\n" +
"      WHERE order_id in\n" +
"(select order_id from cust_order where customer_id = \n" +
"(select customer_id from customer where user_name = '"+username+"'));\n" +
"\n" +
"delete from cust_order\n" +
"where customer_id= (select customer_id from customer where user_name = '"+username+"');\n" +
"\n" +
"delete from customer where user_name = '"+username+"';";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    public List<User> getall(){
        List<User> list = new ArrayList<>();
        String sql = "select * from customer";
        
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                User s = new User(rs.getString("first_name"), rs.getString("last_name"),rs.getString("email"),rs.getString("user_name"), rs.getString("pass"), rs.getString("address_name"), rs.getInt("role"), rs.getInt("customer_id"));
                list.add(s);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        
        return list;
    }
    
    public User getUserByName(String name){
        String sql = "select * from customer where user_name='"+name+"'";
        
         try {
            PreparedStatement st = connection.prepareStatement(sql); 
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                User u = new User(rs.getString("first_name"), rs.getString("last_name"),rs.getString("email"),rs.getString("user_name"), rs.getString("pass"), rs.getString("address_name"), rs.getInt("role"), rs.getInt("customer_id"));
                return u;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
        
    }
    public void signUp(User u){
        String sql = "INSERT INTO [dbo].[customer] ([first_name] ,[last_name] ,[email] ,[user_name] ,[pass] ,[role] ,[address_name])\n" +
"VALUES (null ,null ,null ,'"+u.getUserName()+"' ,'"+u.getPass()+"' ,0 ,null)";
        try {
            PreparedStatement st = connection.prepareStatement(sql); 
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
    public void updateUser(User u, String oldun, String oldpass){
        String sql = "UPDATE [dbo].[customer]\n" +
"   SET [first_name] = '"+u.getFirstN()+"'\n" +
"      ,[last_name] = '"+u.getLastN()+"'\n" +
"      ,[email] = '"+u.getEmail()+"'\n" +
"      ,[user_name] = '"+u.getUserName()+"'\n" +
"      ,[pass] = '"+oldpass+"'\n" +
"      ,[role] = 0\n" +
"      ,[address_name] = '"+u.getAddress()+"'\n" +
" WHERE user_name='"+oldun+"'";
        try {
            PreparedStatement st = connection.prepareStatement(sql); 
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
}
