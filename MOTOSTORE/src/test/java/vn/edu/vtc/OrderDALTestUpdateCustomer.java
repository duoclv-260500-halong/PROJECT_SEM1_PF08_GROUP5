package vn.edu.vtc;

import static org.junit.Assert.assertTrue;

import org.junit.Test;


import vn.edu.vtc.dal.CustomerDAL;
import vn.edu.vtc.persistance.Customer;

public class OrderDALTestUpdateCustomer {
    @Test
    public void updateCustomerOrderDALTest1(){ //update customer thành công, trả về 1
        CustomerDAL customerDAL = new CustomerDAL();
        try {
            int customerID = 1;
            Customer customer = new Customer();
            customer.setCustomerName("Le Van Duoc");
            customer.setCustomerAddress("Minh Khai, phuong Hoang Van Thu, quan Hai Ba Trung");
            customer.setPhoneNumber("0333XXXXXY");
            customer.setIdentityCard("0000xxxxxy");
            int result = customerDAL.updateCustomer(customer, customerID);
            int expected = 1;
            assertTrue(result == expected);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    @Test
    public void updateCustomerOrderDALTest2(){ //update customer không thành công, trả về 0
        CustomerDAL customerDAL = new CustomerDAL();
        try {
            int customerID = 1;
            Customer customer = new Customer();
            customer.setCustomerName(""); // tên bị trống
            customer.setCustomerAddress("Minh Khai, phuong Hoang Van Thu, quan Hai Ba Trung");
            customer.setPhoneNumber("0333XXXXXY");
            customer.setIdentityCard("0000xxxxxy");
            int result = customerDAL.updateCustomer(customer, customerID);
            int expected = 0;
            assertTrue(result == expected);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    @Test
    public void updateCustomerOrderDALTest3(){ //update customer không thành công, trả về 0
        CustomerDAL customerDAL = new CustomerDAL();
        try {
            int customerID = 1;
            Customer customer = new Customer();
            customer.setCustomerName("Le Van Duoc"); 
            customer.setCustomerAddress(""); // địa chỉ bị trống
            customer.setPhoneNumber("0333XXXXXY");
            customer.setIdentityCard("0000xxxxxy");
            int result = customerDAL.updateCustomer(customer, customerID);
            int expected = 0;
            assertTrue(result == expected);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    @Test
    public void updateCustomerOrderDALTest4(){ //update customer không thành công, trả về 0
        CustomerDAL customerDAL = new CustomerDAL();
        try {
            int customerID = 1;
            Customer customer = new Customer();
            customer.setCustomerName("Le Van Duoc"); 
            customer.setCustomerAddress("Minh Khai, phuong Hoang Van Thu, quan Hai Ba Trung"); // địa chỉ bị trống
            customer.setPhoneNumber(""); //Số điện thoại bị trống
            customer.setIdentityCard("0000xxxxxy");
            int result = customerDAL.updateCustomer(customer, customerID);
            int expected = 0;
            assertTrue(result == expected);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    @Test
    public void updateCustomerOrderDALTest5(){ //update customer không thành công, trả về 0
        CustomerDAL customerDAL = new CustomerDAL();
        try {
            int customerID = 1;
            Customer customer = new Customer();
            customer.setCustomerName("Le Van Duoc"); 
            customer.setCustomerAddress("Minh Khai, phuong Hoang Van Thu, quan Hai Ba Trung"); // địa chỉ bị trống
            customer.setPhoneNumber("0333XXXXXY"); 
            customer.setIdentityCard(""); //Số căn cước bị trống
            int result = customerDAL.updateCustomer(customer, customerID);
            int expected = 0;
            assertTrue(result == expected);
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
    
}