package vn.edu.vtc.bl;

import java.util.ArrayList;

import vn.edu.vtc.dal.OrderDAL;

import vn.edu.vtc.persistance.Order;

public class OrderBL {
    OrderDAL orderDAL = new OrderDAL();

    public Order getByID(int orderID){
        return orderDAL.getByID(orderID);
    }
    public boolean createOrder(Order order){
        
        return orderDAL.createOrder(order) > 0;
    }
    public boolean updateOrder(int orderID, int orderStatus, String reasonUpdate){
        return orderDAL.updateOrder(orderID, orderStatus, reasonUpdate) > 0;
    }
    public ArrayList<Order> getAllOrder(){
        return orderDAL.getAllOrder();
    }
}