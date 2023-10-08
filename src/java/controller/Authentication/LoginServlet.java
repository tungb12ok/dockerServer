/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Authentication;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import DAO.*;
import entity.User;
import jakarta.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tungl
 */
public class LoginServlet extends HttpServlet {

    UserDao dao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("signin.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        MD5 m = new MD5();
        String md5Password = m.md5Hash(password);
        User u = new User();
        u = dao.checkAuthentication(username, md5Password);
        HttpSession session = request.getSession();
        MentorDAO mentorDAO = new MentorDAO();
        CustomerDAO customerDAO = new CustomerDAO();
        String mess = "";
        if (u != null) {
            if (u.getStatus() == 0) {
                mess = "Account was blocked by ADMIN !!!";
                request.setAttribute("mess", mess);
                request.getRequestDispatcher("signin.jsp").forward(request, response);
            } else {
                if (u.getRoleID() == 1) {
                    session.setAttribute("account", u);
                    response.sendRedirect("admin");
                } else if (u.getRoleID() == 2) {
                    session.setAttribute("account", mentorDAO.getMentorWhenLogin(username));
                    response.sendRedirect("mentor");
                } else {
                    session.setAttribute("account", customerDAO.getCustomerWhenLogin(username));
                    response.sendRedirect("home");
                }
            }
        } else {
            mess = "Username and password not correct!";
            request.setAttribute("mess", mess);
            request.getRequestDispatcher("signin.jsp").forward(request, response);
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
