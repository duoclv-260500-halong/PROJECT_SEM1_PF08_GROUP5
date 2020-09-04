package vn.edu.vtc.dalTest;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import vn.edu.vtc.dal.ProductDAL;
import vn.edu.vtc.persistance.Product;

public class InsertProductDALTest {
    @Test
    public void insertProductDALTest1(){
        ProductDAL productDAL = new ProductDAL();
        Product product = new Product();
        product.setProductName("productName1"); //name is primary key
        product.setDescription("description1. description2. description3.");
        product.setPrice(100000000); //Price haven to numbers
        product.setSize("length x width x height 200 x 50 x 90");
        product.setColor("black");
        product.setTimeWarranty("12 thang");
        product.setCategoryID(1); //ID 1-4
        int result = productDAL.insertProductDAL(product);
        int expected = 1;
        assertTrue(result==expected);
    }

    @Test
    public void insertProductDALTest2(){
        ProductDAL productDAL = new ProductDAL();
        Product product = new Product();
        product.setProductName("productName1"); //Name not unique
        product.setDescription("description1. description2. description3.");
        product.setPrice(1000000000);
        product.setSize("length x width x height 200 x 50 x 90");
        product.setColor("productName");
        product.setTimeWarranty("productName");
        product.setCategoryID(1);
        int result = productDAL.insertProductDAL(product);
        int expected = 0;
        assertTrue(result==expected);
    }

    @Test
    public void insertProductDALTest3(){
        ProductDAL productDAL = new ProductDAL();
        Product product = new Product();
        product.setProductName("productName3");
        product.setDescription("description1. description2. description3.");
        product.setPrice(-1000000000); //Price not greater than 0
        product.setSize("length x width x height 200 x 50 x 90");
        product.setColor("productName");
        product.setTimeWarranty("productName");
        product.setCategoryID(1);
        int result = productDAL.insertProductDAL(product);
        int expected = 0;
        assertTrue(result==expected);
    }

    @Test
    public void insertProductDALTest4(){
        ProductDAL productDAL = new ProductDAL();
        Product product = new Product();
        product.setProductName("productName3");
        product.setDescription("description1. description2. description3.");
        product.setPrice(1000000000);
        product.setSize("length x width x height 200 x 50 x 90");
        product.setColor("productName");
        product.setTimeWarranty("productName");
        product.setCategoryID(5); //ID not in the range 1-4
        int result = productDAL.insertProductDAL(product);
        int expected = 0;
        assertTrue(result==expected);
    }
}