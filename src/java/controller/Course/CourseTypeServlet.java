/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Course;

import DAO.CourseTypeDAO;
import DAO.UserDao;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author msi
 */
@WebServlet(name = "CourseTypeServlet", urlPatterns = {"/courseType"})
public class CourseTypeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("account");
        if (u != null) {
            if (u.getRoleID() == 1) {
                CourseTypeDAO dao = new CourseTypeDAO();
                request.setAttribute("listType", dao.listAllCourseType());
                request.getRequestDispatcher("listCourseType.jsp").forward(request, response);
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
        String type = request.getParameter("type");
        String description = request.getParameter("description");
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        // Chuyển LocalDate thành String
        String dateString = date.format(formatter);
        CourseTypeDAO dao = new CourseTypeDAO();
        if (dao.getTypeByName(type) == null) {
            dao.addType(type, dateString,description);
            request.setAttribute("listType", dao.listAllCourseType());
            request.getRequestDispatcher("listCourseType.jsp").forward(request, response);
        } else {
            request.setAttribute("msg", "Type Exist");
            request.setAttribute("listType", dao.listAllCourseType());
            request.getRequestDispatcher("listCourseType.jsp").forward(request, response);
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
