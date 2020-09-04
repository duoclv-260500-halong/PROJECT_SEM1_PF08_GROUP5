package vn.edu.vtc;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import vn.edu.vtc.bl.ProductBL;
import vn.edu.vtc.persistance.Product;

public class ProductBLTestInsert {
    @Test
    public void insertProductBLTest1() { //chèn được sản phẩm, trả về true
        ProductBL productBL = new ProductBL();
        Product product = new Product();

        try {
            product.setProductName("InsertProductBL");
            product.setDescription("InsertProductBL_description");
            product.setPrice(1000000);
            product.setSize("XL");
            product.setColor("Black");
            product.setCategoryID(2);
            product.setTimeWarranty("6 months");
            boolean result = productBL.insertProductBL(product);
            boolean expected = true;
            assertTrue(result == expected);
        } catch (Exception e) {

        }
    }

    @Test
    public void insertProductBLTest2() { // không chèn được sản phẩm, trả về false
        ProductBL productBL = new ProductBL();
        Product product = new Product();

        try {
            product.setProductName("Mu bao hiem"); //trùng tên
            product.setDescription("InsertProductBL_description");
            product.setPrice(1000000);
            product.setSize("XL");
            product.setColor("Black");
            product.setCategoryID(2);
            product.setTimeWarranty("6 months");
            boolean result = productBL.insertProductBL(product);
            boolean expected = false;
            assertTrue(result == expected);
        } catch (Exception e) {

        }
    }

    @Test
    public void insertProductBLTest3() { // không chèn được sản phẩm, trả về false
        ProductBL productBL = new ProductBL();
        Product product = new Product();

        try {
            product.setProductName("InsertProductBL 1");
            product.setDescription("InsertProductBL_description");
            product.setPrice(-1000000); //giá < 0
            product.setSize("XL");
            product.setColor("Black");
            product.setCategoryID(2);
            product.setTimeWarranty("6 months");
            boolean result = productBL.insertProductBL(product);
            boolean expected = false;
            assertTrue(result == expected);
        } catch (Exception e) {

        }
    }

    @Test
    public void insertProductBLTest4() { // không chèn được sản phẩm, trả về false
        ProductBL productBL = new ProductBL();
        Product product = new Product();

        try {
            product.setProductName("InsertProductBL 1");
            product.setDescription("InsertProductBL_description");
            product.setPrice(1000000);
            product.setSize("XL");
            product.setColor("Black");
            product.setCategoryID(5); //ID không nằm trong 1-4
            product.setTimeWarranty("6 months");
            boolean result = productBL.insertProductBL(product);
            boolean expected = false;
            assertTrue(result == expected);
        } catch (Exception e) {

        }
    }

    @Test
    public void insertProductBLTest5() { // không chèn được sản phẩm, trả về false
        ProductBL productBL = new ProductBL();
        Product product = new Product();

        try {
            product.setProductName("InsertProductBL 1");
            product.setDescription("InsertProductBL_description");
            product.setPrice(1000000);
            product.setSize(""); //Size bị trống
            product.setColor("Black");
            product.setCategoryID(2);
            product.setTimeWarranty("6 months");
            boolean result = productBL.insertProductBL(product);
            boolean expected = false;
            assertTrue(result == expected);
        } catch (Exception e) {

        }
    }

    @Test
    public void insertProductBLTest6() { // không chèn được sản phẩm, trả về false
        ProductBL productBL = new ProductBL();
        Product product = new Product();

        try {
            product.setProductName("InsertProductBL 1");
            product.setDescription("InsertProductBL_description");
            product.setPrice(1000000);
            product.setSize("XL"); 
            product.setColor(""); //Color bị trống
            product.setCategoryID(2);
            product.setTimeWarranty("6 months");
            boolean result = productBL.insertProductBL(product);
            boolean expected = false;
            assertTrue(result == expected);
        } catch (Exception e) {

        }
    }

    @Test
    public void insertProductBLTest7() { // không chèn được sản phẩm, trả về false
        ProductBL productBL = new ProductBL();
        Product product = new Product();

        try {
            product.setProductName("InsertProductBL 1");
            product.setDescription("InsertProductBL_description");
            product.setPrice(1000000);
            product.setSize("XL"); 
            product.setColor("Black"); 
            product.setCategoryID(2);
            product.setTimeWarranty("");//Time Warranty bị trống
            boolean result = productBL.insertProductBL(product);
            boolean expected = false;
            assertTrue(result == expected);
        } catch (Exception e) {

        }
    }
}