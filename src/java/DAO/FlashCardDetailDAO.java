/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entity.FlashCardDetail;
import entity.Flashcards;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author msi
 */
public class FlashCardDetailDAO extends MyDAO {

    public List<FlashCardDetail> listFLDetailByFLID(int id) {
        String sql = "SELECT [ID]\n"
                + "      ,[Fl_ID]\n"
                + "      ,[Question]\n"
                + "      ,[Answer]\n"
                + "  FROM [dbo].[FlashCardDetail] WHERE Fl_ID = ?";
        List<FlashCardDetail> lcm = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                FlashCardDetail cm = new FlashCardDetail();
                cm.setId(rs.getInt(1));
                cm.setFl_id(id);
                cm.setQuestion(rs.getString(3));
                cm.setAnswer(rs.getString(4));
                lcm.add(cm);
            }
        } catch (Exception e) {
        }
        return lcm;
    }

    public void addFLDetailByFLID(int Fl_Id, String question, String answer) {
        String sql = "INSERT INTO [dbo].[FlashCardDetail]\n"
                + "           ([Fl_ID]\n"
                + "           ,[Question]\n"
                + "           ,[Answer])\n"
                + "     VALUES\n"
                + "           (?,?,?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, Fl_Id);
            ps.setString(2, question);
            ps.setString(3, answer);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
