/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controler.vnpay;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import DAO.*;
import entity.*;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author tungl
 */
@WebServlet(name = "ReturnVNPAYServlet", urlPatterns = {"/vnpay/ReturnVNPAY"})
public class ReturnVNPAYServlet extends HttpServlet {

    OrderDAO oDAO = new OrderDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("account");
                MentorDAO mDAO = new MentorDAO();
                CourseDAO courseDAO = new CourseDAO();

        //Begin process return from VNPAY
        Map fields = new HashMap();
        for (Enumeration params = request.getParameterNames(); params.hasMoreElements();) {
            String fieldName = URLEncoder.encode((String) params.nextElement(), StandardCharsets.US_ASCII.toString());
            String fieldValue = URLEncoder.encode(request.getParameter(fieldName), StandardCharsets.US_ASCII.toString());
            if ((fieldValue != null) && (fieldValue.length() > 0)) {
                fields.put(fieldName, fieldValue);
            }
        }

        String vnp_SecureHash = request.getParameter("vnp_SecureHash");
        if (fields.containsKey("vnp_SecureHashType")) {
            fields.remove("vnp_SecureHashType");
        }
        if (fields.containsKey("vnp_SecureHash")) {
            fields.remove("vnp_SecureHash");
        }
        Order o = new Order();
        CustomerDAO cDAO = new CustomerDAO();

        o.setPaymentMethod("VNPAY");

        o.setStatusOrder(1);
        o.setTotalMoney(Double.parseDouble(request.getParameter("vnp_Amount")));
        o.setCustomerID(cDAO.getCustomerByUserID(u.getId()).getCustomer_id());
        o.setOrderCode(request.getParameter("vnp_ResponseCode"));
        o.setDate(getCurrentDate());
        o.setCourseID(Integer.parseInt((String) session.getAttribute("courseID")));
        oDAO.insertOrder(o);
        mDAO.updateMentorAmount(courseDAO.getCourseByID(Integer.parseInt((String) session.getAttribute("courseID"))).getMentorID(),  o.getTotalMoney() * 0.9 / 100);

        String signValue = Config.hashAllFields(fields);

        request.getRequestDispatcher("vnpay_return.jsp").forward(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
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
