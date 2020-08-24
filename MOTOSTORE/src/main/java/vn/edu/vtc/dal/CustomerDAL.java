package vn.edu.vtc.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.edu.vtc.persistance.Customer;

public class CustomerDAL {

    public Customer getCustomer(String customerID){
        Customer customer = new Customer();
        try (Connection connection = DBUtil.getConnection();
        PreparedStatement pstm = connection.prepareStatement("select * from customers where customerID = ?;");){
            pstm.setString(1, customerID);
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                customer.setCustomerName(rs.getString("customerName"));
                customer.setCustomerAddress(rs.getString("customerAddress"));
                customer.setPhoneNumber(rs.getString("phoneNumber"));
                customer.setIdentityCard(rs.getString("identityCard"));
                return customer;
            } else {
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    public int updateCustomer(Customer customer, String customerID){
        try (Connection connection = DBUtil.getConnection();
        PreparedStatement pstm = connection.prepareStatement("Update customers set customerName = ? , customerAddress = ?, phoneNumber = ?, identityCard = ? where customerID = "+customerID);){
            pstm.setString(1, customer.getCustomerName());
            pstm.setString(2, customer.getCustomerAddress());
            pstm.setString(3, customer.getPhoneNumber());
            pstm.setString(4, customer.getIdentityCard());
            return pstm.executeUpdate();
        } catch (Exception e) {
            return 0;
        }
    }
}