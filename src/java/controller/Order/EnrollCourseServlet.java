/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Order;

import DAO.CustomerDAO;
import DAO.OrderDAO;
import entity.Order;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author msi
 */
@WebServlet(name = "EnrollCourseServlet", urlPatterns = {"/enroll"})
public class EnrollCourseServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("account");
        Order o = new Order();
        CustomerDAO cDAO = new CustomerDAO();
        OrderDAO oDAO = new OrderDAO();
        o.setPaymentMethod("Pay TpBank");
        o.setStatusOrder(0);
        o.setTotalMoney(Double.parseDouble(request.getParameter("amount")));
        o.setCustomerID(cDAO.getCustomerByUserID(u.getId()).getCustomer_id());
        o.setDate(getCurrentDate());
        o.setOrderCode(request.getParameter("billCode"));
        o.setCourseID(Integer.parseInt(request.getParameter("courseID")));
        oDAO.insertOrder(o);
        request.setAttribute("mess", "Đơn hàng của bạn đang được xử lí......");
        response.sendRedirect("course/" + request.getParameter("URL"));
    }

    public String getCurrentDate() {
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Format the date as a string
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        String formattedDate = currentDate.format(formatter);

        // Return the formatted date string
        return formattedDate;
    }
}
