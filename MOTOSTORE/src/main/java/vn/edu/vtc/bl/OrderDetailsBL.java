package vn.edu.vtc.bl;

import vn.edu.vtc.dal.OrderDetailsDAL;
import vn.edu.vtc.persistance.Order;

public class OrderDetailsBL {
    OrderDetailsDAL orderDetailsDAL = new OrderDetailsDAL();

    public boolean updateOrderDetails(Order order, int orderID){
        return orderDetailsDAL.updateOrderDetails(order, orderID) > 0;
    }
}