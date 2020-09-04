package vn.edu.vtc.dalTest;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import vn.edu.vtc.dal.OrderDAL;
import vn.edu.vtc.persistance.Customer;
import vn.edu.vtc.persistance.Order;
import vn.edu.vtc.persistance.Product;

public class OrderDALTestInsert {
    @Test
    public void insertOrderDALTest1() { // create order thành công, trả về 1
        try {
            Customer customer = new Customer();
            customer.setCustomerName("Customer 1");
            customer.setCustomerAddress("Address 1");
            customer.setPhoneNumber("000000000");

            Product product1 = new Product();
            product1.setProductName("Mu Yohe Fullface 981");
            product1.setQuantity(2);
            product1.setPrice(1100000);
            Product product2 = new Product();
            product2.setProductName("Mu KYT NFR Axel Bassani");
            product2.setQuantity(2);
            product2.setPrice(1200000);
            ArrayList<Product> products = new ArrayList<>();
            products.add(product1);
            products.add(product2);
            Order order = new Order();
            order.setCustomer(customer);
            order.setProducts(products);
            OrderDAL orderDAL = new OrderDAL();
            int result = orderDAL.insertOrder(order);
            int expected = 1;
            assertTrue(result == expected);
        } catch (Exception e) {
        }
    }

    @Test
    public void insertOrderDALTest2() { // create order không thành công, trả về 0
        try {
            Customer customer = new Customer();
            customer.setCustomerName(""); // Name Customer bị trống
            customer.setCustomerAddress("Address 2");
            customer.setPhoneNumber("000000001");

            Product product1 = new Product();
            product1.setProductName("Mu Yohe Fullface 981");
            product1.setQuantity(2);
            product1.setPrice(1100000);
            Product product2 = new Product();
            product2.setProductName("Mu KYT NFR Axel Bassani");
            product2.setQuantity(2);
            product2.setPrice(1200000);
            ArrayList<Product> products = new ArrayList<>();
            products.add(product1);
            products.add(product2);
            Order order = new Order();
            order.setCustomer(customer);
            order.setProducts(products);
            OrderDAL orderDAL = new OrderDAL();
            int result = orderDAL.insertOrder(order);
            int expected = 0;
            assertTrue(result == expected);

        } catch (Exception e) {
        }
    }

    @Test
    public void insertOrderDALTest3() { // create order không thành công, trả về 0
        try {
            Customer customer = new Customer();
            customer.setCustomerName("Customer 2");
            customer.setCustomerAddress(""); // Địa chỉ bị trống
            customer.setPhoneNumber("0000000001");

            Product product1 = new Product();
            product1.setProductName("Mu Yohe Fullface 981");
            product1.setQuantity(2);
            product1.setPrice(1100000);
            Product product2 = new Product();
            product2.setProductName("Mu KYT NFR Axel Bassani");
            product2.setQuantity(2);
            product2.setPrice(1200000);
            ArrayList<Product> products = new ArrayList<>();
            products.add(product1);
            products.add(product2);
            Order order = new Order();
            order.setCustomer(customer);
            order.setProducts(products);
            OrderDAL orderDAL = new OrderDAL();
            int result = orderDAL.insertOrder(order);
            int expected = 0;
            assertTrue(result == expected);

        } catch (Exception e) {
        }
    }

    @Test
    public void insertOrderDALTest4() { // create order không thành công, trả về 0
        try {
            Customer customer = new Customer();
            customer.setCustomerName("Customer 2");
            customer.setCustomerAddress("Address 2");
            customer.setPhoneNumber("000000000"); // Số điện thoại bị trùng lặp

            Product product1 = new Product();
            product1.setProductName("Mu Yohe Fullface 981");
            product1.setQuantity(2);
            product1.setPrice(1100000);
            Product product2 = new Product();
            product2.setProductName("Mu KYT NFR Axel Bassani");
            product2.setQuantity(2);
            product2.setPrice(1200000);
            ArrayList<Product> products = new ArrayList<>();
            products.add(product1);
            products.add(product2);
            Order order = new Order();
            order.setCustomer(customer);
            order.setProducts(products);
            OrderDAL orderDAL = new OrderDAL();
            int result = orderDAL.insertOrder(order);
            int expected = 0;
            assertTrue(result == expected);

        } catch (Exception e) {
        }
    }

