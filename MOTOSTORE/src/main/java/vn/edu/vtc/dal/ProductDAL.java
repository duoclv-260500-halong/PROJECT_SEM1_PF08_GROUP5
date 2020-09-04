package vn.edu.vtc.dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.Statement;
import java.util.ArrayList;

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

    public int updateProductDAL(Product product, int productID){
        try (Connection con = DBUtil.getConnection();
        PreparedStatement pstm = con.prepareStatement("Update Products set productName = ?, description = ?, price = ?, size = ?, color = ?, timeWarranty = ? where productID = ?" );){
            pstm.setString(1, product.getProductName());
            pstm.setString(2, product.getDescription());
            pstm.setLong(3, product.getPrice());                    
            pstm.setString(4, product.getSize());
            pstm.setString(5, product.getColor());
            pstm.setString(6, product.getTimeWarranty());
            pstm.setInt(7, productID);
            return pstm.executeUpdate();    
        } catch (Exception e) {
            return 0;
        }
    }
    public ArrayList<Product> getProductByCategory(int categoryID){
        ArrayList<Product> listProducts = new ArrayList<>();
        
        try (Connection con = DBUtil.getConnection();
        Statement stm = con.createStatement();) {
        
        ResultSet rs = stm.executeQuery("select * from Products where categoryID = " + categoryID);
        while(rs.next()){
            Product product = new Product();
            product.setProductID(rs.getInt("productID"));
            product.setProductName(rs.getString("productName"));
            product.setPrice(rs.getLong("price"));
            product.setSize(rs.getString("size"));
            product.setColor(rs.getString("color"));
            product.setCategoryID(rs.getInt("categoryID"));
            product.setTimeWarranty(rs.getString("timeWarranty"));
            listProducts.add(product);
        }
        } catch (Exception e) {
        }
        return listProducts;
    }

    public Product getProductByID(int productID){
        Product product = new Product();
        try (Connection con = DBUtil.getConnection();
        Statement stm = con.createStatement();) {
        ResultSet rs = stm.executeQuery("select * from Products where productID = " + productID);
        if(rs.next()){
            product.setProductID(rs.getInt("productID"));
            product.setProductName(rs.getString("productName"));
            product.setDescription(rs.getString("description"));
            product.setPrice(rs.getLong("price"));
            product.setSize(rs.getString("size"));
            product.setColor(rs.getString("color"));
            product.setCategoryID(rs.getInt("categoryID"));
            product.setTimeWarranty(rs.getString("timeWarranty"));
        }
        else{
            product = null;
        }
        } catch (Exception e) {
            return null;
        }
        return product;
    }
}