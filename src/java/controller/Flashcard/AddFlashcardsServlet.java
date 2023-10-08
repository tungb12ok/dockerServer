/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Flashcard;

import DAO.CourseDAO;
import DAO.FlashCardDetailDAO;
import DAO.FlashcardsDAO;
import entity.CourseModule;
import entity.FlashCardDetail;
import entity.Flashcards;
import entity.User;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 *
 * @author asus
 */
@WebServlet(name = "FlashcardsServlet", urlPatterns = {"/AddFlashcards"})
public class AddFlashcardsServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("addFlashcards.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        entity.Flashcards fl = new Flashcards();
        User user = (User) request.getSession().getAttribute("account");
        fl.setTitle(request.getParameter("title"));
        fl.setAuthor(user.getId());
        FlashcardsDAO flDAO = new FlashcardsDAO();
        FlashCardDetailDAO fdDAO = new FlashCardDetailDAO();

        Enumeration<String> parameterNames = request.getParameterNames();
        List<FlashCardDetail> lfd = new ArrayList<>();
        while (parameterNames.hasMoreElements()) {
            String paramName = parameterNames.nextElement();
            if (paramName.contains("question")) {
                FlashCardDetail cm = new FlashCardDetail();
                cm.setQuestion(request.getParameter(paramName));
                String linkParamName = paramName.replace("question", "answer");
                String answer = request.getParameter(linkParamName);
                cm.setAnswer(answer);
                lfd.add(cm);
            }
        }
        flDAO.addFlashcard(fl); // Thêm flashcard
        int fl_ID = flDAO.getFLIDJustAdded();
        for (FlashCardDetail fcd : lfd) {
            fdDAO.addFLDetailByFLID(fl_ID, fcd.getQuestion(), fcd.getAnswer()); // Thêm chi tiết flashcard vào lcm
        }

        String messSuccess = "Add Flash card successful";
        request.setAttribute("messSuccess", messSuccess);
        request.getRequestDispatcher("addFlashcards.jsp").forward(request, response);
    }
}
