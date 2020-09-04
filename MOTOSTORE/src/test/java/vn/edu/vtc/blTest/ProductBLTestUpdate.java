package vn.edu.vtc.blTest;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import vn.edu.vtc.bl.ProductBL;
import vn.edu.vtc.persistance.Product;

public class ProductBLTestUpdate {
    @Test
    public void updateProductDALTest1(){ //update được sản phẩm, trả về true
        ProductBL productBL = new ProductBL();
        Product product = new Product();
        try {
            product.setProductName("UpdateProductBL");
            product.setDescription("UpdateProductBL_description");
            product.setPrice(1000);
            product.setSize("XL");
            product.setColor("Black");
            product.setTimeWarranty("6months");
            product.setCategoryID(1);
            boolean result = productBL.updateProductBL(product, 39);
            boolean expected = true;
            assertTrue(result==expected);
        } catch (Exception e) {
            
        } 
    } 
    @Test
    public void updateProductDALTest2(){ //không update đc sản phẩm, trả về false
        ProductBL productBL = new ProductBL();
        Product product = new Product();
        try {
            product.setProductName("Mu bao hiem"); //tên bị trùng
            product.setDescription("InsertProductBL_description");
            product.setPrice(100000000);
            product.setSize("XL");
            product.setColor("Black");
            product.setTimeWarranty("6months");
            product.setCategoryID(1);
            boolean result = productBL.updateProductBL(product, 39);
            boolean expected = false;
            assertTrue(result==expected);
        } catch (Exception e) {
            
        } 
    } 
    @Test
    public void updateProductDALTest3(){ //không update đc sản phẩm, trả về false
        ProductBL productBL = new ProductBL();
        Product product = new Product();
        try {
            product.setProductName("productNameUpdate3");
            product.setDescription("InsertProductBL_description");
            product.setPrice(-100000000); //Giá < 0
            product.setSize("XL");
            product.setColor("Black");
            product.setTimeWarranty("6months");
            product.setCategoryID(1);
            boolean result = productBL.updateProductBL(product, 39);
            boolean expected = false;
            assertTrue(result==expected);
        } catch (Exception e) {
            
        } 
    } 

    @Test
    public void updateProductDALTest4(){ //không update đc sản phẩm, trả về false
        ProductBL productBL = new ProductBL();
        Product product = new Product();
        try {
            product.setProductName("productNameUpdate3");
            product.setDescription("InsertProductBL_description");
            product.setPrice(100000000);
            product.setSize("XL");
            product.setColor("Black");
            product.setTimeWarranty("6months");
            product.setCategoryID(5); //ID không nằm trong khoảng 1-4
            boolean result = productBL.updateProductBL(product, 39);
            boolean expected = false;
            assertTrue(result==expected);
        } catch (Exception e) {
            
        } 
    } 

    @Test
    public void updateProductDALTest5(){ //không update đc sản phẩm, trả về false
        ProductBL productBL = new ProductBL();
        Product product = new Product();
        try {
            product.setProductName("productNameUpdate3");
            product.setDescription("InsertProductBL_description");
            product.setPrice(100000000);
            product.setSize(""); //Size trống
            product.setColor("Black");
            product.setTimeWarranty("6months");
            product.setCategoryID(5);
            boolean result = productBL.updateProductBL(product, 39);
            boolean expected = false;
            assertTrue(result==expected);
        } catch (Exception e) {
            
        } 
    } 

    @Test
    public void updateProductDALTest6(){ //không update đc sản phẩm, trả về false
        ProductBL productBL = new ProductBL();
        Product product = new Product();
        try {
            product.setProductName("productNameUpdate3");
            product.setDescription("InsertProductBL_description");
            product.setPrice(100000000);
            product.setSize("XL"); 
            product.setColor(""); //Color trống
            product.setTimeWarranty("6months");
            product.setCategoryID(5);
            boolean result = productBL.updateProductBL(product, 39);
            boolean expected = false;
            assertTrue(result==expected);
        } catch (Exception e) {
            
        } 
    } 

    @Test
    public void updateProductDALTest7(){ //không update đc sản phẩm, trả về false
        ProductBL productBL = new ProductBL();
        Product product = new Product();
        try {
            product.setProductName("productNameUpdate3");
            product.setDescription("InsertProductBL_description");
            product.setPrice(100000000);
            product.setSize("XL"); 
            product.setColor("Black");
            product.setTimeWarranty(""); // Time warranty trống
            product.setCategoryID(5);
            boolean result = productBL.updateProductBL(product, 39);
            boolean expected = false;
            assertTrue(result==expected);
        } catch (Exception e) {
            
        } 
    } 
    
}