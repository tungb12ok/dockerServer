/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.News;

import DAO.NewsTypeDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditNewsTypeServlet", urlPatterns = {"/editNewsType"})
public class EditNewsTypeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NewsTypeDAO ntDAO = new NewsTypeDAO();
        int id = Integer.parseInt(request.getParameter("id"));
        request.setAttribute("typeUpdate", ntDAO.getTypeByID(id));
        request.setAttribute("type", ntDAO.listAllNewsType());
        request.getRequestDispatcher("newsType.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NewsTypeDAO ntDAO = new NewsTypeDAO();
        request.setAttribute("type", ntDAO.listAllNewsType());
        int id = Integer.parseInt(request.getParameter("id"));
        String type = request.getParameter("type");
        String description = request.getParameter("description");
        if (ntDAO.checkTypeExist(type) != null) {
            request.setAttribute("msgU", "Type exist");
            request.setAttribute("type", ntDAO.listAllNewsType());
            request.getRequestDispatcher("newsType.jsp").forward(request, response);
        } else {
            ntDAO.updateNews(type, description, id);
            request.setAttribute("msgU", "Update successfull");
            request.setAttribute("type", ntDAO.listAllNewsType());
            request.getRequestDispatcher("newsType.jsp").forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