    @Test
    public void insertOrderDALTest6() { // create order không thành công, trả về 0
        try {
            Customer customer = new Customer();
            customer.setCustomerName("Customer 2");
            customer.setCustomerAddress("Address 2");
            customer.setPhoneNumber("000000001");

            Product product1 = new Product();
            product1.setProductName("Product not exist 1"); // sản phẩm 1 không tồn tại
            product1.setQuantity(2);
            product1.setPrice(1100000);
            Product product2 = new Product();
            product2.setProductName("Product not exist 2"); // sản phẩm 2 không tồn tại
            product2.setQuantity(2);
            product2.setPrice(1100000);
            ArrayList<Product> products = new ArrayList<>();
            products.add(product1); // can't add product
            products.add(product2); // can't add product
            Order order = new Order();
            order.setCustomer(customer);
            order.setProducts(products);
            OrderDAL orderDAL = new OrderDAL();
            int result = orderDAL.insertOrder(order);
            int expected = 0;
            assertTrue(result == expected);

        } catch (Exception e) {
        }
    }

    @Test
    public void insertOrderDALTest7() { // create order không thành công, trả về 0
        try {
            Customer customer = new Customer();
            customer.setCustomerName("Customer 2");
            customer.setCustomerAddress("Address 2");
            customer.setPhoneNumber("000000001");

            Product product1 = new Product();
            product1.setProductName("Product not exist 1"); // sản phẩm 1 tồn tại
            product1.setQuantity(2);
            product1.setPrice(1100000);
            Product product2 = new Product();
            product2.setProductName("Product not exist 2"); // sản phẩm 2 không tồn tại
            product2.setQuantity(2);
            product2.setPrice(1100000);
            ArrayList<Product> products = new ArrayList<>();
            products.add(product1);
            products.add(product2); // can't add product => rollback
            Order order = new Order();
            order.setCustomer(customer);
            order.setProducts(products);
            OrderDAL orderDAL = new OrderDAL();
            int result = orderDAL.insertOrder(order);
            int expected = 0;
            assertTrue(result == expected);

        } catch (Exception e) {
        }
    }

    @Test
    public void insertOrderDALTest8() { // create order không thành công, trả về 0
        try {
            Customer customer = new Customer();
            customer.setCustomerName("Customer 2");
            customer.setCustomerAddress("Address 2");
            customer.setPhoneNumber("000000001");

            Product product1 = new Product();
            product1.setProductName("Mu Yohe Fullface 981");
            product1.setQuantity(-1); // Số lượng <= 0
            product1.setPrice(1100000);
            Product product2 = new Product();
            product2.setProductName("Mu KYT NFR Axel Bassani");
            product2.setQuantity(2);
            product2.setPrice(1100000);
            ArrayList<Product> products = new ArrayList<>();
            products.add(product1); // rollback
            products.add(product2);
            Order order = new Order();
            order.setCustomer(customer);
            order.setProducts(products);
            OrderDAL orderDAL = new OrderDAL();
            int result = orderDAL.insertOrder(order);
            int expected = 0;
            assertTrue(result == expected);

        } catch (Exception e) {
        }
    }

    @Test
    public void insertOrderDALTest9() { // create order không thành công, trả về 0
        try {
            Customer customer = new Customer();
            customer.setCustomerName("Customer 2");
            customer.setCustomerAddress("Address 2");
            customer.setPhoneNumber("000000001");

            Product product1 = new Product();
            product1.setProductName("Mu Yohe Fullface 981");
            product1.setQuantity(2);
            product1.setPrice(-1000); // giá < 0
            Product product2 = new Product();
            product2.setProductName("Mu KYT NFR Axel Bassani");
            product2.setQuantity(2);
            product2.setPrice(1100000);
            ArrayList<Product> products = new ArrayList<>();
            products.add(product1); // rollback
            products.add(product2);
            Order order = new Order();
            order.setCustomer(customer);
            order.setProducts(products);
            OrderDAL orderDAL = new OrderDAL();
            int result = orderDAL.insertOrder(order);
            int expected = 0;
            assertTrue(result == expected);

        } catch (Exception e) {
        }
    }
}