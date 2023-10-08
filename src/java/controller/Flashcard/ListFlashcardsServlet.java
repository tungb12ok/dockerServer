/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Flashcard;

import DAO.FlashCardDetailDAO;
import DAO.FlashcardsDAO;
import DAO.UserDao;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 *
 * @author asus
 */
@WebServlet(name = "ListFlashcardsServlet", urlPatterns = {"/FlashCard/cardTitle/*"})
public class ListFlashcardsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        UserDao uDAO = new UserDao();
        String pathInfo = request.getPathInfo();
        if (pathInfo != null) {
            String url = pathInfo.substring(1);
            FlashCardDetailDAO fdDAO = new FlashCardDetailDAO();
            FlashcardsDAO fDAO = new FlashcardsDAO();
            response.getWriter().print("url"+url);
            int id = fDAO.searchFlashcardByURL(url).getId();
            request.setAttribute("uDAO", uDAO);
            request.setAttribute("fl", fDAO.searchFlashcardByURL(url));
            request.setAttribute("listFlashcards", fdDAO.listFLDetailByFLID(id));
            request.getRequestDispatcher("/FlashCard/FlashCards.jsp").forward(request, response);
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
