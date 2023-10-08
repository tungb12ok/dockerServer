/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controller.UserProfile;

import DAO.CustomerDAO;
import DAO.MentorDAO;
import DAO.UserDao;
import entity.Customer;
import entity.Mentor;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author msi
 */
@MultipartConfig(fileSizeThreshold = 1024 * 1024, maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5)
public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("profile.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        MentorDAO mentor = new MentorDAO();
        CustomerDAO customer = new CustomerDAO();
        UserDao dao = new UserDao();

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("account");
        String messUpdate = "Update successful";
        String messErrPhone = "Please enter 10 digits";
        String birth = request.getParameter("birth");
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String skill = request.getParameter("skill");
        String job = request.getParameter("job");

        // get the image address and convert it to string
        String avatar;
        Part filePart = request.getPart("image");
        avatar = filePart.getSubmittedFileName();
        PrintWriter out = response.getWriter();

        if (phone.length() != 10) {
            request.setAttribute("messErrPhone", messErrPhone);
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        } else {
            if (user.getRoleID() == 2) {
                Mentor men = (Mentor) session.getAttribute("account");
                if (avatar.isEmpty() == false) {
                    String savePath = "C:\\Users\\msi\\Desktop\\GR4-GIT\\swp391-su23-group4\\SWP391\\web\\assets\\img";
                    String filePath = savePath + File.separator + avatar;
                    String ava = "assets/img/" + avatar;
                    // Lưu file ảnh vào thư mục images trên server
                    filePart.write(filePath);
                    men.setAvatar(ava);
                } else {
                    men.setAvatar(dao.getAvatarbyID(men.getId()));
                }
                men.setBirth(birth);
                men.setFull_name(name);
                men.setPhone(phone);
                men.setSkill(skill);
                men.setJob(job);
                mentor.updateMentor(user.getId(), men.getPhone(), men.getFull_name(), men.getBirth(), men.getSkill(), men.getJob(), men.getAvatar());
                request.setAttribute("messUpdate", messUpdate);
                request.getRequestDispatcher("profile.jsp").forward(request, response);

            } else if (user.getRoleID() == 3) {
                Customer cus = (Customer) session.getAttribute("account");
                if (avatar.isEmpty() == false) {
                    String savePath = "C:\\Users\\msi\\Desktop\\GR4-GIT\\swp391-su23-group4\\SWP391\\web\\assets\\img";
                    String filePath = savePath + File.separator + avatar;
                    String ava = "assets/img/" + avatar;
                    // Lưu file ảnh vào thư mục images trên server
                    filePart.write(filePath);
                    cus.setAvatar(ava);
                } else {
                    cus.setAvatar(dao.getAvatarbyID(cus.getId()));
                }
                cus.setBirth(birth);
                cus.setFull_name(name);
                cus.setPhone(phone);
                cus.setAddress(address);
                customer.updateCustomer(user.getId(), cus.getPhone(), cus.getFull_name(), cus.getBirth(), cus.getAddress(), cus.getAvatar());
                request.setAttribute("messUpdate", messUpdate);
                request.getRequestDispatcher("profile.jsp").forward(request, response);
            }
        }
    }

}
