/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entity.NewsType;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author msi
 */
public class NewsTypeDAO extends MyDAO {

    public List<NewsType> listAllNewsType() {
        String sql = "SELECT [ID]\n"
                + "      ,[Type_name]\n"
                + "      ,[Description]\n"
                + "      ,[URL]\n"
                + "  FROM [dbo].[NewsType]";
        List<NewsType> lnt = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                NewsType nt = new NewsType();
                nt.setTypeID(rs.getInt(1));
                nt.setTypeName(rs.getString(2));
                nt.setTypeDescription(rs.getString(3));
                nt.setTypeURL(rs.getString(4));
                lnt.add(nt);
            }
        } catch (Exception e) {
        }
        return lnt;
    }

    public NewsType getTypeByID(int id) {
        String sql = "SELECT [ID]\n"
                + "      ,[Type_name]\n"
                + "      ,[Description]\n"
                + "      ,[URL]\n"
                + "  FROM [dbo].[NewsType] WHERE ID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                NewsType nt = new NewsType();
                nt.setTypeID(rs.getInt(1));
                nt.setTypeName(rs.getString(2));
                nt.setTypeDescription(rs.getString(3));
                nt.setTypeURL(rs.getString(4));
                return nt;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public String convert(String text) {
        String normalizedText = Normalizer.normalize(text, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalizedText).replaceAll("").replaceAll("Đ", "D").replaceAll("đ", "d").toLowerCase();
    }

    public void updateNews(String type, String description, int id) {
        String sql = "UPDATE [dbo].[NewsType]\n"
                + "   SET [Type_name] = ? \n"
                + "      ,[Description] = ?\n"
                + "      ,[URL] = ?\n"
                + " WHERE ID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, type);
            ps.setString(2, description);
            ps.setString(3, convert(type).toLowerCase().replaceAll("\\s", "-"));
            ps.setInt(4, id);
            rs = ps.executeQuery();

        } catch (Exception e) {
        }
    }

    public void addNews(String type, String description) {
        String sql = "INSERT INTO [dbo].[NewsType]\n"
                + "           ([Type_name]\n"
                + "           ,[Description]\n"
                + "           ,[URL])\n"
                + "     VALUES(?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, type);
            ps.setString(2, description);
            ps.setString(3, convert(type).toLowerCase().replaceAll("\\s", "-"));
            rs = ps.executeQuery();

        } catch (Exception e) {
        }
    }

    public NewsType checkTypeExist(String type) {
        String sql = "SELECT ID FROM NewsType WHERE Type_name = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, type);
            rs = ps.executeQuery();
            while (rs.next()) {
                NewsType nt = new NewsType();
                nt.setTypeID(rs.getInt(1));
                return nt;
            }
        } catch (Exception e) {
        }
        return null;
    }
}
