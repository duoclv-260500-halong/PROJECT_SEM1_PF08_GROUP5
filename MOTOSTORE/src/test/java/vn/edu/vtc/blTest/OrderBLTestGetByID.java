package vn.edu.vtc.blTest;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import vn.edu.vtc.bl.OrderBL;
import vn.edu.vtc.persistance.Customer;
import vn.edu.vtc.persistance.Order;

public class OrderBLTestGetByID {
    @Test
    public void getByIDOrderBLLTest1(){ //get được order, trả về order
        OrderBL orderBL = new OrderBL();
        try {
            Order result = orderBL.getByID(1);
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
    public void getByIDOrderBLTest2(){ // không get được order, trả về hóa đơn rỗng
        OrderBL orderBL = new OrderBL();
        try {
            Order result = orderBL.getByID(10);
            Order expected = new Order();
            assertTrue(result.getOrderID() == expected.getOrderID());
            assertTrue(result.getCustomer().getCustomerID() == expected.getCustomer().getCustomerID());          
        } catch (Exception e) {
            //TODO: handle exception
        }
    }
}