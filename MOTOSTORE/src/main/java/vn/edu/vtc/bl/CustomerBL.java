package vn.edu.vtc.bl;

import vn.edu.vtc.dal.CustomerDAL;
import vn.edu.vtc.persistance.Customer;

public class CustomerBL{
    CustomerDAL customerDAL = new CustomerDAL();

    public Customer getCustomer(int customerID){
        return customerDAL.getCustomer(customerID);
    }

    public boolean updateCustomer(Customer customer, int customerID){
        return customerDAL.updateCustomer(customer, customerID) > 0;
    }
}