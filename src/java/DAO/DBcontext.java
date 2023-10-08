package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBcontext {

    public Connection connection;

    public DBcontext() {
        try {
            //Change the username password and url to connect your own database
            String username = "sa";
            String password = "YourStrong!Passw0rd";
            String url = "jdbc:sqlserver://163.44.192.162:1433;databaseName=Foucre";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(DBcontext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
