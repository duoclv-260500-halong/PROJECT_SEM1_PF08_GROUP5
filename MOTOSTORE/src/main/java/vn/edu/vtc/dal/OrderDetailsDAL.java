package vn.edu.vtc.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import vn.edu.vtc.persistance.Order;
import vn.edu.vtc.persistance.Product;


public class OrderDetailsDAL {
    
    public int updateOrderDetails(Order order, int orderID){
        try (Connection connection = DBUtil.getConnection();){
            connection.setAutoCommit(false);
            //insert OrderDetails
            for (Product product : order.getProducts()) {
                try (PreparedStatement pstm = connection.prepareStatement("update OrderDetails set quantity = ? where productID = ?");){
                    pstm.setInt(1, product.getQuantity());
                    pstm.setInt(2, product.getProductID());
                    if(pstm.executeUpdate() <= 0){
                        throw new SQLException();
                    }                
                } catch (Exception e) {
                    connection.rollback();
                    return 0;
                }
            }
            connection.commit();
            connection.setAutoCommit(true);
            
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }
    
}