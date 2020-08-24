package vn.edu.vtc.persistance;

import java.sql.Date;
import java.util.ArrayList;

public class Order {
    private int orderID;
    private Date timeCreate;
    private String shopName;
    private String shopAddress;
    private Customer customer;
    private ArrayList<Product> products;

    public Order(){
        customer = null;
        products = new ArrayList<>();
    }
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public Date getTimeCreate() {
        return timeCreate;
    }

    public void setTimeCreate(Date timeCreate) {
        this.timeCreate = timeCreate;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public String getShopAddress() {
        return shopAddress;
    }

    public void setShopAddress(String shopAddress) {
        this.shopAddress = shopAddress;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }
    
    public void addProduct(Product product){
        if(products == null){
            products = new ArrayList<>();
        }
        products.add(product);
    }
}