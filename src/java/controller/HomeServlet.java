/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller;

import DAO.CourseDAO;
import DAO.CourseTypeDAO;
import DAO.MentorDAO;
import DAO.UserDao;
import entity.Course;
import entity.CourseType;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.util.List;

/**
 *
 * @author tungl
 */
public class HomeServlet extends HttpServlet {

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
        //List Course Type
        CourseTypeDAO CTDao = new CourseTypeDAO();
        List<CourseType> Lct = CTDao.listCourseTypeClientSite();
        request.setAttribute("CourseType", Lct);

        //List Course
        CourseDAO CDao = new CourseDAO();
        List<Course> Lc = CDao.listCourseClientSite();
        request.setAttribute("Course", Lc);

        //List Mentor
        MentorDAO mDao = new MentorDAO();
        session.setAttribute("mentor", mDao.top3MentorHasMostCourse());

        UserDao userDAO = new UserDao();
        session.setAttribute("numberStudent", userDAO.countUser(3));
        session.setAttribute("numberMentor", userDAO.countUser(2));
        session.setAttribute("numberType", CTDao.count());
        session.setAttribute("numberCourse", CDao.count());
        request.getRequestDispatcher("home.jsp").forward(request, response);

    }

}
