/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package controller;

import dal.UserDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

/**
 *
 * @author Admin
 */
public class EditProfileServlet extends HttpServlet {
   

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String username=request.getParameter("username");
        String fname=request.getParameter("fname");
        String lname=request.getParameter("lname");
        String email=request.getParameter("email");
        String address=request.getParameter("address");
        UserDAO dbu = new UserDAO();
        HttpSession session=request.getSession();
        User oldu = (User) session.getAttribute("user");
        String oldusername = oldu.getUserName();
        String oldpass = oldu.getPass();
        User u = new User(fname, lname, email, username, oldpass, address, 0, 0);
        dbu.updateUser(u, oldusername, oldpass);
        session.setAttribute("user", u);

        request.getRequestDispatcher("Account.jsp").forward(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        String curpass = request.getParameter("curpassword");
        String npass = request.getParameter("npassword");
        String rnpass = request.getParameter("rnpassword");
        
        UserDAO dbu = new UserDAO();
        HttpSession session=request.getSession();
        User oldu = (User) session.getAttribute("user");
        
        if(!curpass.equals(oldu.getPass())){
            String err = "Invalid password!";
            request.setAttribute("err", err);
            request.getRequestDispatcher("Account.jsp").forward(request, response);
        }else if(!npass.equals(rnpass)){
            String err = "Invalid password!";
            request.setAttribute("err", err);
            request.getRequestDispatcher("Account.jsp").forward(request, response);
        }else{
        User u = new User(oldu.getFirstN(), oldu.getLastN(), oldu.getEmail(), oldu.getUserName(), npass, oldu.getAddress(), 0, 0);
        dbu.updateUser(u, oldu.getUserName(), npass);
        session.setAttribute("user", u);
        String mess = "Changed password successfully!";
        request.setAttribute("mess", mess);
        request.getRequestDispatcher("Account.jsp").forward(request, response);
        }
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
