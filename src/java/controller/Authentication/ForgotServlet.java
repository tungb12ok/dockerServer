/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.Authentication;

import DAO.UserDao;
import entity.User;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import controller.sendMail.*;
import jakarta.servlet.ServletContext;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;

/**
 *
 * @author tungl
 */
public class ForgotServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String mailCurrent = request.getParameter("email");
        request.setAttribute("email", mailCurrent);
        request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // create object
        String mailCurrent;
        Boolean status = false;
        UserDao dao = new UserDao();
        MD5 m = new MD5();
        EmailConfig emailConfig = new EmailConfig();
        CodeRandom code = new CodeRandom();
        ForgotServlet forgot = new ForgotServlet();
        // create variable
        String getAction = request.getParameter("resetPassword");
        final ServletContext servletContext = getServletContext();
        mailCurrent = request.getParameter("email");
        User u = dao.searchAccountByMail(mailCurrent);
        String codeRandom = code.randomCode();

        if (getAction.equalsIgnoreCase("reset password")) {
            String resetPassword = m.md5Hash(codeRandom);
            request.setAttribute("user", u);
            if (u == null) {
                String mess = "Email does not exist!";
                request.setAttribute("mess", mess);
            } else {
                try {
                    emailConfig.SendEmail(mailCurrent, "Reset Password", "Code reset password: " + codeRandom);
                } catch (MessagingException ex) {
                    Logger.getLogger(ForgotServlet.class.getName()).log(Level.SEVERE, null, ex);
                    response.getWriter().print(ex.getMessage());
                }
            }
            servletContext.setAttribute("myVariable", codeRandom);
            // Lập lịch xóa biến sau 1 phút
            TimerTask removeVariableTask = new TimerTask() {
                @Override
                public void run() {
                    servletContext.removeAttribute("myVariable");
                }
            };
            ///////////////////////////////////////////////////
            Timer timer = new Timer();
            timer.schedule(removeVariableTask, 90 * 1000); // 1 phút = 60 giây * 1000 mili giây
            //====================================================================
            request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
        }
        if (servletContext.getAttribute("myVariable") == null) {
            request.setAttribute("mess", "The code has expired!");
            u = null;
            request.setAttribute("user", u);
            request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
        }
        if (getAction.equalsIgnoreCase("change password")) {

            // Lấy giá trị biến
            if (servletContext.getAttribute("myVariable") != null) {
                String myVariable = (String) servletContext.getAttribute("myVariable");
                mailCurrent = request.getParameter("email");
                String password = request.getParameter("oldPassword");
                if (!password.equalsIgnoreCase(myVariable)) {
                    String mess2 = "Code not correct!";
                    request.setAttribute("mess2", mess2);
                    request.setAttribute("user", u);
                    request.getRequestDispatcher("resetPassword.jsp").forward(request, response);
                } else {
                    String newPassword = request.getParameter("password1");
                    dao.resetPassword(mailCurrent, m.md5Hash(newPassword));
                    response.sendRedirect("login");
                }
            }

        }
    }

}
