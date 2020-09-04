package vn.edu.vtc;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import vn.edu.vtc.dal.OrderDAL;
import vn.edu.vtc.persistance.Customer;
import vn.edu.vtc.persistance.Order;

public class OrderDALTestGetByID {
    @Test
    public void getByIDOrderDALTest1(){ //get được order, trả về order
        OrderDAL orderDAL = new OrderDAL();
        try {
            Order result = orderDAL.getByID(1);
            Order expected = new Order();
            Customer customer = new Customer();
            customer.setCustomerID(1);
            expected.setOrderID(1);
            expected.getCustomer();
            assertTrue(result.getOrderID() == expected.getOrderID());
            assertTrue(result.getCustomer().getCustomerID() == expected.getCustomer().getCustomerID());
        } catch (Exception e) {
            //TODO: handle exception
        }
    }

    @Test
    public void getByIDOrderDALTest2(){ // không get được order, trả về hóa đơn rỗng
        OrderDAL orderDAL = new OrderDAL();
        try {
            Order result = orderDAL.getByID(10);
            Order expected = new Order();
            assertTrue(result.getOrderID() == expected.getOrderID());
            assertTrue(result.getCustomer().getCustomerID() == expected.getCustomer().getCustomerID());          
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}