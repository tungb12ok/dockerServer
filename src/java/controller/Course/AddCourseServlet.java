/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Course;

import DAO.CourseDAO;
import DAO.CourseTypeDAO;
import entity.CourseModule;
import entity.Mentor;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 *
 * @author msi
 */
@WebServlet(name = "AddCourseServlet", urlPatterns = {"/addCourse"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5)
public class AddCourseServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet AddCourseServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet AddCourseServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("account");
        if (u != null) {
            if (u.getRoleID() != 3) {
                CourseTypeDAO dao = new CourseTypeDAO();
                request.setAttribute("listType", dao.listCourseTypeClientSite());
                request.getRequestDispatcher("addCourse.jsp").forward(request, response);
            } else {
                session.setAttribute("account", null);
                response.sendRedirect("401.jsp");

            }
        } else {
            session.setAttribute("account", null);
            response.sendRedirect("401.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        CourseDAO courseDAO = new CourseDAO();
        request.setAttribute("listCourse", courseDAO.listAllCourse());

        HttpSession session = request.getSession();
        User u = (User) session.getAttribute("account");

        //
        int mentor_id = 0;
        String name = request.getParameter("name");
        String avatar;
        Part filePart = request.getPart("image");
        avatar = filePart.getSubmittedFileName();
//        String savePath = "C:\\Users\\msi\\Desktop\\GR4-GIT\\swp391-su23-group4\\SWP391\\web\\assets\\img";

        // Thay vì sử dụng đường dẫn tuyệt đối:
// String savePath = "C:\\Users\\tungl\\Downloads\\SWP391 (1)\\SWP391\\web\\assets\\img";
// Sử dụng đường dẫn tương đối từ thư mục gốc của dự án
        String relativePath = request.getServletContext().getRealPath("/assets/img");
        String filePath = relativePath + File.separator + avatar;
        String ava = "assets/img/" + avatar;

        // Lưu file ảnh vào thư mục images trên server
        filePart.write(filePath);
        //
        String description = request.getParameter("description");
        double price = Double.parseDouble(request.getParameter("price"));
        if (u.getRoleID() == 2) {
            Mentor mentor = (Mentor) session.getAttribute("account");
            mentor_id = mentor.getMentor_id();
        }
        // Get Current Date
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dateString = date.format(formatter);

        //Get Type of Course
        int type_id = Integer.parseInt(request.getParameter("typeID"));

        // Get the name of the module of the course
        Enumeration<String> parameterNames = request.getParameterNames();
        List<CourseModule> lcm = new ArrayList<>();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            if (paramName.contains("module")) {
                CourseModule cm = new CourseModule();
                cm.setModuleName(request.getParameter(paramName));

                String linkParamName = paramName.replace("module", "link");
                String linkValue = request.getParameter(linkParamName);
                String linkEmbed = courseDAO.convertYouTubeLinkToEmbed(linkValue);
                cm.setLink(linkEmbed);
                lcm.add(cm);
            }
        }
        courseDAO.addCourse(name, description, type_id, price, dateString, mentor_id, ava, 0);
        int course_id = courseDAO.getLastestCourseID();
        for (CourseModule courseModule : lcm) {
            courseDAO.addModule(course_id, courseModule.getModuleName(), courseModule.getLink());
        }
        String messSuccess = "Add course successful";
        request.setAttribute("messSuccess", messSuccess);
        request.getRequestDispatcher("addCourse.jsp").forward(request, response);
    }
}
