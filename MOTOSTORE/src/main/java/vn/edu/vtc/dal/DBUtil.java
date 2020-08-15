package vn.edu.vtc.dal;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {

    private static Connection connection;
    private static String url = "jdbc:mysql://localhost:3306/motostore";
    private static String user = "root";
    private static String password = "Donationminimum100$";

    public static Connection getConnection(){
        try {
            connection = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return connection;
    }

}