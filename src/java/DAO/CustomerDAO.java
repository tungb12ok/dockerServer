package DAO;

import entity.Customer;

public class CustomerDAO extends MyDAO {

    public void registerCustomer(int user_id) {
        String sql = "INSERT INTO [dbo].[Customer]\n"
                + "           ([UserID])\n"
                + "     VALUES\n"
                + "           (?)";
        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, user_id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Customer getCustomerWhenLogin(String input) {
        String sql = "SELECT u.ID, u.Full_name, u.[E-mail], u.Phone, "
                + "u.[Date of Birth], u.Avatar ,c.Address,u.Role,c.ID  FROM Customer c\n"
                + "JOIN [User] u\n"
                + "ON c.UserID = u.ID WHERE u.Username = ? OR u.[E-mail] = ? ";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, input);
            ps.setString(2, input);
            rs = ps.executeQuery();
            while (rs.next()) {
                Customer customer = new Customer();
                customer.setId(rs.getInt(1));
                customer.setFull_name(rs.getString(2));
                customer.setMail(rs.getString(3));
                customer.setPhone(rs.getString(4));
                customer.setBirth(rs.getString(5));
                customer.setAvatar(rs.getString(6));
                customer.setAddress(rs.getString(7));
                customer.setRoleID(rs.getInt(8));
                customer.setCustomer_id(rs.getInt(9));

                return customer;
            }
            ps.close();
            rs.close();
        } catch (Exception e) {
        }
        return null;
    }

    public void updateCustomer(int id, String phone, String name, String dob,
            String address, String avatar) {
        String sql = "UPDATE [dbo].[User]\n"
                + "   SET   \n"
                + "      [Full_name] =  ?\n"
                + "      ,[Phone] = ?\n"
                + "      ,[Date of Birth] =  ?\n"
                + ",[Avatar] = ?\n"
                + " WHERE ID = ?\n"
                + " UPDATE [dbo].[Customer]\n"
                + "   SET [Address] = ?\n"
                + " WHERE [UserID] = ?";
        try {
            ps = con.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, phone);
            ps.setString(3, dob);
            ps.setString(4, avatar);
            ps.setInt(5, id);
            ps.setString(6, address);
            ps.setInt(7, id);
            rs = ps.executeQuery();

            ps.close();
            rs.close();
        } catch (Exception e) {
        }
    }

    public Customer getCustomerByUserID(int userID) {
        String sql = "SELECT [ID], [Address], [UserID] "
                + "FROM [dbo].[Customer] WHERE [UserID] = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            if (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomer_id(rs.getInt(1));
                customer.setAddress(rs.getString(2));
                customer.setUserID(rs.getInt(3));
                return customer;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

    public Customer getCustomerByCustomerID(int userID) {
        String sql = "SELECT [ID], [Address], [UserID] "
                + "FROM [dbo].[Customer] WHERE [UserID] = ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, userID);
            rs = ps.executeQuery();
            if (rs.next()) {
                Customer customer = new Customer();
                customer.setCustomer_id(rs.getInt(1));
                customer.setAddress(rs.getString(2));
                customer.setUserID(rs.getInt(3));
                return customer;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
