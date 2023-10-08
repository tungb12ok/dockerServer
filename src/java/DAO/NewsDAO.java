/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entity.News;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author Mai
 */
public class NewsDAO extends MyDAO {

    public void updateNewsByID(int id, String title, String image, String newsContent, int type) {
        String sql = "UPDATE [dbo].[News]\n"
                + "   SET [Title] =?\n"
                + "      ,[Image] = ?\n"
                + "      ,[NewsContent] = ? \n"
                + "      ,[Status] = 0\n"
                + "      ,[Type] = ?\n"
                + "      ,[URL] = ?\n"
                + " WHERE [NewsID] = ? ";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, image);
            ps.setString(3, newsContent);
            ps.setInt(4, type);
            ps.setString(5, convert(title).toLowerCase().replaceAll("\\s", "-"));
            ps.setInt(6, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
        }
    }

    public String convert(String text) {
        String normalizedText = Normalizer.normalize(text, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalizedText).replaceAll("").replaceAll("Đ", "D").replaceAll("đ", "d").toLowerCase();
    }

    public List<News> listAllNews() {
        String sql = "SELECT [NewsID]\n"
                + "      ,[Title]\n"
                + "      ,[Image]\n"
                + "      ,[Create_Date]\n"
                + "      ,[NewsContent]\n"
                + "      ,[Create_By]\n"
                + "      ,[Status]\n"
                + "      ,[Type]\n"
                + "         ,[URL]\n"
                + "  FROM [dbo].[News] ORDER BY NewsID DESC";
        List<News> ln = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                News news = new News();
                news.setNewsID(rs.getInt(1));
                news.setTitle(rs.getString(2));
                news.setImage(rs.getString(3));
                news.setCreated_date(rs.getString(4));
                news.setContent(rs.getString(5));
                news.setCreate_by(rs.getString(6));
                news.setStatus(rs.getInt(7));
                news.setType(rs.getInt(8));
                news.setURL(rs.getString(9));
                ln.add(news);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return ln;
    }

    public int addNews(String title, String image, String createDate, String newsContent, String createBy, int type) {
        int x = -99;
        String sql = "INSERT INTO [dbo].[News]\n"
                + "           ([Title]\n"
                + "           ,[Image]\n"
                + "           ,[Create_Date]\n"
                + "           ,[NewsContent]\n"
                + "           ,[Create_By]\n"
                + "           ,[Status]\n"
                + "           ,[Type]\n"
                + "           ,[URL])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, title);
            ps.setString(2, image);
            ps.setString(3, createDate);
            ps.setString(4, newsContent);
            ps.setString(5, createBy);
            ps.setInt(6, 0);
            ps.setInt(7, type);
            ps.setString(8, convert(title).replaceAll("\\s", "-"));
            x = ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return x;
    }

    public List<News> listAllNewsByMentor(String username) {
        String sql = "SELECT [NewsID]\n"
                + "      ,[Title]\n"
                + "      ,[Image]\n"
                + "      ,[Create_Date]\n"
                + "      ,[NewsContent]\n"
                + "      ,[Create_By]\n"
                + "      ,[Status]\n"
                + "      ,[Type]\n"
                + "      ,[URL]\n"
                + "  FROM [dbo].[News] WHERE Create_By =  ?";
        List<News> ln = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                News news = new News();
                news.setNewsID(rs.getInt(1));
                news.setTitle(rs.getString(2));
                news.setImage(rs.getString(3));
                news.setCreated_date(rs.getString(4));
                news.setContent(rs.getString(5));
                news.setCreate_by(rs.getString(6));
                news.setStatus(rs.getInt(7));
                news.setType(rs.getInt(8));
                news.setURL(rs.getString(9));
                ln.add(news);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return ln;
    }

    public List<News> listNewsAccepted(int status, int type) {
        String sql = "SELECT TOP 2[NewsID]\n"
                + "      ,[Title]\n"
                + "      ,[Image]\n"
                + "      ,[Create_Date]\n"
                + "      ,[NewsContent]\n"
                + "      ,[Create_By]\n"
                + "      ,[Status]\n"
                + "      ,[Type]\n"
                + ",[URL]\n"
                + "  FROM [dbo].[News]  WHERE Status = ? AND Type = ? ORDER BY NewsID DESC";
        List<News> ln = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, status);
            ps.setInt(2, type);
            rs = ps.executeQuery();
            while (rs.next()) {
                News news = new News();
                news.setNewsID(rs.getInt(1));
                news.setTitle(rs.getString(2));
                news.setImage(rs.getString(3));
                news.setCreated_date(rs.getString(4));
                news.setContent(rs.getString(5));
                news.setCreate_by(rs.getString(6));
                news.setStatus(rs.getInt(7));
                news.setType(rs.getInt(8));
                news.setURL(rs.getString(9));
                ln.add(news);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return ln;
    }

    public News getStatusByID(int id) {
        String sql = "SELECT [Status]  FROM [News] WHERE NewsID = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                News news = new News();
                news.setStatus(rs.getInt(1));
                return news;
            }
            ps.close();
        } catch (Exception e) {
        }
        return null;
    }

    public void changeStatusType(int newsID, int status) {
        String sql = "UPDATE [dbo].[News]\n"
                + "	SET [Status] = ?\n"
                + "	WHERE NewsID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, status);
            ps.setInt(2, newsID);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
        }

    }

    public News getNewsByID(int id) {
        String sql = "SELECT [NewsID]\n"
                + "      ,[Title]\n"
                + "      ,[Image]\n"
                + "      ,[Create_Date]\n"
                + "      ,[NewsContent]\n"
                + "      ,[Create_By]\n"
                + "      ,[Status]\n"
                + "      ,[Type]\n"
                + "      ,[URL]\n"
                + "  FROM [dbo].[News] WHERE NewsID = ? ";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                News news = new News();
                news.setNewsID(rs.getInt(1));
                news.setTitle(rs.getString(2));
                news.setImage(rs.getString(3));
                news.setCreated_date(rs.getString(4));
                news.setContent(rs.getString(5));
                news.setCreate_by(rs.getString(6));
                news.setStatus(rs.getInt(7));
                news.setType(rs.getInt(8));
                news.setURL(rs.getString(9));
                return news;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public News getNewsByURL(String url) {
        String sql = "SELECT [NewsID]\n"
                + "      ,[Title]\n"
                + "      ,[Image]\n"
                + "      ,[Create_Date]\n"
                + "      ,[NewsContent]\n"
                + "      ,[Create_By]\n"
                + "      ,[Status]\n"
                + "      ,[Type]\n"
                + "      ,[URL]\n"
                + "  FROM [dbo].[News] WHERE URL = ? ";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, url);
            rs = ps.executeQuery();
            while (rs.next()) {
                News news = new News();
                news.setNewsID(rs.getInt(1));
                news.setTitle(rs.getString(2));
                news.setImage(rs.getString(3));
                news.setCreated_date(rs.getString(4));
                news.setContent(rs.getString(5));
                news.setCreate_by(rs.getString(6));
                news.setStatus(rs.getInt(7));
                news.setType(rs.getInt(8));
                news.setURL(rs.getString(9));
                return news;
            }
        } catch (Exception e) {
        }
        return null;
    }

    public List<News> listNewsRandom(int status, int type) {
        String sql = "SELECT TOP 3 [NewsID], [Title], [Image], [Create_Date], [NewsContent], [Create_By], [Status], [Type],[URL]\n"
                + "FROM [dbo].[News]\n"
                + "WHERE [NewsID] NOT IN (SELECT TOP 2 [NewsID] FROM [dbo].[News] ORDER BY [Create_Date] DESC) AND Type = ? AND Status = ?\n"
                + "ORDER BY NEWID();";
        List<News> ln = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, type);
            ps.setInt(2, status);
            rs = ps.executeQuery();
            while (rs.next()) {
                News news = new News();
                news.setNewsID(rs.getInt(1));
                news.setTitle(rs.getString(2));
                news.setImage(rs.getString(3));
                news.setCreated_date(rs.getString(4));
                news.setContent(rs.getString(5));
                news.setCreate_by(rs.getString(6));
                news.setStatus(rs.getInt(7));
                news.setType(rs.getInt(8));
                news.setURL(rs.getString(9));
                ln.add(news);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return ln;
    }
}
