package vn.edu.vtc;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import vn.edu.vtc.dal.ProductDAL;
import vn.edu.vtc.persistance.Product;

public class ProductDALTestGetByName{

    @Test
    public void getByNameDALTest1(){ //tìm đc sản phẩm, trả về sản phẩm đó
        ProductDAL productDAL = new ProductDAL();
        try {
            Product product = productDAL.getProductByName("Mu bao hiem");
            Product product1 = new Product();
            product1.setProductName("Mu bao hiem");
            product1.setDescription("Mu bao hiem fullface");
            product1.setPrice(1300000);
            product1.setSize("XL");
            product1.setColor("Black");
            product1.setCategoryID(2);
            product1.setTimeWarranty("6 months");   
            assertTrue(product.getProductName().equals(product1.getProductName()));
            assertTrue(product.getDescription().equals(product1.getDescription()));
            assertTrue(product.getPrice() == product1.getPrice());
            assertTrue(product.getSize().equals(product1.getSize()));
            assertTrue(product.getColor().equals(product1.getColor()));
            assertTrue(product.getCategoryID() == product1.getCategoryID());
            assertTrue(product.getTimeWarranty().equals(product1.getTimeWarranty()));
        } catch (Exception e) {
        }
    }
    @Test
    public void getByNameDALTest2(){ //sai tên, không tìm được, trả về null
        ProductDAL productDAL = new ProductDAL();
        try {
            Product product = productDAL.getProductByName("Mu bao hiem xxx");
            assertNull(product);
        } catch (Exception e) {
        }
    }
}