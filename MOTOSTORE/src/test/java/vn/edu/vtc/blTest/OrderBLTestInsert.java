package vn.edu.vtc.blTest;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import vn.edu.vtc.bl.OrderBL;

import vn.edu.vtc.persistance.Customer;
import vn.edu.vtc.persistance.Order;
import vn.edu.vtc.persistance.Product;

public class OrderBLTestInsert {
    @Test
    public void insertOrderBLTest1(){ //create order thành công, trả về true
        try {
            Customer customer = new Customer();
            customer.setCustomerName("Customer 3");
            customer.setCustomerAddress("Address 3");
            customer.setPhoneNumber("000000002");
            
            Product product1 = new Product();
            product1.setProductName("Mu Yohe Fullface 981");
            product1.setQuantity(2);
            product1.setPrice(1100000);
            Product product2 = new Product();
            product2.setProductName("Mu KYT NFR Axel Bassani");
            product2.setQuantity(2);
            product2.setPrice(1100000);
            ArrayList<Product> products = new ArrayList<>();
            products.add(product1);
            products.add(product2);
            Order order = new Order();
            order.setCustomer(customer);
            order.setProducts(products);
            OrderBL orderBL = new OrderBL();
            boolean result = orderBL.createOrder(order);
            boolean expected = true;
            assertTrue(result == expected);

        } catch (Exception e) {
        }
    }

    @Test
    public void insertOrderBLTest2(){ //create order không thành công, trả về false
        try {
            Customer customer = new Customer();
            customer.setCustomerName(""); //Name Customer bị trống
            customer.setCustomerAddress("Address 4");
            customer.setPhoneNumber("000000003");
            
            Product product1 = new Product();
            product1.setProductName("Mu Yohe Fullface 981");
            product1.setQuantity(2);
            product1.setPrice(1100000);
            Product product2 = new Product();
            product2.setProductName("Mu KYT NFR Axel Bassani");
            product2.setQuantity(2);
            product2.setPrice(1100000);
            ArrayList<Product> products = new ArrayList<>();
            products.add(product1);
            products.add(product2);
            Order order = new Order();
            order.setCustomer(customer);
            order.setProducts(products);
            OrderBL orderBL = new OrderBL();
            boolean result = orderBL.createOrder(order);
            boolean expected = false;
            assertTrue(result == expected);

        } catch (Exception e) {
        }
    }

    @Test
    public void insertOrderBLTest3(){ //create order không thành công, trả về false
        try {
            Customer customer = new Customer();
            customer.setCustomerName("Customer 4");
            customer.setCustomerAddress(""); //Địa chỉ bị trống
            customer.setPhoneNumber("0000000003");
            
            Product product1 = new Product();
            product1.setProductName("Mu Yohe Fullface 981");
            product1.setQuantity(2);
            product1.setPrice(1100000);
            Product product2 = new Product();
            product2.setProductName("Mu KYT NFR Axel Bassani");
            product2.setQuantity(2);
            product2.setPrice(1100000);
            ArrayList<Product> products = new ArrayList<>();
            products.add(product1);
            products.add(product2);
            Order order = new Order();
            order.setCustomer(customer);
            order.setProducts(products);
            OrderBL orderBL = new OrderBL();
            boolean result = orderBL.createOrder(order);
            boolean expected = false;
            assertTrue(result == expected);

        } catch (Exception e) {
        }
    }
    @Test
    public void insertOrderBLTest4(){ //create order không thành công, trả về false
        try {
            Customer customer = new Customer();
            customer.setCustomerName("Customer 4");
            customer.setCustomerAddress("Address 4");
            customer.setPhoneNumber("000000002"); //Số điện thoại bị trùng lặp
            
            Product product1 = new Product();
            product1.setProductName("Mu Yohe Fullface 981");
            product1.setQuantity(2);
            product1.setPrice(1100000);
            Product product2 = new Product();
            product2.setProductName("Mu KYT NFR Axel Bassani");
            product2.setQuantity(2);
            product2.setPrice(1100000);
            ArrayList<Product> products = new ArrayList<>();
            products.add(product1);
            products.add(product2);
            Order order = new Order();
            order.setCustomer(customer);
            order.setProducts(products);
            OrderBL orderBL = new OrderBL();
            boolean result = orderBL.createOrder(order);
            boolean expected = false;
            assertTrue(result == expected);

        } catch (Exception e) {
        }
    }

    

