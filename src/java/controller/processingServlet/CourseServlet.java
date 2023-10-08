/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.processingServlet;

import DAO.CourseDAO;
import DAO.CustomerDAO;
import DAO.OrderDAO;
import controller.Authentication.CodeRandom;
import entity.Course;
import entity.Customer;
import entity.Order;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.text.Normalizer;
import java.util.regex.Pattern;

/**
 *
 * @author tungl
 */
@WebServlet("/course/*")
public class CourseServlet extends HttpServlet {

    public String convert(String text) {
        String normalizedText = Normalizer.normalize(text, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalizedText).replaceAll("").replaceAll("Đ", "D").replaceAll("đ", "d").toLowerCase();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pathInfo = request.getPathInfo();
        String courseURL = pathInfo.substring(1);

        // Thiết lập các thuộc tính cho trang course_detail.jsp
        if (pathInfo != null) {
            CourseDAO dao = new CourseDAO();
            OrderDAO oDAO = new OrderDAO();
            HttpSession session = request.getSession();
            Customer u = (Customer) session.getAttribute("account");
            Course c = dao.getCourseByURL(courseURL);
            // Thiết lập các thuộc tính cho trang course_detail.jsp
            request.setAttribute("course", c);
            request.setAttribute("module", dao.listModuleByCourseID(c.getID()));
            CodeRandom cr = new CodeRandom();
            String randomCode = cr.randomCode();
            if (u != null) {
                Order checkBuyOrder = oDAO.checkBuy(u.getCustomer_id(), c.getID());
                request.setAttribute("orderBuy", checkBuyOrder);
            }
            String billCode = convert(dao.getCourseByID(c.getID()).getCourse_name().toUpperCase().replaceAll("\\s+", ""));
            if (billCode.length() > 10) {
                request.setAttribute("BillCode", billCode.substring(0, 10) + randomCode);
            } else {
                request.setAttribute("BillCode", billCode + randomCode);
            }

            // Chuyển hướng yêu cầu và truyền dữ liệu sang trang course_detail.jsp
            request.getRequestDispatcher("/course_detail.jsp").forward(request, response);
        }
//        response.getWriter().print("halo");

    }

}
