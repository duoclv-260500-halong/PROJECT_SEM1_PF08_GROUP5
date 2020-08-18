package vn.edu.vtc.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;

import vn.edu.vtc.persitance.Product;


public class ProductDAL {
    
    public int insertProductDAL(Product product){
        try  (Connection con = DBUtil.getConnection();
        PreparedStatement pstm = con.prepareStatement(
                "insert into Products(productName, description, price, size, color, timeWarranty, categoryID) values (?,?,?,?,?,?,?)");){
                pstm.setString(1, product.getProductName());
                pstm.setString(2, product.getDescription());
                pstm.setLong(3, product.getPrice());
                pstm.setString(4, product.getSize());
                pstm.setString(5, product.getColor());
                pstm.setString(6, product.getTimeWarranty());
                pstm.setInt(7, product.getCategoryID());
                return pstm.executeUpdate();
        } catch (Exception e) {
            return 0; 
        }
    }
}