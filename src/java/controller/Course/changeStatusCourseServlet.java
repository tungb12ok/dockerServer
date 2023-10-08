/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Course;

import DAO.CourseDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author msi
 */
@WebServlet(name = "changeStatusCourseServlet", urlPatterns = {"/changeCourse"})
public class changeStatusCourseServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                String id_raw = request.getParameter("id");
        int id;
        CourseDAO cDAO = new CourseDAO();
        id = Integer.parseInt(id_raw);
        if (cDAO.getCourseByID(id).getStatus() == 1) {
            cDAO.changeStatusType(id, 0);
            response.sendRedirect("mentor");
        } else {
            cDAO.changeStatusType(id, 1);
            response.sendRedirect("mentor");
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