    @Test
    public void insertOrderBLTest6(){ //create order không thành công, trả về false
        try {
            Customer customer = new Customer();
            customer.setCustomerName("Customer 4");
            customer.setCustomerAddress("Address 4");
            customer.setPhoneNumber("000000003"); 
            
            Product product1 = new Product();
            product1.setProductName("Product not exist 1"); //sản phẩm 1 không tồn tại
            product1.setQuantity(2);
            product1.setPrice(1100000);
            Product product2 = new Product();
            product2.setProductName("Product not exist 2"); //sản phẩm 2 không tồn tại
            product2.setQuantity(2);
            product2.setPrice(1100000);
            ArrayList<Product> products = new ArrayList<>();
            products.add(product1); //can't add product
            products.add(product2); //can't add product
            Order order = new Order();
            order.setCustomer(customer);
            order.setProducts(products);
            OrderBL orderBL = new OrderBL();
            boolean result = orderBL.createOrder(order);
            boolean expected = false;
            assertTrue(result == expected);

        } catch (Exception e) {
        }
    }

    @Test
    public void insertOrderBLTest7(){ //create order không thành công, trả về false
        try {
            Customer customer = new Customer();
            customer.setCustomerName("Customer 4");
            customer.setCustomerAddress("Address 4");
            customer.setPhoneNumber("000000003"); 
            
            Product product1 = new Product();
            product1.setProductName("Product not exist 1"); //sản phẩm 1 tồn tại
            product1.setQuantity(2);
            product1.setPrice(1100000);
            Product product2 = new Product();
            product2.setProductName("Product not exist 2"); //sản phẩm 2 không tồn tại
            product2.setQuantity(2);
            product2.setPrice(1100000);
            ArrayList<Product> products = new ArrayList<>();
            products.add(product1); 
            products.add(product2); //can't add product => rollback
            Order order = new Order();
            order.setCustomer(customer);
            order.setProducts(products);
            OrderBL orderBL = new OrderBL();
            boolean result = orderBL.createOrder(order);
            boolean expected = false;
            assertTrue(result == expected);

        } catch (Exception e) {
        }
    }
    @Test
    public void insertOrderBLTest8(){ //create order không thành công, trả về false
        try {
            Customer customer = new Customer();
            customer.setCustomerName("Customer 4");
            customer.setCustomerAddress("Address 4");
            customer.setPhoneNumber("000000003");
            
            Product product1 = new Product();
            product1.setProductName("Mu Yohe Fullface 981");
            product1.setQuantity(-1); //Số lượng <= 0
            product1.setPrice(1100000);
            Product product2 = new Product();
            product2.setProductName("Mu KYT NFR Axel Bassani");
            product2.setQuantity(2);
            product2.setPrice(1100000);
            ArrayList<Product> products = new ArrayList<>();
            products.add(product1); //rollback
            products.add(product2);
            Order order = new Order();
            order.setCustomer(customer);
            order.setProducts(products);
            OrderBL orderBL = new OrderBL();
            boolean result = orderBL.createOrder(order);
            boolean expected = false;
            assertTrue(result == expected);

        } catch (Exception e) {
        }
    }
    @Test
    public void insertOrderBLTest9(){ //create order không thành công, trả về false
        try {
            Customer customer = new Customer();
            customer.setCustomerName("Customer 4");
            customer.setCustomerAddress("Address 4");
            customer.setPhoneNumber("000000003");
            
            Product product1 = new Product();
            product1.setProductName("Mu Yohe Fullface 981");
            product1.setQuantity(2); 
            product1.setPrice(-1000); //Giá <= 0
            Product product2 = new Product();
            product2.setProductName("Mu KYT NFR Axel Bassani");
            product2.setQuantity(2);
            product2.setPrice(1100000);
            ArrayList<Product> products = new ArrayList<>();
            products.add(product1); //rollback
            products.add(product2);
            Order order = new Order();
            order.setCustomer(customer);
            order.setProducts(products);
            OrderBL orderBL = new OrderBL();
            boolean result = orderBL.createOrder(order);
            boolean expected = false;
            assertTrue(result == expected);

        } catch (Exception e) {
        }
    }
}