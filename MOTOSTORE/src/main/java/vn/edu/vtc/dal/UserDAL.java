package vn.edu.vtc.dal;

import vn.edu.vtc.persitance.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAL {

    public User checkUser(String username, String password) {
        User user = new User();
        try (Connection connection = DBUtil.getConnection();
        PreparedStatement pstm = connection
                .prepareStatement("select * from user where username = ? and pass = ?");){
            
            pstm.setString(1, username);
            pstm.setString(2, password);
            ResultSet rs = pstm.executeQuery();
            
            if (rs.next()) {
                return user;
            } else {
                return null;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }
}