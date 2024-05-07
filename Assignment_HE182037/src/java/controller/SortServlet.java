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
import java.util.ArrayList;
import java.util.List;
import model.Book;
import model.Category;

/**
 *
 * @author Admin
 */
public class SortServlet extends HttpServlet {
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String category = request.getParameter("category");
        BookDAO dbb = new BookDAO();
        String rwindex = request.getParameter("index");
        int index = 1;
        
        if(rwindex!=null){
            index=Integer.parseInt(rwindex);
        }
        int count = dbb.getTotalBookByCat(category);
        int endP = count/8;
        if(count%8!=0){
            endP++;
        }
        request.setAttribute("endP", endP);
        List<Book> books = dbb.getBookByCategory(category, index);
        CategoryDAO dbc = new CategoryDAO();
        List<Category> cats = dbc.getAll();
        
        request.setAttribute("categories", cats);
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
