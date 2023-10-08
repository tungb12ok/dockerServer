/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entity.Mentor;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author msi
 */
public class MentorDAO extends MyDAO {

    public void registerMentor(int user_id) {
        String sql = "INSERT INTO Mentor (UserID,Amount) VALUES (?, 0)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, user_id);
            ps.executeUpdate();
            ps.close();

        } catch (Exception e) {
        }
    }

    public Mentor getMentorWhenLogin(String input) {
        String sql = "SELECT u.ID, u.Full_name, u.[E-mail], u.Phone, "
                + "u.[Date of Birth], u.Avatar ,m.Job,m.Skills, u.Role, m.ID, m.Amount "
                + "FROM Mentor m\n"
                + "JOIN [User] u\n"
                + "ON m.UserID = u.ID WHERE u.Username = ? OR u.[E-mail] = ? ";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, input);
            ps.setString(2, input);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mentor mentor = new Mentor();
                mentor.setId(rs.getInt(1));
                mentor.setFull_name(rs.getString(2));
                mentor.setMail(rs.getString(3));
                mentor.setPhone(rs.getString(4));
                mentor.setBirth(rs.getString(5));
                mentor.setAvatar(rs.getString(6));
                mentor.setJob(rs.getString(7));
                mentor.setSkill(rs.getString(8));
                mentor.setRoleID(rs.getInt(9));
                mentor.setMentor_id(rs.getInt(10));
                mentor.setAmount(rs.getDouble(11));
                return mentor;
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
        }
        return null;
    }

    public void updateMentor(int id, String phone, String name, String dob,
            String skill, String job, String avatar) {
        String sql = "UPDATE [dbo].[User]\n"
                + "   SET   \n"
                + "      [Full_name] = ?\n"
                + "      ,[Phone] = ?\n"
                + "      ,[Date of Birth] = ?\n"
                + "      ,[Avatar] = ?\n"
                + " WHERE ID = ?\n"
                + " \n"
                + "UPDATE [dbo].[Mentor]\n"
                + "   SET [Skills] = ?\n"
                + "      ,[Job] = ?\n"
                + " WHERE [UserID] = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, dob);
            ps.setString(4, avatar);
            ps.setInt(5, id);
            ps.setString(6, skill);
            ps.setString(7, job);
            ps.setInt(8, id);
            rs = ps.executeQuery();

            ps.close();
            rs.close();
        } catch (Exception e) {
        }
    }

    public void updateMentorAmount(int id, double a) {
        String sql = "UPDATE [dbo].[Mentor]\n"
                + "   SET [Amount] = ? + [Amount]\n"
                + " WHERE ID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setDouble(1, a);
            ps.setInt(2, id);
            rs = ps.executeQuery();
            ps.close();
            rs.close();
        } catch (Exception e) {
        }
    }

    public List<Mentor> listAllMentor() {
        String sql = "SELLECT M.ID, u.Full_name, u.[E-mail], u.Phone, "
                + "u.[Date of Birth], u.Avatar,   M.Job,M.Skills,u.Status, "
                + "COUNT(C.ID) AS NumCourses\n"
                + "FROM dbo.Mentor M\n"
                + "JOIN dbo.Course C ON M.ID = C.Mentor_ID\n"
                + "JOIN dbo.[User] u ON u.ID = M.UserID WHERE u.Status = 1\n"
                + "GROUP BY u.ID, u.Full_name, u.[E-mail], u.Phone, "
                + "u.[Date of Birth], u.Avatar, M.ID, M.Skills, M.Job, u.Status\n"
                + "ORDER BY NumCourses DESC";
        List<Mentor> lm = new ArrayList<>();
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mentor mentor = new Mentor();
                mentor.setMentor_id(rs.getInt(1));
                mentor.setFull_name(rs.getString(2));
                mentor.setMail(rs.getString(3));
                mentor.setPhone(rs.getString(4));
                mentor.setBirth(rs.getString(5));
                mentor.setAvatar(rs.getString(6));
                mentor.setJob(rs.getString(7));
                mentor.setSkill(rs.getString(8));
                mentor.setStatus(rs.getInt(9));
                lm.add(mentor);
            }
        } catch (Exception e) {
        }
        return lm;
    }

    public List<Mentor> top3MentorHasMostCourse() {
        String sql = "SELECT TOP 3 M.ID, u.Full_name, u.[E-mail], u.Phone, "
                + "u.[Date of Birth], u.Avatar,   M.Job,M.Skills,u.Status, "
                + "COUNT(C.ID) AS NumCourses\n"
                + "FROM dbo.Mentor M\n"
                + "JOIN dbo.Course C ON M.ID = C.Mentor_ID\n"
                + "JOIN dbo.[User] u ON u.ID = M.UserID WHERE u.Status = 1\n"
                + "GROUP BY u.ID, u.Full_name, u.[E-mail], u.Phone, "
                + "u.[Date of Birth], u.Avatar, M.ID, M.Skills, M.Job, u.Status\n"
                + "ORDER BY NumCourses DESC";
        List<Mentor> lm = new ArrayList<>();
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mentor mentor = new Mentor();
                mentor.setMentor_id(rs.getInt(1));
                mentor.setFull_name(rs.getString(2));
                mentor.setMail(rs.getString(3));
                mentor.setPhone(rs.getString(4));
                mentor.setBirth(rs.getString(5));
                mentor.setAvatar(rs.getString(6));
                mentor.setJob(rs.getString(7));
                mentor.setSkill(rs.getString(8));
                mentor.setStatus(rs.getInt(9));
                lm.add(mentor);
            }
        } catch (Exception e) {
        }
        return lm;
    }

    public List<Mentor> mentorPage() {
        String sql = "SELECT  M.ID, u.Full_name, u.[E-mail], u.Phone, "
                + "u.[Date of Birth], u.Avatar,   M.Job,M.Skills,u.Status, "
                + "COUNT(C.ID) AS NumCourses\n"
                + "FROM dbo.Mentor M\n"
                + "LEFT JOIN dbo.Course C ON M.ID = C.Mentor_ID\n"
                + "JOIN dbo.[User] u ON u.ID = M.UserID\n"
                + "GROUP BY u.ID, u.Full_name, u.[E-mail], u.Phone, "
                + "u.[Date of Birth], u.Avatar, M.ID, M.Skills, M.Job, u.Status\n"
                + "ORDER BY NumCourses DESC";
        List<Mentor> lm = new ArrayList<>();
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mentor mentor = new Mentor();
                mentor.setMentor_id(rs.getInt(1));
                mentor.setFull_name(rs.getString(2));
                mentor.setMail(rs.getString(3));
                mentor.setPhone(rs.getString(4));
                mentor.setBirth(rs.getString(5));
                mentor.setAvatar(rs.getString(6));
                mentor.setJob(rs.getString(7));
                mentor.setSkill(rs.getString(8));
                mentor.setStatus(rs.getInt(9));
                lm.add(mentor);
            }
        } catch (Exception e) {
        }
        return lm;
    }

    public Mentor getMentorByID(String name) {
        String sql = "SELECT m.ID, u.Full_name, u.[E-mail], u.Phone, "
                + "u.[Date of Birth], u.Avatar ,m.Job,m.Skills, u.Status "
                + "FROM Mentor m\n"
                + "JOIN [User] u\n"
                + "ON m.UserID = u.ID WHERE u.[Full_name] = ? ";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mentor mentor = new Mentor();
                mentor.setMentor_id(rs.getInt(1));
                mentor.setFull_name(rs.getString(2));
                mentor.setMail(rs.getString(3));
                mentor.setPhone(rs.getString(4));
                mentor.setBirth(rs.getString(5));
                mentor.setAvatar(rs.getString(6));
                mentor.setJob(rs.getString(7));
                mentor.setSkill(rs.getString(8));
                mentor.setStatus(rs.getInt(9));
                return mentor;
            }
        } catch (Exception e) {
        }

        return null;
    }
}
