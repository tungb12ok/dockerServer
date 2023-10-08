/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entity.CourseType;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author msi
 */
public class CourseTypeDAO extends MyDAO {

    public List<CourseType> listAllCourseType() {
        String sql = "SELECT [ID]\n"
                + "      ,[Type_Name]\n"
                + "      ,[Date_Create_Course]\n"
                + "      ,[Status]\n"
                + "      ,[Description]\n"
                + "      ,[Modified_date]\n"
                + "  FROM [dbo].[CourseType] ORDER BY ID DESC";
        List<CourseType> lct = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CourseType type = new CourseType();
                type.setTypeID(rs.getInt(1));
                type.setType_name(rs.getString(2));
                type.setCreated_date(rs.getString(3));
                type.setStatus(rs.getInt(4));
                type.setDescription(rs.getString(5));
                type.setModified_date(rs.getString(6));
                lct.add(type);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lct;
    }

    public List<CourseType> listCourseTypeClientSite() {
        String sql = "SELECT [ID]\n"
                + "      ,[Type_Name]\n"
                + "      ,[Date_Create_Course]\n"
                + "      ,[Status]\n"
                + "      ,[Description]\n"
                + "  FROM [dbo].[CourseType] WHERE Status = 1";
        List<CourseType> lct = new ArrayList<>();
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                CourseType type = new CourseType();
                type.setTypeID(rs.getInt(1));
                type.setType_name(rs.getString(2));
                type.setCreated_date(rs.getString(3));
                type.setStatus(rs.getInt(4));
                type.setDescription(rs.getString(5));
                lct.add(type);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return lct;
    }

    public int count() {
        String sql = "SELECT COUNT(*) AS Total\n"
                + "FROM [CourseType]";

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

    public void addType(String type, String created_date, String description) {
        String sql = "INSERT INTO [dbo].[CourseType]\n"
                + "           ([Type_Name]\n"
                + "           ,[Date_Create_Course]\n"
                + "           ,[Status]\n"
                + "           ,[Description])\n"
                + "     VALUES\n"
                + "           (?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, type);
            ps.setString(2, created_date);
            ps.setInt(3, 0);
            ps.setString(4, description);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
        }
    }

    public CourseType getTypeByName(String type) {
        String sql = "SELECT [ID]\n"
                + "      ,[Type_Name]\n"
                + "      ,[Date_Create_Course]\n"
                + "      ,[Status]\n"
                + "      ,[Description]\n"
                + "  FROM [dbo].[CourseType] WHERE [Type_Name] = ? ";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, type);
            rs = ps.executeQuery();
            while (rs.next()) {
                CourseType ct = new CourseType();
                ct.setTypeID(rs.getInt(1));
                ct.setType_name(rs.getString(2));
                ct.setCreated_date(rs.getString(3));
                return ct;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void updateCourseTypeByID(int id, String name, String dateUpdate, String description) {
        String sql = "UPDATE [dbo].[CourseType]\n"
                + "SET [Type_Name] = ?, "
                + "[Date_Create_Course] = ?, "
                + "[Description] = ?\n"
                + "WHERE id = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, dateUpdate);
            ps.setString(3, description);
            ps.setInt(4, id);
            rs = ps.executeQuery();

            ps.close();
            rs.close();
        } catch (Exception e) {
        }
    }

    public CourseType getTypeByID(int id) {
        String sql = "SELECT [ID]\n"
                + "      ,[Type_Name]\n"
                + "      ,[Date_Create_Course]\n"
                + "      ,[Status]\n"
                + "      ,[Description]\n"
                + "  FROM [dbo].[CourseType] WHERE [ID] = ? ";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                CourseType ct = new CourseType();
                ct.setTypeID(rs.getInt(1));
                ct.setType_name(rs.getString(2));
                ct.setCreated_date(rs.getString(3));
                ct.setStatus(rs.getInt(4));
                ct.setDescription(rs.getString(5));
                return ct;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void changeStatusType(int type_id, int status) {
        String sql = "UPDATE [dbo].[CourseType]\n"
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

    public CourseType getStatusByID(int id) {
        String sql = "SELECT [Status]  FROM [CourseType] WHERE ID = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                CourseType ct = new CourseType();
                ct.setStatus(rs.getInt(1));
                return ct;
            }
            ps.close();
        } catch (Exception e) {
        }
        return null;
    }
}
