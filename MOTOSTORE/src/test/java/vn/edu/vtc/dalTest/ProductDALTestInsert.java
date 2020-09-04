package vn.edu.vtc.dalTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import vn.edu.vtc.dal.ProductDAL;
import vn.edu.vtc.persistance.Product;

public class ProductDALTestInsert {
    @Test
    public void insertProductDALTest1() { //chèn được sản phẩm, trả về 1
        ProductDAL productDAL = new ProductDAL();
        Product product = new Product();
        try {
            product.setProductName("ProductDALTestInsert");
            product.setDescription("description1. description2. description3.");
            product.setPrice(100000000);
            product.setSize("length x width x height 200 x 50 x 90");
            product.setColor("Black");
            product.setTimeWarranty("12 thang");
            product.setCategoryID(1);
            int result = productDAL.insertProductDAL(product);
            int expected = 1;
            assertTrue(result == expected);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @Test
    public void insertProductDALTest2() { //không chèn được sản phẩm, trả về 0
        ProductDAL productDAL = new ProductDAL();
        Product product = new Product();
        try {
            product.setProductName("ProductDALTestInsert"); // Name not unique
            product.setDescription("description1. description2. description3.");
            product.setPrice(1000000000);
            product.setSize("length x width x height 200 x 50 x 90");
            product.setColor("Black");
            product.setTimeWarranty("productName");
            product.setCategoryID(1);
            int result = productDAL.insertProductDAL(product);
            int expected = 0;
            assertTrue(result == expected);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @Test
    public void insertProductDALTest3() { //không chèn được sản phẩm, trả về 0
        ProductDAL productDAL = new ProductDAL();
        Product product = new Product();
        try {
            product.setProductName("productNameInsert3");
            product.setDescription("description1. description2. description3.");
            product.setPrice(-1000000000); // Price not greater than 0
            product.setSize("length x width x height 200 x 50 x 90");
            product.setColor("Black");
            product.setTimeWarranty("productName");
            product.setCategoryID(1);
            int result = productDAL.insertProductDAL(product);
            int expected = 0;
            assertTrue(result == expected);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @Test
    public void insertProductDALTest4() { //không chèn được sản phẩm, trả về 0
        ProductDAL productDAL = new ProductDAL();
        Product product = new Product();
        try {
            product.setProductName("productName3");
            product.setDescription("description1. description2. description3.");
            product.setPrice(1000000000);
            product.setSize("length x width x height 200 x 50 x 90");
            product.setColor("productName");
            product.setTimeWarranty("productName");
            product.setCategoryID(5); // ID not in the range 1-4
            int result = productDAL.insertProductDAL(product);
            int expected = 0;
            assertTrue(result == expected);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
    @Test
    public void insertProductDALTest5() { //không chèn được sản phẩm, trả về 0
        ProductDAL productDAL = new ProductDAL();
        Product product = new Product();
        try {
            product.setProductName("productName3");
            product.setDescription("description1. description2. description3.");
            product.setPrice(1000000000);
            product.setSize(""); //Size trống
            product.setColor("productName");
            product.setTimeWarranty("productName");
            product.setCategoryID(2);
            int result = productDAL.insertProductDAL(product);
            int expected = 0;
            assertTrue(result == expected);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
    @Test
    public void insertProductDALTest6() { //không chèn được sản phẩm, trả về 0
        ProductDAL productDAL = new ProductDAL();
        Product product = new Product();
        try {
            product.setProductName("productName3");
            product.setDescription("description1. description2. description3.");
            product.setPrice(1000000000);
            product.setSize("length x width x height 200 x 50 x 90");
            product.setColor(""); //Color trống
            product.setTimeWarranty("productName");
            product.setCategoryID(2); 
            int result = productDAL.insertProductDAL(product);
            int expected = 0;
            assertTrue(result == expected);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
    @Test
    public void insertProductDALTest7() { //không chèn được sản phẩm, trả về 0
        ProductDAL productDAL = new ProductDAL();
        Product product = new Product();
        try {
            product.setProductName("productName3");
            product.setDescription("description1. description2. description3.");
            product.setPrice(1000000000);
            product.setSize("length x width x height 200 x 50 x 90");
            product.setColor("Black");
            product.setTimeWarranty(""); //Time Warranty trống
            product.setCategoryID(2);
            int result = productDAL.insertProductDAL(product);
            int expected = 0;
            assertTrue(result == expected);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }
}