/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.BookDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;
import model.Book;

/**
 *
 * @author Admin
 */
public class OrderDetailServlet extends HttpServlet {
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String orderID = request.getParameter("orderid");
        BookDAO dbb = new BookDAO();
        List<Book> list = dbb.getBookByOrder(orderID);
        request.setAttribute("data", list);
        request.getRequestDispatcher("OrderDetail.jsp").forward(request, response);
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
