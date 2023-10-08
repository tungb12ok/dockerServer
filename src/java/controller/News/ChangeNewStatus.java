/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.News;

import DAO.NewsDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * @author msi
 */
@WebServlet(name = "ChangeNewStatus", urlPatterns = {"/changeNews"})
public class ChangeNewStatus extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_raw = request.getParameter("id");
        int id;
        NewsDAO nDAO = new NewsDAO();
        id = Integer.parseInt(id_raw);
        if (nDAO.getStatusByID(id).getStatus() == 1) {
            nDAO.changeStatusType(id, 0);
            response.sendRedirect("news");
        } else {
            nDAO.changeStatusType(id, 1);
            response.sendRedirect("news");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
