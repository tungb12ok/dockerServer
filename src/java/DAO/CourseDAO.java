/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entity.Course;
import entity.CourseModule;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CourseDAO extends MyDAO {

    public List<Course> listAllCourse() {
        String sql = "SELECT c.[ID]\n"
                + "      ,[Course_name]\n"
                + "      ,c.[Description]\n"
                + "      ,Type_Name\n"
                + "      ,[Price]\n"
                + "      ,[Public_Date]\n"
                + "      ,[Mentor_ID]\n"
                + "      ,[Image]\n"
                + "      ,c.[Status]\n"
                + "      ,c.[URL]\n"
                + "  FROM [dbo].[Course] c\n"
                + "  JOIN CourseType ct ON c.Type_ID = ct.ID";
        List<Course> lc = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setID(rs.getInt(1));
                course.setCourse_name(rs.getString(2));
                course.setDescription(rs.getString(3));
                course.setType_name(rs.getString(4));
                course.setPrice(rs.getDouble(5));
                course.setPublic_date(rs.getString(6));
                course.setMentorID(rs.getInt(7));
                course.setImage(rs.getString(8));
                course.setStatus(rs.getInt(9));
                course.setURL(rs.getString(10));
                lc.add(course);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lc;
    }

    public List<Course> listAllCourseClient() {
        String sql = "SELECT c.[ID]\n"
                + "      ,[Course_name]\n"
                + "      ,c.[Description]\n"
                + "      ,Type_Name\n"
                + "      ,[Price]\n"
                + "      ,[Public_Date]\n"
                + "      ,[Mentor_ID]\n"
                + "      ,[Image]\n"
                + "      ,c.[Status]\n"
                + ",c.[URL]"
                + "  FROM [dbo].[Course] c\n"
                + "  JOIN CourseType ct ON c.Type_ID = ct.ID WHERE c.[Status] = 1";
        List<Course> lc = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setID(rs.getInt(1));
                course.setCourse_name(rs.getString(2));
                course.setDescription(rs.getString(3));
                course.setType_name(rs.getString(4));
                course.setPrice(rs.getDouble(5));
                course.setPublic_date(rs.getString(6));
                course.setMentorID(rs.getInt(7));
                course.setImage(rs.getString(8));
                course.setStatus(rs.getInt(9));
                course.setURL(rs.getString(10));
                lc.add(course);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lc;
    }

    public List<Course> get3NewCourse() {
        String sql = "SELECT TOP 3 FROM Course ORDER BY ID DESC";
        List<Course> lc = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setID(rs.getInt(1));
                course.setCourse_name(rs.getString(2));
                course.setDescription(rs.getString(3));
                course.setType_ID(rs.getInt(4));
                course.setPrice(rs.getDouble(5));
                course.setPublic_date(rs.getString(6));
                course.setMentorID(rs.getInt(7));
                course.setImage(rs.getString(8));
                course.setStatus(rs.getInt(9));
                lc.add(course);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lc;
    }

    public void addCourse(String Course_name, String Description, int Type_ID, double price, String Public_date, int MentorID, String Image, int Status) {
        String sql = "INSERT INTO [dbo].[Course]\n"
                + "           ([Course_name]\n"
                + "           ,[Description]\n"
                + "           ,[Type_ID]\n"
                + "           ,[Price]\n"
                + "           ,[Public_Date]\n"
                + "           ,[Mentor_ID]\n"
                + "           ,[Image]\n"
                + "           ,[Status]\n"
                + "           ,[URL])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?,?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, Course_name);
            ps.setString(2, Description);
            ps.setInt(3, Type_ID);
            ps.setDouble(4, price);
            ps.setString(5, Public_date);
            ps.setInt(6, MentorID);
            ps.setString(7, Image);
            ps.setInt(8, Status);
            ps.setString(9, convert(Course_name).replaceAll("\\s", "-").toLowerCase());
            ps.executeQuery();
        } catch (Exception e) {
        }
    }

    public int getLastestCourseID() {
        String sql = "SELECT TOP 1 ID FROM Course ORDER BY ID DESC";
        int id = 0;
        try {
            PreparedStatement ps2 = con.prepareStatement(sql);
            ResultSet rs2 = ps2.executeQuery();
            while (rs2.next()) {
                id = rs2.getInt(1);
            }
        } catch (Exception e) {

        }
        return id;
    }

    public void addModule(int courseId, String moduleName, String link) {
        String sql = "INSERT INTO [dbo].[CourseModule]\n"
                + "           ([CourseID]\n"
                + "           ,[ModuleName]\n"
                + "           ,[Link])\n"
                + "     VALUES(?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, courseId);
            ps.setString(2, moduleName);
            ps.setString(3, link);
            ps.executeUpdate();
        } catch (Exception e) {
        }

    }

    public int count() {
        String sql = "SELECT COUNT(*) AS Total\n"
                + "FROM [Course]";

        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                return count;
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public List<Course> listCourseByMentor(int mentor_id) {
        String sql = "SELECT c.[ID]\n"
                + "      ,[Course_name]\n"
                + "      ,c.[Description]\n"
                + "      ,Type_Name\n"
                + "      ,[Price]\n"
                + "      ,[Public_Date]\n"
                + "      ,[Mentor_ID]\n"
                + "      ,[Image]\n"
                + "      ,c.[Status]\n"
                + ", c.[URL]"
                + "  FROM [dbo].[Course] c\n"
                + "  JOIN CourseType ct ON c.Type_ID = ct.ID  WHERE Mentor_ID = ? ";
        List<Course> lc = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, mentor_id);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setID(rs.getInt(1));
                course.setCourse_name(rs.getString(2));
                course.setDescription(rs.getString(3));
                course.setType_name(rs.getString(4));
                course.setPrice(rs.getDouble(5));
                course.setPublic_date(rs.getString(6));
                course.setMentorID(rs.getInt(7));
                course.setImage(rs.getString(8));
                course.setStatus(rs.getInt(9));
                course.setURL(rs.getString(10));
                lc.add(course);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lc;
    }

    public List<Course> listCourseByType(String CourseName) {
        String sql = "SELECT c.[ID]\n"
                + "      ,[Course_name]\n"
                + "      ,c.[Description]\n"
                + "      ,ct.[Type_Name]\n"
                + "      ,[Price]\n"
                + "      ,[Public_Date]\n"
                + "      ,u.Full_name\n"
                + "      ,[Image]\n"
                + "      ,c.[Status]\n"
                + "      ,c.[URL]\n"
                + "  FROM [dbo].[Course] c\n"
                + "  JOIN CourseType ct ON c.Type_ID = ct.ID\n"
                + "  JOIN Mentor m ON m.ID = c.Mentor_ID\n"
                + "  JOIN [User] u ON m.UserID = u.ID\n"
                + "  WHERE ct.[Type_Name] = ? AND c.[Status] = 1";
        List<Course> lc = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, CourseName);
            rs = ps.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setID(rs.getInt(1));
                course.setCourse_name(rs.getString(2));
                course.setDescription(rs.getString(3));
                course.setType_name(rs.getString(4));
                course.setPrice(rs.getDouble(5));
                course.setPublic_date(rs.getString(6));
                course.setMentor_name(rs.getString(7));
                course.setImage(rs.getString(8));
                course.setStatus(rs.getInt(9));
                course.setURL(rs.getString(10));
                lc.add(course);
            }
        } catch (Exception e) {
        }
        return lc;
    }

    public List<Course> listCourseClientSite() {
        String sql = "SELECT c.[ID]\n"
                + "      ,[Course_name]\n"
                + "      ,c.[Description]\n"
                + "      ,Type_Name\n"
                + "      ,[Price]\n"
                + "      ,[Public_Date]\n"
                + "      ,u.Full_name\n"
                + "      ,[Image]\n"
                + "      ,c.[Status]\n"
                + ",c.[URL]\n"
                + "  FROM [dbo].[Course] c\n"
                + "  JOIN CourseType ct ON c.Type_ID = ct.ID\n"
                + "  JOIN Mentor m ON m.ID = c.Mentor_ID\n"
                + "  JOIN [User] u ON m.UserID = u.ID WHERE c.Status = 1 ORDER BY ID";
        List<Course> lc = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setID(rs.getInt(1));
                course.setCourse_name(rs.getString(2));
                course.setDescription(rs.getString(3));
                course.setType_name(rs.getString(4));
                course.setPrice(rs.getDouble(5));
                course.setPublic_date(rs.getString(6));
                course.setMentor_name(rs.getString(7));
                course.setImage(rs.getString(8));
                course.setStatus(rs.getInt(9));
                course.setURL(rs.getString(10));
                lc.add(course);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lc;
    }

    public Course getCourseByID(int course_id) {
        String sql = "SELECT c.[ID]\n"
                + "    ,[Course_name]\n"
                + "    ,c.[Description]\n"
                + "    ,ct.[Type_Name]\n"
                + "    ,[Price]\n"
                + "    ,[Public_Date]\n"
                + "    ,u.Full_name\n"
                + "    ,[Image]\n"
                + "    ,c.[Status]\n"
                + "    ,c.Mentor_ID\n"
                + "FROM [dbo].[Course] c\n"
                + "JOIN CourseType ct ON c.Type_ID = ct.ID\n"
                + "JOIN Mentor m ON m.ID = c.Mentor_ID\n"
                + "JOIN [User] u ON m.UserID = u.ID\n"
                + "WHERE c.ID = " + course_id;
        Course course = new Course();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                course.setID(rs.getInt(1));
                course.setCourse_name(rs.getString(2));
                course.setDescription(rs.getString(3));
                course.setType_name(rs.getString(4));
                course.setPrice(rs.getDouble(5));
                course.setPublic_date(rs.getString(6));
                course.setMentor_name(rs.getString(7));
                course.setImage(rs.getString(8));
                course.setStatus(rs.getInt(9));
                course.setMentorID(rs.getInt(10));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return course;
    }

    public void changeStatusType(int type_id, int status) {
        String sql = "UPDATE [dbo].[Course]\n"
                + "	SET [Status] = ?\n"
                + "	WHERE ID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, status);
            ps.setInt(2, type_id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
        }

    }

    public List<CourseModule> listModuleByCourseID(int id) {
        String sql = "SELECT [ModuleID]\n"
                + "      ,[CourseID]\n"
                + "      ,[ModuleName]\n"
                + "      ,[Link]\n"
                + "  FROM [dbo].[CourseModule] WHERE CourseID = ?";
        List<CourseModule> lcm = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                CourseModule cm = new CourseModule();
                cm.setId(rs.getInt(1));
                cm.setCourseId(id);
                cm.setModuleName(rs.getString(3));
                cm.setLink(rs.getString(4));
                lcm.add(cm);
            }
        } catch (Exception e) {
        }
        return lcm;
    }

    public List<Course> listCourseBySearchPart(String txt) {
        String sql = "SELECT c.[ID]\n"
                + "      ,[Course_name]\n"
                + "      ,c.[Description]\n"
                + "      ,Type_Name\n"
                + "      ,[Price]\n"
                + "      ,[Public_Date]\n"
                + "      ,u.Full_name\n"
                + "      ,[Image]\n"
                + "      ,c.[Status]\n"
                + "      ,c.[URL]\n"
                + "  FROM [dbo].[Course] c\n"
                + "  JOIN CourseType ct ON c.Type_ID = ct.ID\n"
                + "  JOIN Mentor m ON m.ID = c.Mentor_ID\n"
                + "  JOIN [User] u ON m.UserID = u.ID WHERE c.Status = 1  AND c.Course_name  LIKE '%" + txt + "%' ORDER BY ID";
        List<Course> lc = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Course course = new Course();
                course.setID(rs.getInt(1));
                course.setCourse_name(rs.getString(2));
                course.setDescription(rs.getString(3));
                course.setType_name(rs.getString(4));
                course.setPrice(rs.getDouble(5));
                course.setPublic_date(rs.getString(6));
                course.setMentor_name(rs.getString(7));
                course.setImage(rs.getString(8));
                course.setStatus(rs.getInt(9));
                course.setURL(rs.getString(10));
                lc.add(course);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lc;
    }

    public Course getCourseByURL(String url) {
        String sql = "SELECT c.[ID]\n"
                + "    ,[Course_name]\n"
                + "    ,c.[Description]\n"
                + "    ,ct.[Type_Name]\n"
                + "    ,[Price]\n"
                + "    ,[Public_Date]\n"
                + "    ,u.Full_name\n"
                + "    ,[Image]\n"
                + "    ,c.[Status]\n"
                + "    ,c.Mentor_ID\n"
                + "FROM [dbo].[Course] c\n"
                + "JOIN CourseType ct ON c.Type_ID = ct.ID\n"
                + "JOIN Mentor m ON m.ID = c.Mentor_ID\n"
                + "JOIN [User] u ON m.UserID = u.ID\n"
                + "WHERE c.URL = '" + url + "'";
        Course course = new Course();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                course.setID(rs.getInt(1));
                course.setCourse_name(rs.getString(2));
                course.setDescription(rs.getString(3));
                course.setType_name(rs.getString(4));
                course.setPrice(rs.getDouble(5));
                course.setPublic_date(rs.getString(6));
                course.setMentor_name(rs.getString(7));
                course.setImage(rs.getString(8));
                course.setStatus(rs.getInt(9));
                course.setMentorID(rs.getInt(10));
                course.setURL(url);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return course;
    }

    public String convertYouTubeLinkToEmbed(String link) {
        String videoId = "";

        String[] splitUrl = link.split("[?&]");
        for (String param : splitUrl) {
            if (param.startsWith("v=")) {
                videoId = param.substring(2);
                break;
            }
        }

        String embedUrl = "https://www.youtube.com/embed/" + videoId;
        return embedUrl;
    }

    public String convert(String text) {
        String normalizedText = Normalizer.normalize(text, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalizedText).replaceAll("").replaceAll("Đ", "D").replaceAll("đ", "d");
    }
}
