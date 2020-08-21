package vn.edu.vtc.bl;

import vn.edu.vtc.dal.OrderDAL;
import vn.edu.vtc.persitance.Order;

public class OrderBL {

    public boolean insertOrder(Order order){
        OrderDAL orderDAL = new OrderDAL();
        return orderDAL.insertOrder(order) > 0;
        
    }
}