package vn.edu.vtc;

import vn.edu.vtc.bl.CustomerBL;
import vn.edu.vtc.bl.OrderBL;
import vn.edu.vtc.bl.OrderDetailsBL;
import vn.edu.vtc.bl.ProductBL;
import vn.edu.vtc.bl.UserBL;
import vn.edu.vtc.persistance.Customer;
import vn.edu.vtc.persistance.Order;
import vn.edu.vtc.persistance.Product;
import vn.edu.vtc.persistance.User;

import java.io.Console;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {
        ArrayList<String> mainMenu = new ArrayList<String>();
        mainMenu.add("Welcome to MOTOSTORE");
        mainMenu.add("1. Insert Product");
        mainMenu.add("2. Update Product");
        mainMenu.add("3. Insert Order");
        mainMenu.add("4. Update Order");
        mainMenu.add("0. Exit");

        ArrayList<String> menuInsert = new ArrayList<String>();
        menuInsert.add("Menu Insert");
        menuInsert.add("1. Insert Moto");
        menuInsert.add("2. Insert Hat");
        menuInsert.add("3. Insert Clothes");
        menuInsert.add("4. Insert Gloves");
        menuInsert.add("0. Exit");

        ArrayList<String> menuUpdateOrder = new ArrayList<String>();
        menuUpdateOrder.add("Menu Update Order");
        menuUpdateOrder.add("1. Update Customer");
        menuUpdateOrder.add("2. Update Product");
        menuUpdateOrder.add("0. Exit");

        checkLogin();

        int choice = printMenu(mainMenu, 4);
        switch (choice) {
            case 1: {
                int choice1 = printMenu(menuInsert, 4);
                insertProduct(choice1);
                break;
            }
            case 2: {
                updateProduct();
                break;
            }
            case 3: {
                createOrder();
                break;
            }
            case 4: {
                updateOrder();
                break;
            }
        }
    }

    public static int printMenu(ArrayList<String> nameList, int limitChoice) {
        for (String string : nameList) {
            System.out.println(string);
        }
        int choice = -1;

        do {
            System.out.print("Choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                continue;
            }
        } while (choice < 0 || choice > limitChoice);
        return choice;
    }

    public static User checkLogin() throws SQLException {
        User user = new User();
        UserBL userBL = new UserBL();
        while (true) {
            System.out.print("Input username: ");
            String username = scanner.nextLine();
            if (username.equals("")) {
                System.out.println("Username not correct");
                continue;
            }
            Console console = System.console();
            char[] passwordArray = console.readPassword("Input password: ");
            String password = new String(passwordArray);
            if (password.equals("")) {
                System.out.println("Password not correct");
                continue;
            }
            user = userBL.getUser(username, password);
            if (user != null) {
                System.out.println("Login successfully");
                break;
            } else {
                System.out.println("Username or Password not correct");
            }
        }
        return user;
    }

    public static void insertProduct(int choice1) {
        Product product = new Product();
        ProductBL productBL = new ProductBL();
        switch (choice1) {
            case 1: {
                product.setCategoryID(1);
                break;
            }
            case 2: {
                product.setCategoryID(2);
                break;
            }
            case 3: {
                product.setCategoryID(3);
                break;
            }
            case 4: {
                product.setCategoryID(4);
                break;
            }
        }
        try {
            System.out.print("Product Name: ");
            product.setProductName(scanner.nextLine());
            System.out.print("Description: ");
            product.setDescription(scanner.nextLine());
            System.out.print("Price: ");
            product.setPrice(Long.valueOf(scanner.nextLine()));
            System.out.print("Size: ");
            product.setSize(scanner.nextLine());
            System.out.print("Color: ");
            product.setColor(scanner.nextLine());
            System.out.print("Time Warranty: ");
            product.setTimeWarranty(scanner.nextLine());
            if (productBL.insertProductBL(product)) {
                System.out.println("Insert completed!");
            } else {
                System.out.println("Insert failed!");
            }
        } catch (Exception e) {
            System.out.println("Insert failed!");
            System.out.println("Price just have numbers");
            insertProduct(choice1);
        }

    }

    public static void updateProduct() {
        Product product = new Product();
        ProductBL productBL = new ProductBL();
        while (true) {
            System.out.print("Input product name need to update: ");
            String productName = scanner.nextLine();
            product = productBL.getByName(productName);
            if (product != null) {
                try {
                    System.out.print("Product Name: ");
                    product.setProductName(scanner.nextLine());
                    System.out.print("Description: ");
                    product.setDescription(scanner.nextLine());
                    System.out.print("Price: ");
                    product.setPrice(Long.valueOf(scanner.nextLine()));
                    System.out.print("Size: ");
                    product.setSize(scanner.nextLine());
                    System.out.print("Color: ");
                    product.setColor(scanner.nextLine());
                    System.out.print("Time Warranty: ");
                    product.setTimeWarranty(scanner.nextLine());
                    if (productBL.updateProductBL(product, productName)) {
                        System.out.println("Update completed!");
                        break;
                    } else {
                        System.out.println("Update failed!");
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Update failed!");
                }
            } else {
                System.out.print("Product not found \n");
            }
        }
    }

    public static void createOrder() {
        Order order = new Order();
        Customer customer = new Customer();
        // insert customer
        customer = insertCustomerToOrder();
        order.setCustomer(customer);
        // insert products
        do {
            order.addProduct(insertProductToOrder());
            System.out.print("Do you want to add another products? (Yes/No): ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("no")) {
                break;
            }
        } while (true);
        OrderBL orderBL = new OrderBL();
        if (orderBL.insertOrder(order)) {
            System.out.println("Insert completed");
            System.out.println("Your order");
            
        } else {
            System.out.println("Insert failed");

        }

    }

    public static Customer insertCustomerToOrder() {
        Customer customer = new Customer();
        System.out.print("Name Customer: ");
        customer.setCustomerName(scanner.nextLine());
        System.out.print("Address Customer: ");
        customer.setCustomerAddress(scanner.nextLine());
        System.out.print("Phone Number: ");
        customer.setPhoneNumber(scanner.nextLine());
        System.out.print("Identity Card: ");
        customer.setIdentityCard(scanner.nextLine());
        return customer;
    }

    public static Product insertProductToOrder() {
        System.out.print("Name Product: ");
        String productName = scanner.nextLine();
        Product product = getByName(productName);
        if (product != null) {
            
            do{
                System.out.print("Input quantity: ");
                try {
                    int quantity = Integer.parseInt(scanner.nextLine());
                product.setQuantity(quantity);
                break;
                } catch (Exception e) {
                    System.out.println("Quantity is very large!");
                    
                }
            }while(true);
            
            
        }
        return product;
    }

    public static Product getByName(String productName) {
        Product product = new Product();
        ProductBL productBL = new ProductBL();
        product = productBL.getByName(productName);
        if (product != null) {
            System.out.println("Product found");
            return product;
        } else {
            System.out.println("Product not found");
            return null;
        }
    }

    public static void updateOrder(){
        Order order = getOrderByID();
        System.out.println("Update Order");
        System.out.println("1. Customer");
        System.out.println("2. List Products");
        System.out.print("Update?(1/2): ");
        int choice = Integer.valueOf(scanner.nextLine());
        switch(choice){
            case 1:{
                updateCustomer();
                break;
            }
            case 2:{
                insertProductToUpdateOrder(order.getOrderID());
                break;
            }
        }
    }

    public static Order getOrderByID(){
        Order order = new Order();
        OrderBL orderBL = new OrderBL();
        do{
            try {
                System.out.print("Input orderID: ");
            int orderID = Integer.valueOf(scanner.nextLine());
            order = orderBL.getByID(orderID);
            if(order.getOrderID() == orderID){
                break;
            }
            else{
                System.out.print("Order not found!\nDo you want to continue?(Yes/No): ");
                String confirm = scanner.nextLine();
                if(confirm.equalsIgnoreCase("NO")){
                    System.exit(0);
                }
            }
            } catch (Exception e) {
                System.out.print("Order not found!\nDo you want to continue?(Yes/No): ");
                String confirm = scanner.nextLine();
                if(confirm.equalsIgnoreCase("NO")){
                    System.exit(0);
                }
            }
        }while(true);
        return order;
    }
    public static void updateCustomer() {
        Customer customer = new Customer();
        CustomerBL customerBL = new CustomerBL();
        while (true) {
            System.out.print("Input customerID: ");
            String customerID = scanner.nextLine();
            customer = customerBL.getCustomer(customerID);
            if (customer != null) {
                try {
                    System.out.print("Name Customer: ");
                    customer.setCustomerName(scanner.nextLine());
                    System.out.print("Address Customer: ");
                    customer.setCustomerAddress(scanner.nextLine());
                    System.out.print("Phone Number: ");
                    customer.setPhoneNumber(scanner.nextLine());
                    System.out.print("Identity Card: ");
                    customer.setIdentityCard(scanner.nextLine());
                    if (customerBL.updateCustomer(customer, customerID)){
                        System.out.println("Update completed!");
                        break;
                    } else {
                        System.out.println("Update failed!");
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Update failed");
                }

            } else {
                System.out.print("Customer not found \n");
            }
        }
    }

    public static void insertProductToUpdateOrder(int orderID){
        Order order = new Order();
        order.setOrderID(orderID);
        OrderDetailsBL orderDetailsBL = new OrderDetailsBL();
        do {
            order.addProduct(insertProductToOrder());
            System.out.print("Do you want to add another products? (Yes/No): ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("no")) {
                break;
            }
        } while (true);
        if (orderDetailsBL.updateOrderDetails(order, orderID)) {
            System.out.println("Update completed");
        }
        else {
            System.out.println("Update failed");
        }
    }
}