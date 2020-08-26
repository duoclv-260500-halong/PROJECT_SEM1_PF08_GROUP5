package vn.edu.vtc.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import vn.edu.vtc.persistance.Product;


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

    public int updateProductDAL(Product product, String productName){
        try (Connection con = DBUtil.getConnection();
        PreparedStatement pstm = con.prepareStatement("Update Products set productName = ?, description = ?, price = ?, size = ?, color = ?, timeWarranty = ? where productName = ?" );){
            pstm.setString(1, product.getProductName());
            pstm.setString(2, product.getDescription());
            pstm.setLong(3, product.getPrice());
            pstm.setString(4, product.getSize());
            pstm.setString(5, product.getColor());
            pstm.setString(6, product.getTimeWarranty());
            pstm.setString(7, productName);
            return pstm.executeUpdate();    
        } catch (Exception e) {
            return 0;
        }
    }
    public Product getProductByName(String productName){
        Product product = new Product();
        try (Connection con = DBUtil.getConnection();
        PreparedStatement pstm = con.prepareStatement("select * from Products where productName = ?");) {
        pstm.setString(1, productName);
        ResultSet rs = pstm.executeQuery();
        if(rs.next()){
            product.setProductName(rs.getString("productName"));
            product.setDescription(rs.getString("description"));
            product.setPrice(rs.getLong("price"));
            product.setSize(rs.getString("size"));
            product.setColor(rs.getString("color"));
            product.setCategoryID(rs.getInt("categoryID"));
            product.setTimeWarranty(rs.getString("timeWarranty"));
            return product;
        }
        } catch (Exception e) {
            return null;
        }
        return null;
    }
}