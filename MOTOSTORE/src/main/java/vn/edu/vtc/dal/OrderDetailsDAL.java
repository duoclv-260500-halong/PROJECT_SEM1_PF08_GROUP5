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
            //delete OrderDetails
            try (PreparedStatement pstm = connection.prepareStatement("delete from OrderDetails where orderID = ?")){
                pstm.setInt(1, orderID);
                if(pstm.executeUpdate() <= 0){
                    throw new SQLException();
                }
            } catch (Exception e) {
                connection.rollback();
            }
            //insert OrderDetails
            for (Product product : order.getProducts()) {
                try (PreparedStatement pstm = connection.prepareStatement("insert into OrderDetails(orderID, productID, unitPrice, quantity) values (?,?,?,?)");){
                    pstm.setInt(1, order.getOrderID());
                    pstm.setInt(2, product.getProductID());
                    pstm.setLong(3, product.getPrice());
                    pstm.setInt(4, product.getQuantity());
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