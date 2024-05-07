/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.BookDAO;
import dal.CategoryDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Book;
import model.Category;

/**
 *
 * @author Admin
 */
public class ListServlet extends HttpServlet {
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        BookDAO dbb = new BookDAO();
        CategoryDAO dbc = new CategoryDAO();
        
        String rwindex = request.getParameter("index");
        int index = 1;
        
        if(rwindex!=null){
            index=Integer.parseInt(rwindex);
        }
        int count = dbb.getTotalBook();
        int endP = count/8;
        if(count%8!=0){
            endP++;
        }
        request.setAttribute("endP", endP);
        List<Category> cat = dbc.getAll();
        request.setAttribute("categories", cat);
        List<Book> books = dbb.pagingBook(index);
        request.setAttribute("data", books);
        request.getRequestDispatcher("products.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        
    }


    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
