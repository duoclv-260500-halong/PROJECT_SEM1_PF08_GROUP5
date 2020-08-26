package vn.edu.vtc.bl;

import vn.edu.vtc.dal.ProductDAL;
import vn.edu.vtc.persistance.Product;

public class ProductBL {
    ProductDAL productDAL = new ProductDAL();
    public boolean insertProductBL(Product product){
        return productDAL.insertProductDAL(product) > 0;
    }
    public boolean updateProductBL(Product product,String productName){
        return productDAL.updateProductDAL(product, productName) > 0;
    }
    public Product getByName(String productName){
        return productDAL.getProductByName(productName);
    } 
}