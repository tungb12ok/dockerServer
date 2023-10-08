/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.News;

import DAO.NewsDAO;
import entity.News;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;

/**
 *
 * @author Mai
 */
@WebServlet(name = "UpdateNewsServlet", urlPatterns = {"/updateNews"})
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5)
public class UpdateNewsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NewsDAO newsDAO = new NewsDAO();
        String id_raw = request.getParameter("id");
        try {
            if (id_raw != null) {
                int id = Integer.parseInt(id_raw);
                News n = newsDAO.getNewsByID(id);
                request.setAttribute("updateNews", n);
            }
        } catch (NumberFormatException e) {
        }
        request.getRequestDispatcher("updateNews.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        NewsDAO newsDAO = new NewsDAO();
        String id_raw = request.getParameter("newsid");
        String utitle = request.getParameter("title");
        String avatar;
        Part filePart = request.getPart("image");
        avatar = filePart.getSubmittedFileName();
        String savePath = "C:\\Users\\msi\\Desktop\\GR4-GIT\\swp391-su23-group4\\SWP391\\web\\assets\\img";
        String filePath = savePath + File.separator + avatar;
        String ava = "assets/img/" + avatar;
        // Lưu file ảnh vào thư mục images trên server
        filePart.write(filePath);
        String unewsContent = request.getParameter("description");
        String type_raw = request.getParameter("NewsType");
        try {
            int id = Integer.parseInt(id_raw);
            int type = Integer.parseInt(type_raw);
            newsDAO.updateNewsByID(id, utitle, ava, unewsContent, type);
            News n = newsDAO.getNewsByID(id);
            request.setAttribute("updateNews", n);
            request.setAttribute("messSuccess", "Update successful");
        } catch (NumberFormatException e) {
        }
        request.getRequestDispatcher("updateNews.jsp").forward(request, response);
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
