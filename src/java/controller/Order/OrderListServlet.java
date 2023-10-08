/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Order;

import DAO.CourseDAO;
import DAO.CustomerDAO;
import DAO.OrderDAO;
import DAO.UserDao;
import entity.Order;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author tungl
 */
@WebServlet(name = "OrderListServlet", urlPatterns = {"/OrderList"})
public class OrderListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        OrderDAO oDAO = new OrderDAO();
        CourseDAO cDAO = new CourseDAO();
        
        CustomerDAO cmDAO = new CustomerDAO();
        UserDao uDAO = new UserDao();
        List<Order> list = oDAO.listAllOrder();
        request.setAttribute("uDAO", uDAO);
        request.setAttribute("cmDAO", cmDAO);
        request.setAttribute("cDAO", cDAO);
        request.setAttribute("list", list);
        request.getRequestDispatcher("listOrder.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("orderList.jsp").forward(request, response);

    }
}
