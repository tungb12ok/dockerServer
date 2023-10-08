/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Order;

import DAO.CourseDAO;
import DAO.MentorDAO;
import DAO.OrderDAO;
import entity.Mentor;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author tungl
 */
@WebServlet(name = "ProcessingOrder", urlPatterns = {"/pOrder"})
public class ProcessingOrder extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OrderDAO dao = new OrderDAO();
        MentorDAO mDAO = new MentorDAO();
        CourseDAO cDAO = new CourseDAO();
        cDAO.getCourseByID(dao.listAllOrder().get(0).getCourseID()).getCourse_name();
        int cID = Integer.parseInt(request.getParameter("cID"));
        double total = Double.parseDouble(request.getParameter("total"));
        int id = Integer.parseInt(request.getParameter("id"));
        dao.updateOrderStatus(id, 1);
        mDAO.updateMentorAmount(cDAO.getCourseByID(cID).getMentorID(), (double) (0.9 * total));
        response.sendRedirect("OrderList");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
