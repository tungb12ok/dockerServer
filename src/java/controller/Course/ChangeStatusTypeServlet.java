/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Course;

import DAO.CourseTypeDAO;
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
@WebServlet(name = "ChangeStatusTypeServlet", urlPatterns = {"/change"})
public class ChangeStatusTypeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id_raw = request.getParameter("id");
        int id;
        CourseTypeDAO ctDao = new CourseTypeDAO();
        id = Integer.parseInt(id_raw);
        if (ctDao.getStatusByID(id).getStatus() == 1) {
            ctDao.changeStatusType(id, 0);
            response.sendRedirect("courseType");
        } else {
            ctDao.changeStatusType(id, 1);
            response.sendRedirect("courseType");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
