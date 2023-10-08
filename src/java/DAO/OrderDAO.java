/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import entity.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tungl
 */
public class OrderDAO extends MyDAO {

    public List<Order> listAllOrder() {
        String sql = "SELECT [ID]\n"
                + "      ,[CustomerID]\n"
                + "      ,[Status]\n"
                + "      ,[Total_Money]\n"
                + "      ,[Payment_Method]\n"
                + "      ,[Date]\n"
                + "      ,[OrderCode]\n"
                + "      ,[CourseID]\n"
                + "  FROM [dbo].[Order] ORDER BY ID DESC";
        List<Order> orders = new ArrayList<>();
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Order order = new Order();
                order.setID(rs.getInt(1));
                order.setCustomerID(rs.getInt(2));
                order.setStatusOrder(rs.getInt(3));
                order.setTotalMoney(rs.getDouble(4));
                order.setPaymentMethod(rs.getString(5));
                order.setDate(rs.getString(6));
                order.setOrderCode(rs.getString(7));
                order.setCourseID(rs.getInt(8));

                orders.add(order);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return orders;
    }

    public void insertOrder(Order order) {
        String sql = "INSERT INTO [dbo].[Order]\n"
                + "           ([CustomerID]\n"
                + "           ,[Status]\n"
                + "           ,[Total_Money]\n"
                + "           ,[Payment_Method]\n"
                + "           ,[Date]\n"
                + "           ,[OrderCode]\n"
                + "           ,[CourseID])\n"
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, order.getCustomerID());
            ps.setInt(2, order.getStatusOrder());
            ps.setDouble(3, order.getTotalMoney());
            ps.setString(4, order.getPaymentMethod());
            ps.setString(5, order.getDate());
            ps.setString(6, order.getOrderCode());
            ps.setInt(7, order.getCourseID());
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Order inserted successfully.");
            } else {
                System.out.println("Failed to insert order.");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Order getOrderByID(int orderID) {
        String sql = "SELECT [ID], [CustomerID], [Status], [Total_Money], [Payment_Method],[Date],[OrderCode], [CourseID] "
                + "FROM [dbo].[Order] "
                + "WHERE [OrderID] = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, orderID);
            rs = ps.executeQuery();
            if (rs.next()) {
                Order order = new Order();
                order.setID(rs.getInt(1));
                order.setCustomerID(rs.getInt(2));
                order.setStatusOrder(rs.getInt(3));
                order.setTotalMoney(rs.getDouble(4));
                order.setPaymentMethod(rs.getString(5));
                order.setDate(rs.getString(6));
                order.setOrderCode(rs.getString(7));
                order.setCourseID(rs.getInt(8));
                return order;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Order getLastOrder() {
        String sql = "SELECT TOP 1 [ID], [CustomerID], [Status], [Total_Money], [Payment_Method],[Date],[OrderCode], [CourseID] "
                + "FROM [dbo].[Order] ORDER BY [ID] DESC";
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                Order order = new Order();
                order.setID(rs.getInt(1));
                order.setCustomerID(rs.getInt(2));
                order.setStatusOrder(rs.getInt(3));
                order.setTotalMoney(rs.getDouble(4));
                order.setPaymentMethod(rs.getString(5));
                order.setDate(rs.getString(6));
                order.setOrderCode(rs.getString(7));
                order.setCourseID(rs.getInt(8));
                return order;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public void updateOrderStatus(int orderID, int newStatus) {
        String sql = "UPDATE [dbo].[Order] SET [Status] = ? WHERE [ID] = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, newStatus);
            ps.setInt(2, orderID);
            ps.executeUpdate();
            System.out.println("Order status updated successfully.");
        } catch (Exception e) {
            System.out.println("Failed to update order status: " + e.getMessage());
        }
    }

    public Order checkBuy(int userID, int courseID) {
        String sql = "SELECT c.UserID, o.ID AS OrderID, o.CustomerID, o.Status, o.Total_Money, o.Payment_Method, o.OrderCode, o.Date, o.CourseID "
                + "FROM [Order] o "
                + "JOIN Customer c "
                + "ON o.CustomerID = c.ID "
                + "WHERE c.ID  = ? AND o.CourseID = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, userID);
            ps.setInt(2, courseID);
            rs = ps.executeQuery();

            // If the query returns a result, create an Order object and set its properties.
            if (rs.next()) {
                Order order = new Order();
                order.setID(rs.getInt("OrderID"));
                order.setCustomerID(rs.getInt("CustomerID"));
                order.setStatusOrder(rs.getInt("Status"));
                order.setTotalMoney(rs.getDouble("Total_Money"));
                order.setPaymentMethod(rs.getString("Payment_Method"));
                order.setOrderCode(rs.getString("OrderCode"));
                order.setDate(rs.getString("Date"));
                order.setCourseID(rs.getInt("CourseID"));
                return order;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        // Return null in case of an error or if the customer has not purchased the course
        return null;
    }
}
