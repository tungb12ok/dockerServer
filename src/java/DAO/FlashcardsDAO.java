/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entity.Flashcards;
import java.sql.SQLException;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

/**
 *
 * @author asus
 */
public class FlashcardsDAO extends MyDAO {

    public String convert(String text) {
        String normalizedText = Normalizer.normalize(text, Normalizer.Form.NFD);
        Pattern pattern = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalizedText).replaceAll("").replaceAll("Đ", "D").replaceAll("đ", "d");
    }

    public List<Flashcards> getFlashcards() {
        List<Flashcards> flashcards = new ArrayList<>();
        String sql = "SELECT [ID]\n"
                + "      ,[title]\n"
                + "      ,[Author]\n"
                + "      ,[URL]\n"
                + "  FROM [dbo].[Flashcards]";
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Flashcards flashcard = new Flashcards();
                flashcard.setId(rs.getInt(1));
                flashcard.setTitle(rs.getString(2));
                flashcard.setAuthor(rs.getInt(3));
                flashcard.setURL(rs.getString(4));
                flashcards.add(flashcard);
            }

            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any exceptions or errors appropriately
        }

        return flashcards;
    }

    public void addFlashcard(Flashcards flashcard) {
        String sql = "INSERT INTO [dbo].[Flashcards]\n"
                + "           ([title]\n"
                + "           ,[Author]\n"
                + "           ,[URL])\n"
                + "             VALUES (?, ?, ?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, flashcard.getTitle());
            ps.setInt(2, flashcard.getAuthor());
            ps.setString(3, convert(flashcard.getTitle()).toLowerCase().replaceAll("\\s+", ""));

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any exceptions or errors appropriately
        }
    }

    public void deleteFlashcard(int flashcardId) {
        String sql = "DELETE FROM [dbo].[Flashcards] WHERE [ID] = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, flashcardId);

            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
            // Handle any exceptions or errors appropriately
        }
    }

    public int getFLIDJustAdded() {
        String sql = "SELECT TOP 1 ID FROM Flashcards ORDER BY ID DESC";
        int id = 0;
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                id = rs.getInt(1);
            }
        } catch (Exception e) {

        }
        return id;
    }

    public Flashcards searchFlashcardByURL(String url) {
        String sql = "SELECT [ID], [title], [Author], [URL] "
                + "FROM [dbo].[Flashcards] WHERE [URL] = ?";
        Flashcards flashcard = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, url);
            rs = ps.executeQuery();
            if (rs.next()) {
                flashcard = new Flashcards();
                flashcard.setId(rs.getInt("ID"));
                flashcard.setTitle(rs.getString("title"));
                flashcard.setAuthor(rs.getInt("Author"));
                flashcard.setURL(rs.getString("URL"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flashcard;
    }

}
