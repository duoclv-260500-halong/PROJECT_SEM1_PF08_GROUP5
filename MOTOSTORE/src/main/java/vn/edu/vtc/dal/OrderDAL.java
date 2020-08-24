package vn.edu.vtc.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import vn.edu.vtc.persistance.Customer;
import vn.edu.vtc.persistance.Order;
import vn.edu.vtc.persistance.Product;

public class OrderDAL {
    public Order getByID(int orderID){
        Order order = new Order();
        Customer customer = new Customer();
        try (Connection con = DBUtil.getConnection();
        PreparedStatement pstm = con.prepareStatement("select * from Orders where orderID = " + orderID);){
            ResultSet rs = pstm.executeQuery();
            if(rs.next()){
                order.setOrderID(rs.getInt("orderID"));
                customer.setCustomerID(rs.getInt("customerID"));
                order.setCustomer(customer);
                return order;
            }
        } catch (Exception e) {
            return null;
        }
        return order;
    }
    public int insertOrder(Order order){
        if(order.getProducts() == null || order.getProducts().isEmpty()){
            return 0;
        }

        Customer customer = order.getCustomer();
        try (Connection connection = DBUtil.getConnection();){
            connection.setAutoCommit(false);
            //insert Customer
            try (PreparedStatement pstm = connection.prepareStatement("insert into Customers(customerName, customerAddress, phoneNumber, identityCard) values (?,?,?,?)");){
                pstm.setString(1, customer.getCustomerName());                
                pstm.setString(2, customer.getCustomerAddress());                
                pstm.setString(3, customer.getPhoneNumber());                
                pstm.setString(4, customer.getIdentityCard());   
                if(pstm.executeUpdate() <= 0){
                    throw new SQLException();
                }             

            } catch (Exception e) {
                connection.rollback();
                return 0;
            }
            //get customerID
            try (ResultSet rs = connection.createStatement().executeQuery("select customerID from Customers order by customerID desc limit 1;");){
                if(rs.next()){
                    order.getCustomer().setCustomerID(rs.getInt("customerID"));
                }
                else{
                    throw new SQLException();
                }
            } catch (Exception e) {
                connection.rollback();
                return 0;
            }

            //insert Order
            try (PreparedStatement pstm = connection.prepareStatement("insert into Orders(customerID) values (?)");){
                pstm.setInt(1, order.getCustomer().getCustomerID());
                if(pstm.executeUpdate() <= 0){
                    throw new SQLException();
                }
            } catch (Exception e) {
                connection.rollback();
                return 0;
            }

            //get orderID
            try (ResultSet rs = connection.createStatement().executeQuery("select orderID from Orders order by orderID desc limit 1");){
                if(rs.next()){
                    order.setOrderID(rs.getInt("orderID"));
                }                
                else{
                    throw new SQLException();
                }
            } catch (Exception e) {
                connection.rollback();
                return 0;
            }

            //insert OrderDetails
            for (Product product : order.getProducts()) {
                try (PreparedStatement pstm = connection.prepareStatement("insert into OrderDetails(orderID, productName, unitPrice, quantity) values (?,?,?,?)");){
                    pstm.setInt(1, order.getOrderID());
                    pstm.setString(2, product.getProductName());
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