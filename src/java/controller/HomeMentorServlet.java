/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.CourseDAO;
import DAO.UserDao;
import entity.Mentor;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author msi
 */
@WebServlet(name = "HomeMentorServlet", urlPatterns = {"/mentor"})
public class HomeMentorServlet extends HttpServlet {

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Mentor m = (Mentor) session.getAttribute("account");
        if (m != null) {
            if (m.getRoleID() == 2) {
                //List User
                CourseDAO courseDAO = new CourseDAO();
                request.setAttribute("listCourseByMentor", courseDAO.listCourseByMentor(m.getMentor_id()));
                request.getRequestDispatcher("mentorHome.jsp").forward(request, response);
            } else {
                session.setAttribute("account", null);
                response.sendRedirect("401.jsp");

            }
        } else {
            session.setAttribute("account", null);
            response.sendRedirect("401.jsp");
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
