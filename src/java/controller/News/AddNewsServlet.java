/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.News;

import DAO.CourseDAO;
import DAO.NewsDAO;
import DAO.NewsTypeDAO;
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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author msi
 */
@WebServlet(name = "AddNewsServlet", urlPatterns = {"/addNews"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5)

public class AddNewsServlet extends HttpServlet {

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
        User u = (User) session.getAttribute("account");
        NewsTypeDAO ntDAO = new NewsTypeDAO();
        if (u != null) {
            if (u.getRoleID() == 1) {
                request.setAttribute("newsType", ntDAO.listAllNewsType());
                request.getRequestDispatcher("addNews.jsp").forward(request, response);
            } else if (u.getRoleID() == 2) {
                Mentor mentor = (Mentor) session.getAttribute("account");
                request.getRequestDispatcher("addNews.jsp").forward(request, response);
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

        //String title, String image, String createDate, String newsContent, String createBy, int CourseID
        String title = request.getParameter("title");
        //String image = request.getParameter("image");
        String avatar;
        Part filePart = request.getPart("image");
        avatar = filePart.getSubmittedFileName();
        String savePath = "C:\\Users\\msi\\Desktop\\GR4-GIT\\swp391-su23-group4\\SWP391\\web\\assets\\img";
        String filePath = savePath + File.separator + avatar;
        String ava = "assets/img/" + avatar;
        // Lưu file ảnh vào thư mục images trên server
        filePart.write(filePath);

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // Chuyển LocalDate thành String
        String dateString = date.format(formatter);

        String content = request.getParameter("description");
        String author = u.getFull_name();
        int type = Integer.parseInt(request.getParameter("NewsType"));

        //add news
        NewsDAO newsDAO = new NewsDAO();
        newsDAO.addNews(title, ava, dateString, content, author, type);
        String messSuccess = "Add news successful";
        request.setAttribute("messSuccess", messSuccess);
        request.getRequestDispatcher("addNews.jsp").forward(request, response);
    }

}
