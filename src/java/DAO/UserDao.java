/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import controller.Authentication.MD5;
import java.util.ArrayList;
import java.util.List;
import entity.*;
import java.sql.SQLException;

/**
 *
 * @author msi
 */
public class UserDao extends MyDAO {

    public User checkAuthentication(String user, String pass) {
        User userObj = null;
        String xSql = "SELECT ID, [Username],[Full_name], [E-mail] ,"
                + "[Role],Phone, [Verified], Avatar, [Status] "
                + "FROM [dbo].[User] "
                + "WHERE [Password] = ? AND ([Username] = ? OR [E-mail] = ?) ";

        try {
            ps = con.prepareStatement(xSql);
            ps.setString(1, pass);
            ps.setString(2, user);
            ps.setString(3, user);
            rs = ps.executeQuery();

            if (rs.next()) {
                userObj = new User();
                userObj.setId(rs.getInt(1));
                userObj.setUsername(rs.getString(2));
                userObj.setFull_name(rs.getString(3));
                userObj.setMail(rs.getString(4));
                userObj.setRoleID(rs.getInt(5));
                userObj.setPhone(rs.getString(6));
                userObj.setVerified(rs.getInt(7));
                userObj.setAvatar(rs.getString(8));
                userObj.setStatus(rs.getInt(9));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userObj;
    }

    public boolean registerUser(String username, String password, String fullName, String email, String phone, int role, int Verified, int status) {
        String insertSql = "INSERT INTO [dbo].[User] "
                + "([Username], [Password], [Full_name], [E-mail], [Role], "
                + "[Phone], [Verified], [Status]) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?,?)";

        try {
            ps = con.prepareStatement(insertSql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, fullName);
            ps.setString(4, email);
            ps.setInt(5, role);
            ps.setString(6, phone);
            ps.setInt(7, Verified);
            ps.setInt(8, status);

            int rowsAffected = ps.executeUpdate();
            ps.close();

            return rowsAffected > 0; // Return true if the registration was successful
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false; // Return false if an error occurred during registration
    }

    public void resetPassword(String email, String password) {
        String insertSql = "UPDATE [dbo].[User]\n"
                + "   SET [Password] = ? \n"
                + " WHERE [E-mail] =  ?";

        try {
            ps = con.prepareStatement(insertSql);
            ps.setString(1, password);
            ps.setString(2, email);
            int rowsAffected = ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public User searchAccount(String username) {
        User userObj = null;
        String selectSql = "SELECT ID, [Username],[Full_name], [E-mail] ,"
                + "[Role],Phone, [Verified], Avatar FROM [dbo].[User] "
                + "WHERE [username] = ?";

        try {
            ps = con.prepareStatement(selectSql);
            ps.setString(1, username);

            rs = ps.executeQuery();

            if (rs.next()) {
                userObj = new User();
                userObj.setId(rs.getInt(1));
                userObj.setUsername(rs.getString(2));
                userObj.setFull_name(rs.getString(3));
                userObj.setMail(rs.getString(4));
                userObj.setRoleID(rs.getInt(5));
                userObj.setPhone(rs.getString(6));
                userObj.setVerified(rs.getInt(7));
                userObj.setAvatar(rs.getString(8));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userObj;
    }

    public User searchAccountByMail(String mail) {
        User userObj = null;
        String selectSql = "SELECT ID, [Username],[Full_name], [E-mail] ,"
                + "[Role],Phone, [Verified], Avatar, [Status] "
                + "FROM [dbo].[User] WHERE [E-mail] = ?";

        try {
            ps = con.prepareStatement(selectSql);
            ps.setString(1, mail);
            rs = ps.executeQuery();

            if (rs.next()) {
                userObj = new User();
                userObj.setId(rs.getInt(1));
                userObj.setUsername(rs.getString(2));
                userObj.setFull_name(rs.getString(3));
                userObj.setMail(rs.getString(4));
                userObj.setRoleID(rs.getInt(5));
                userObj.setPhone(rs.getString(6));
                userObj.setVerified(rs.getInt(7));
                userObj.setAvatar(rs.getString(8));
                userObj.setStatus(rs.getInt(9));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userObj;
    }

    public User searchAccountByID(int id) {
        User userObj = null;
        String selectSql = "SELECT ID, [Username],[Full_name], [E-mail] ,"
                + "[Role],Phone, [Verified], Avatar, [Status] "
                + "FROM [dbo].[User] WHERE [ID] = ?";

        try {
            ps = con.prepareStatement(selectSql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                userObj = new User();
                userObj.setId(rs.getInt(1));
                userObj.setUsername(rs.getString(2));
                userObj.setFull_name(rs.getString(3));
                userObj.setMail(rs.getString(4));
                userObj.setRoleID(rs.getInt(5));
                userObj.setPhone(rs.getString(6));
                userObj.setVerified(rs.getInt(7));
                userObj.setAvatar(rs.getString(8));
                userObj.setStatus(rs.getInt(9));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return userObj;
    }

    public List<User> listAllUser() {
        String sql = "SELECT ID, Username, Full_name, [E-mail], [Role], "
                + "Phone,[Date of Birth] , Verified, [Status] FROM [User]";
        List<User> lu = new ArrayList<>();
        try {
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setFull_name(rs.getString(3));
                user.setMail(rs.getString(4));
                user.setRoleID(rs.getInt(5));
                user.setPhone(rs.getString(6));
                user.setBirth(rs.getString(7));
                user.setVerified(rs.getInt(8));
                user.setStatus(rs.getInt(9));
                lu.add(user);
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return lu;
    }

    public int countUser(int role) {
        String sql = "SELECT COUNT(*) AS Total\n"
                + "FROM [User]\n"
                + "WHERE [Role] = ? AND Status = 1";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, role);
            rs = ps.executeQuery();
            if (rs.next()) {
                int numberOfStudent = rs.getInt(1);
                return numberOfStudent;
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public User getUserByUserName(String username) {
        String sql = "SELECT ID, Username, Full_name, [E-mail], [Role], Phone,"
                + "[Date of Birth] , Verified, [Status] FROM [User] "
                + "WHERE [username] =  ? OR [E-mail] = ?";
        User user = new User();
        try {

            ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, username);
            rs = ps.executeQuery();
            while (rs.next()) {
                user.setId(rs.getInt(1));
                user.setUsername(rs.getString(2));
                user.setFull_name(rs.getString(3));
                user.setMail(rs.getString(4));
                user.setRoleID(rs.getInt(5));
                user.setPhone(rs.getString(6));
                user.setBirth(rs.getString(7));
                user.setVerified(rs.getInt(8));
                user.setStatus(rs.getInt(9));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }

    public User getUserByCustomerID(int id) {
        String sql = "Select u.Full_name,u.[E-mail] from [dbo].[User] u JOIN Customer c ON u.ID = c.UserID\n"
                + "WHERE c.ID = ?";
        User user = new User();
        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                user.setMail(rs.getString("E-mail"));
                user.setFull_name(rs.getString("Full_name"));
            }
            rs.close();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return user;
    }

    // changeStatusUser method
    //Input: int userID
    //Description: change status of User -> 0: user is blocked in system
    //                                      1: user is accepted in system
    public void blockUser(int userID) {
        String sql = "UPDATE [User] \n"
                + "SET [Status] = 0 \n"
                + "WHERE ID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void unblockUser(int userID) {
        String sql = "UPDATE [User] \n"
                + "SET [Status] = 1 \n"
                + "WHERE ID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            ps.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void Block(int id) {
        String sql = " UPDATE [User] SET [Status] = 0 WHERE ID = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
        }

    }

    public void UnBlock(int id) {
        String sql = " UPDATE [User] SET [Status] = 1 WHERE ID = ?";

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            ps.close();
        } catch (Exception e) {
        }
    }

    public User getStatusByID(int id) {
        String sql = "SELECT [Status]  FROM [User] WHERE ID = ?";

        try {

            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                User us = new User();
                us.setStatus(rs.getInt(1));
                return us;
            }
            ps.close();
        } catch (Exception e) {
        }
        return null;
    }

    public String getAvatarbyID(int id) {
        String sql = "  SELECT [Avatar] FROM [DEMO_SWP].[dbo].[User]\n"
                + "  WHERE [ID]  = ?";
        String currentAvatar = null;
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                currentAvatar = rs.getString("Avatar");
            }
            return currentAvatar;
        } catch (Exception e) {

        }
        return currentAvatar;
    }
}
