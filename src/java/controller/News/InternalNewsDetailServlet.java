/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.News;

import DAO.NewsDAO;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author msi
 */
@WebServlet(name = "InternalNewsDetailServlet", urlPatterns = {"/internalNews"})
public class InternalNewsDetailServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("account");
        if (u != null) {
            if (u.getRoleID() == 1 || u.getRoleID() == 2) {
                NewsDAO dao = new NewsDAO();
                int id = Integer.parseInt(request.getParameter("id"));
                request.setAttribute("news", dao.getNewsByID(id));
                request.setAttribute("listNewsInternal", dao.listNewsAccepted(1, 1));
                request.getRequestDispatcher("internalNews.jsp").forward(request, response);
            } else {
                session.setAttribute("account", null);
                response.sendRedirect("401.jsp");
            }
        } else {
            session.setAttribute("account", null);
            response.sendRedirect("401.jsp");
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
