/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.News;

import DAO.NewsTypeDAO;
import entity.User;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author msi
 */
@WebServlet(name = "NewsTypeServlet", urlPatterns = {"/newsType"})
public class NewsTypeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NewsTypeDAO ntDAO = new NewsTypeDAO();
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("account");
        if (u != null) {
            if (u.getRoleID() == 1) {
                request.setAttribute("type", ntDAO.listAllNewsType());
                request.getRequestDispatcher("newsType.jsp").forward(request, response);
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
        NewsTypeDAO ntDAO = new NewsTypeDAO();
        String type = request.getParameter("type");
        String description = request.getParameter("description");
        if (ntDAO.checkTypeExist(type) != null) {
            request.setAttribute("msg", "Type exist");
            request.setAttribute("type", ntDAO.listAllNewsType());
            request.getRequestDispatcher("newsType.jsp").forward(request, response);
        } else {
            ntDAO.addNews(type, description);
            request.setAttribute("msg", "Add successfull");
            request.setAttribute("type", ntDAO.listAllNewsType());
            request.getRequestDispatcher("newsType.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
