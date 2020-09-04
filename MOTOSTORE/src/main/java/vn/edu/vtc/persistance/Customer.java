package vn.edu.vtc.persistance;

public class Customer {
    private int customerID;
    private String customerName;
    private String customerAddress;
    private String phoneNumber;

    public Customer(String customerName, String customerAddress, String phoneNumber){
        this.customerName=customerName;
        this.customerAddress=customerAddress;
        this.phoneNumber=phoneNumber;
    }
    public Customer() {
        
	}
	public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    @Override
    public String toString() {
        
        return "Name Customer: " + customerName + "\nAddress Customer: " + customerAddress + "\nPhone Number: " + phoneNumber;
    }
    
    
}