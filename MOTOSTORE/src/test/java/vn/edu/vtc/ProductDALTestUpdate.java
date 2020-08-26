package vn.edu.vtc;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import vn.edu.vtc.dal.ProductDAL;
import vn.edu.vtc.persistance.Product;

public class ProductDALTestUpdate {
    @Test
    public void updateProductDALTest1(){ //update được sản phẩm, trả về true
        ProductDAL productDAL = new ProductDAL();
        Product product = new Product();
        try {
            product.setProductName("UpdateProductDALTest");
            product.setDescription("UpdateProductDALTest_description");
            product.setPrice(1300000);
            product.setSize("L");
            product.setColor("White");
            product.setCategoryID(2);
            product.setTimeWarranty("7 months");
            int result = productDAL.updateProductDAL(product, "ProductDALTestInsert");
            int expected = 1;
            assertTrue(result == expected);
            
        } catch (Exception e) {
            
        }
    }

    @Test
    public void updateProductDALTest2(){ // không update được sản phẩm, trả về false
        ProductDAL productDAL = new ProductDAL();
        Product product = new Product();
        try {
            product.setProductName("UpdateProductDALTest"); 
            product.setDescription("UpdateProductDALTest 1");
            product.setPrice(1300000);
            product.setSize("L");
            product.setColor("White");
            product.setCategoryID(2);
            product.setTimeWarranty("7 months");
            int result = productDAL.updateProductDAL(product, "UpdateProductDALTest 1"); //không tìm được tên
            int expected = 0;
            assertTrue(result == expected);
            
        } catch (Exception e) {
            
        }
    }

    @Test
    public void updateProductDALTest3(){ // không update được sản phẩm, trả về false
        ProductDAL productDAL = new ProductDAL();
        Product product = new Product();
        try {
            product.setProductName("UpdateProductDALTest");
            product.setDescription("UpdateProductDALTest 1");
            product.setPrice(-1300001); //giá < 0
            product.setSize("XL");
            product.setColor("White");
            product.setCategoryID(2);
            product.setTimeWarranty("7 months");
            int result = productDAL.updateProductDAL(product, "UpdateProductDALTest");
            int expected = 0;
            assertTrue(result == expected);
            
        } catch (Exception e) {
            
        }
    }

    @Test
    public void updateProductDALTest4(){ // không update được sản phẩm, trả về false
        ProductDAL productDAL = new ProductDAL();
        Product product = new Product();
        try {
            product.setProductName("NINJA 400 ABS 2020"); // trùng tên
            product.setDescription("Mu bao hiem fullface");
            product.setPrice(1300000);
            product.setSize("XL");
            product.setColor("White");
            product.setCategoryID(2);
            product.setTimeWarranty("7 months");
            int result = productDAL.updateProductDAL(product, "UpdateProductDALTest");
            int expected = 0;
            assertTrue(result == expected);
            
        } catch (Exception e) {
            
        }
    }
    
    @Test
    public void updateProductDALTest5(){ // không update được sản phẩm, trả về false
        ProductDAL productDAL = new ProductDAL();
        Product product = new Product();
        try {
            product.setProductName("UpdateProductDALTest");
            product.setDescription("Mu bao hiem fullface");
            product.setPrice(1300000);
            product.setSize(""); //size trống
            product.setColor("White");
            product.setCategoryID(2);
            product.setTimeWarranty("7 months");
            int result = productDAL.updateProductDAL(product, "UpdateProductDALTest");
            int expected = 0;
            assertTrue(result == expected);
            
        } catch (Exception e) {
            
        }
    }
    @Test
    public void updateProductDALTest6(){ // không update được sản phẩm, trả về false
        ProductDAL productDAL = new ProductDAL();
        Product product = new Product();
        try {
            product.setProductName("NINJA 400 ABS 2020");
            product.setDescription("Mu bao hiem fullface");
            product.setPrice(1300000);
            product.setSize("XL");
            product.setColor("");// Color trống
            product.setCategoryID(2);
            product.setTimeWarranty("7 months");
            int result = productDAL.updateProductDAL(product, "UpdateProductDALTest");
            int expected = 0;
            assertTrue(result == expected);
            
        } catch (Exception e) {
            
        }
    }
    @Test
    public void updateProductDALTest7(){ // không update được sản phẩm, trả về false
        ProductDAL productDAL = new ProductDAL();
        Product product = new Product();
        try {
            product.setProductName("NINJA 400 ABS 2020"); 
            product.setDescription("Mu bao hiem fullface");
            product.setPrice(1300000);
            product.setSize("XL");
            product.setColor("White");
            product.setCategoryID(2);
            product.setTimeWarranty("");// Time Warranty trống
            int result = productDAL.updateProductDAL(product, "UpdateProductDALTest");
            int expected = 0;
            assertTrue(result == expected);
            
        } catch (Exception e) {
            
        }
    }
}