package vn.edu.vtc.dalTest;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import vn.edu.vtc.dal.OrderDetailsDAL;
import vn.edu.vtc.persistance.Order;
import vn.edu.vtc.persistance.Product;

public class OrderDALTestUpdateProducts {
    @Test
    public void updateProductsOrderDALTest1(){ //update sản phẩm thành công, trả về 1
        try {
            int orderID = 1;
            Product product1 = new Product();
            product1.setProductName("Mu 3/4 Bulldog Heli soi thuy tinh");
            product1.setQuantity(2);
            product1.setPrice(1100000);
            Product product2 = new Product();
            product2.setProductName("Mu 3/4 Dammtrax co kinh Raw");
            product2.setQuantity(2);
            product2.setPrice(1200000);
            
            ArrayList<Product> products = new ArrayList<>();
            products.add(product1);
            products.add(product2);
            Order order = new Order();
            order.setOrderID(orderID);
            order.setProducts(products);
            OrderDetailsDAL orderDetailDAL = new OrderDetailsDAL();
            int result = orderDetailDAL.updateOrderDetails(order, orderID);
            int expected = 1;
            assertTrue(result == expected);
        } catch (Exception e) {
            
        }
    }

    @Test
    public void updateProductsOrderDALTest2(){ //update sản phẩm không thành công, trả về 0
        try {
            int orderID = 100; //orderID không tồn tại 
            Product product1 = new Product();
            product1.setProductName("Mu 3/4 Bulldog Heli soi thuy tinh");
            product1.setQuantity(2);
            product1.setPrice(1100000);
            Product product2 = new Product();
            product2.setProductName("Mu 3/4 Dammtrax co kinh Raw");
            product2.setQuantity(2);
            product2.setPrice(1200000);
            
            ArrayList<Product> products = new ArrayList<>();
            products.add(product1);
            products.add(product2);
            Order order = new Order();
            order.setOrderID(orderID); 
            order.setProducts(products);
            OrderDetailsDAL orderDetailDAL = new OrderDetailsDAL();
            int result = orderDetailDAL.updateOrderDetails(order, orderID);
            int expected = 0;
            assertTrue(result == expected);
        } catch (Exception e) {
            
        }
    }

    @Test
    public void updateProductsOrderDALTest3(){ //update sản phẩm không thành công, trả về 0
        try {
            int orderID = 1;
            Product product1 = new Product();
            product1.setProductName("Mu 3/4 Bulldog Heli soi thuy tinh xxx"); //sản phẩm không tồn tại
            product1.setQuantity(2);
            product1.setPrice(1100000);
            Product product2 = new Product();
            product2.setProductName("Mu 3/4 Dammtrax co kinh Raw");
            product2.setQuantity(2);
            product2.setPrice(1200000);
            
            ArrayList<Product> products = new ArrayList<>();
            products.add(product1);
            products.add(product2);
            Order order = new Order();
            order.setOrderID(orderID); 
            order.setProducts(products);
            OrderDetailsDAL orderDetailDAL = new OrderDetailsDAL();
            int result = orderDetailDAL.updateOrderDetails(order, orderID);
            int expected = 0;
            assertTrue(result == expected);
        } catch (Exception e) {
            
        }
    }

    @Test
    public void updateProductsOrderDALTest4(){ //update sản phẩm không thành công, trả về 0
        try {
            int orderID = 1;
            Product product1 = new Product();
            product1.setProductName("Mu 3/4 Bulldog Heli soi thuy tinh");
            product1.setQuantity(0); //số lượng <= 0
            product1.setPrice(1100000);
            Product product2 = new Product();
            product2.setProductName("Mu 3/4 Dammtrax co kinh Raw");
            product2.setQuantity(2);
            product2.setPrice(1200000);
            
            ArrayList<Product> products = new ArrayList<>();
            products.add(product1);
            products.add(product2);
            Order order = new Order();
            order.setOrderID(orderID); 
            order.setProducts(products);
            OrderDetailsDAL orderDetailDAL = new OrderDetailsDAL();
            int result = orderDetailDAL.updateOrderDetails(order, orderID);
            int expected = 0;
            assertTrue(result == expected);
        } catch (Exception e) {
            
        }
    }

    @Test
    public void updateProductsOrderDALTest5(){ //update sản phẩm không thành công, trả về 0
        try {
            int orderID = 1;
            Product product1 = new Product();
            product1.setProductName("Mu 3/4 Bulldog Heli soi thuy tinh");
            product1.setQuantity(2); 
            product1.setPrice(0); //giá <= 0
            Product product2 = new Product();
            product2.setProductName("Mu 3/4 Dammtrax co kinh Raw");
            product2.setQuantity(2);
            product2.setPrice(1200000);
            
            ArrayList<Product> products = new ArrayList<>();
            products.add(product1);
            products.add(product2);
            Order order = new Order();
            order.setOrderID(orderID); 
            order.setProducts(products);
            OrderDetailsDAL orderDetailDAL = new OrderDetailsDAL();
            int result = orderDetailDAL.updateOrderDetails(order, orderID);
            int expected = 0;
            assertTrue(result == expected);
        } catch (Exception e) {
            
        }
    }
}