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
import model.Book;

/**
 *
 * @author Admin
 */
public class AddBookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String title = request.getParameter("title");
        String author = request.getParameter("author");
        String isbn = request.getParameter("isbn");
        String lang = request.getParameter("lang");
        String rwpagenum = request.getParameter("pagenum");
        String pubname = request.getParameter("pubname");
        String pubdate = request.getParameter("pubdate");
        String rwquantity = request.getParameter("quantity");
        String category = request.getParameter("category");
        String rwprice = request.getParameter("price");
        String des = request.getParameter("des");
        String img = request.getParameter("img");
        int pagenum = Integer.parseInt(rwpagenum);
        int quantity = Integer.parseInt(rwquantity);
        double price = Double.parseDouble(rwprice);
        BookDAO dbb = new BookDAO();
        
            Book b = new Book(pagenum, quantity,0, price, title, author, isbn, lang, pubdate, pubname, img, category, des);
            
            dbb.addBook(b);
            response.sendRedirect("manage");
        
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
