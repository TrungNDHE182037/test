/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.BookDAO;
import dal.OrderDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Book;
import model.User;

/**
 *
 * @author Admin
 */
public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cookie[] arr = request.getCookies();
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("user");
        OrderDAO dbo = new OrderDAO();
        if (action.equalsIgnoreCase("add")) {
            String id = request.getParameter("id");
            String title = request.getParameter("title");
            String txt = "";
            if (arr != null) {
                for (Cookie o : arr) {
                    if (o.getName().equals("cart")) {
                        txt += o.getValue();
                        o.setMaxAge(0);
                        response.addCookie(o);
                    }
                }
            }
            if (id != null) {
                if (txt.isEmpty()) {
                    txt = id;
                } else {
                    txt = txt + "/" + id;
                }
            }
            Cookie c = new Cookie("cart", txt);
            c.setMaxAge(3 * 24 * 60 * 60);
            response.addCookie(c);
            BookDAO dbb = new BookDAO();
            Book b = dbb.getBookByTitle(title);
            request.setAttribute("data", b);
            String redirect = "detail?title=" + title;
            response.sendRedirect(redirect);
        } else if (action.equalsIgnoreCase("clear")) {
            String path = request.getContextPath();
            if (arr != null) {
                for (Cookie o : arr) {
                    if (o.getName().equals("cart")) {
                        o.setMaxAge(0);
                        response.addCookie(o);
                        response.sendRedirect("home");
                    }
                }
            }
        } else if (action.equalsIgnoreCase("checkout")) {;
            int orderID = dbo.addOrder(u.getId());
            if (arr != null) {
                for (Cookie o : arr) {
                    if (o.getName().equals("cart")) {
                        String txt = o.getValue();
                        String[] a = txt.split("/");
                        dbo.addOrderLine(a, orderID);
                        o.setMaxAge(0);
                        response.addCookie(o);
                        response.sendRedirect("home");
                    }
                }
            }
        } else if (action.equalsIgnoreCase("view")) {
            
        }

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
