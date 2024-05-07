/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author Admin
 */
public class SignUpServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDAO dbu = new UserDAO();

        String username = request.getParameter("username");
        String pass = request.getParameter("pass");
        String repass = request.getParameter("repass");
        String r = request.getParameter("rem");

        Cookie cu = new Cookie("cuser", username);
        Cookie cp = new Cookie("cpass", pass);
        Cookie cr = new Cookie("crem", r);

        if (r != null) {
            cu.setMaxAge(60 * 60 * 24 * 7);
            cp.setMaxAge(60 * 60 * 24 * 7);
            cr.setMaxAge(60 * 60 * 24 * 7);
        } else {
            cu.setMaxAge(0);
            cp.setMaxAge(0);
            cr.setMaxAge(0);
        }
        response.addCookie(cu);
        response.addCookie(cp);
        response.addCookie(cr);

        User u = dbu.getUserByName(username);

        if (u != null) {
            String err = "User already existed!";
            request.setAttribute("err", err);
            request.getRequestDispatcher("SignUp.jsp").forward(request, response);
        } else if (!repass.equals(pass)) {
            String err = "Invalid password!";
            request.setAttribute("err", err);
            request.getRequestDispatcher("SignUp.jsp").forward(request, response);
        } else {
            User user = new User(null, null, null, username, pass, null, 0, 0);
            dbu.signUp(user);
            response.sendRedirect("SignIn.jsp");
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
