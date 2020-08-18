package vn.edu.vtc.bl;

import vn.edu.vtc.dal.ProductDAL;
import vn.edu.vtc.persitance.Product;

public class ProductBL {
    ProductDAL productDAL = new ProductDAL();
    public boolean insertProductBL(Product product){
        return productDAL.insertProductDAL(product) > 0;
    }
}