package vn.edu.vtc.bl;

import java.util.ArrayList;

import vn.edu.vtc.dal.ProductDAL;
import vn.edu.vtc.persistance.Product;

public class ProductBL {
    ProductDAL productDAL = new ProductDAL();
    public boolean insertProductBL(Product product){
        return productDAL.insertProductDAL(product) > 0;
    }
    public boolean updateProductBL(Product product, int productID){
        return productDAL.updateProductDAL(product, productID) > 0;
    }
    public ArrayList<Product> getByCategory(int categoryID){
        return productDAL.getProductByCategory(categoryID);
    } 
    public Product getProductByID(int productID){
        return productDAL.getProductByID(productID);
    }   
}