package vn.edu.vtc.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vn.edu.vtc.persistance.Customer;
import vn.edu.vtc.persistance.Order;
import vn.edu.vtc.persistance.Product;

public class OrderDAL {
    public Order getByID(int orderID) {
        Order order = new Order();
        Customer customer = new Customer();
        ArrayList<Product> products = new ArrayList<>();
        try (Connection con = DBUtil.getConnection();
                PreparedStatement pstm = con.prepareStatement("select * from Orders where orderID = " + orderID);) {
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {
                order.setOrderID(rs.getInt("orderID"));
                customer.setCustomerID(rs.getInt("customerID"));

            }
        } catch (Exception e) {
            return null;
        }
        try (Connection con = DBUtil.getConnection();
                PreparedStatement pstm = con
                        .prepareStatement("select * from Customers where customerID = " + customer.getCustomerID());) {
            ResultSet rs = pstm.executeQuery();
            if (rs.next()) {

                customer.setCustomerName(rs.getString("customerName"));
                customer.setCustomerAddress(rs.getString("customerAddress"));
                customer.setPhoneNumber(rs.getString("phoneNumber"));
            }
        } catch (Exception e) {
            return null;
        }
        try (Connection con = DBUtil.getConnection();
                PreparedStatement pstm = con
                        .prepareStatement("select * from orderDetails where orderID = " + order.getOrderID());) {
            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setProductID(rs.getInt("productID"));
                try (PreparedStatement pstm1 = con.prepareStatement(
                        "select productName from products where productID = " + product.getProductID());) {
                    ResultSet rs1 = pstm1.executeQuery();
                    if (rs1.next()) {
                        product.setProductName(rs1.getString("productName"));

                    }
                } catch (Exception e) {
                    return null;
                }
                product.setPrice(rs.getLong("unitPrice"));
                product.setQuantity(rs.getInt("quantity"));
                products.add(product);
            }
        } catch (Exception e) {
            return null;
        }
        order.setCustomer(customer);
        order.setProducts(products);
        return order;
    }

    public int insertOrder(Order order) {
        if (order.getProducts() == null || order.getProducts().isEmpty()) {
            return 0;
        }

        Customer customer = order.getCustomer();
        try (Connection connection = DBUtil.getConnection();) {
            connection.setAutoCommit(false);
            // insert Customer
            try (PreparedStatement pstm = connection.prepareStatement(
                    "insert into Customers(customerName, customerAddress, phoneNumber) values (?,?,?)");) {
                pstm.setString(1, customer.getCustomerName());
                pstm.setString(2, customer.getCustomerAddress());
                pstm.setString(3, customer.getPhoneNumber());
                if (pstm.executeUpdate() <= 0) {
                    throw new SQLException();
                }

            } catch (Exception e) {
                connection.rollback();
                return 0;
            }
            // get customerID
            try (ResultSet rs = connection.createStatement()
                    .executeQuery("select customerID from Customers order by customerID desc limit 1;");) {
                if (rs.next()) {
                    order.getCustomer().setCustomerID(rs.getInt("customerID"));
                } else {
                    throw new SQLException();
                }
            } catch (Exception e) {
                connection.rollback();
                return 0;
            }

            // insert Order
            try (PreparedStatement pstm = connection.prepareStatement("insert into Orders(customerID) values (?)");) {
                pstm.setInt(1, order.getCustomer().getCustomerID());
                if (pstm.executeUpdate() <= 0) {
                    throw new SQLException();
                }
            } catch (Exception e) {
                connection.rollback();
                return 0;
            }

            // get orderID
            try (ResultSet rs = connection.createStatement()
                    .executeQuery("select orderID from Orders order by orderID desc limit 1");) {
                if (rs.next()) {
                    order.setOrderID(rs.getInt("orderID"));
                } else {
                    throw new SQLException();
                }
            } catch (Exception e) {
                connection.rollback();
                return 0;
            }

            // insert OrderDetails
            for (Product product : order.getProducts()) {
                try (PreparedStatement pstm = connection.prepareStatement(
                        "insert into OrderDetails(orderID, productID, unitPrice, quantity) values (?,?,?,?)");) {
                    pstm.setInt(1, order.getOrderID());
                    pstm.setInt(2, product.getProductID());
                    pstm.setLong(3, product.getPrice());
                    pstm.setInt(4, product.getQuantity());
                    if (pstm.executeUpdate() <= 0) {
                        throw new SQLException();
                    }
                } catch (Exception e) {
                    connection.rollback();
                    return 0;
                }
            }

            // get store information
            try (ResultSet rs = connection.createStatement().executeQuery("select * from Store;");) {
                if (rs.next()) {
                    order.setShopName(rs.getString("storeName"));
                    order.setShopAddress(rs.getString("storeAddress"));
                    order.setHotline(rs.getString("hotline"));
                }
            } catch (Exception e) {

            }
            connection.commit();
            connection.setAutoCommit(true);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

}