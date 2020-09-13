package vn.edu.vtc;

import vn.edu.vtc.bl.CustomerBL;
import vn.edu.vtc.bl.OrderBL;
import vn.edu.vtc.bl.OrderDetailsBL;
import vn.edu.vtc.bl.ProductBL;
import vn.edu.vtc.bl.UserBL;
import vn.edu.vtc.bl.Validation;
import vn.edu.vtc.persistance.Customer;
import vn.edu.vtc.persistance.Order;
import vn.edu.vtc.persistance.Product;
import vn.edu.vtc.persistance.User;
import java.io.Console;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> mainMenu = new ArrayList<String>();
    static ArrayList<String> menuInsert = new ArrayList<String>();
    static ArrayList<String> menuUpdate = new ArrayList<String>();
    static ArrayList<String> menuInsertProductToOrder = new ArrayList<String>();
    static ArrayList<String> menuAddProductToUpdateOrder = new ArrayList<String>();

    public static void main(String[] args) {

        mainMenu.add("1. Insert Product           ");
        mainMenu.add("2. Update Product           ");
        mainMenu.add("3. Insert Order             ");
        mainMenu.add("4. Update Order             ");
        mainMenu.add("0. Exit                     ");

        menuInsert.add("1. Insert Moto              ");
        menuInsert.add("2. Insert Hat               ");
        menuInsert.add("3. Insert Clothes           ");
        menuInsert.add("4. Insert Gloves            ");
        menuInsert.add("0. Exit                     ");

        menuUpdate.add("1. Update Moto              ");
        menuUpdate.add("2. Update Hat               ");
        menuUpdate.add("3. Update Clothes           ");
        menuUpdate.add("4. Update Gloves            ");
        menuUpdate.add("0. Exit                     ");

        menuInsertProductToOrder.add("Kind product want to sell?  ");
        menuInsertProductToOrder.add("1. Moto                     ");
        menuInsertProductToOrder.add("2. Hat                      ");
        menuInsertProductToOrder.add("3. Clothes                  ");
        menuInsertProductToOrder.add("4. Gloves                   ");
        menuInsertProductToOrder.add("0. Exit                     ");

        menuAddProductToUpdateOrder.add("1. Update quantity          ");
        menuAddProductToUpdateOrder.add("0. Exit                     ");

        try {
            checkLogin();
        } catch (Exception e) {
            System.out.println("Error");
            System.exit(0);
        }
        while (true) {
            int choice = printMenu(mainMenu, 4);
            switch (choice) {
                case 1: {
                    insertProduct();
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
                case 0: {
                    System.exit(0);
                }
            }
        }
    }

    public static void clrscr() {
        // Clears Screen in java
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (Exception e) {

        }
    }

    public static int printMenu(ArrayList<String> nameList, int limitChoice) {
        System.out.println("--------------------------------");
        System.out.println("|-----Welcome to MOTOSTORE-----|");
        for (String string : nameList) {
            System.out.println("| " + string + " |");
        }
        int choice = -1;
        System.out.println("--------------------------------");
        do {
            System.out.print("Choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 0 || choice > limitChoice) {
                    System.out.println("Choice 0 - " + limitChoice);
                }
            } catch (Exception e) {
                System.out.println("Choice 0 - " + limitChoice);
                continue;
            }
        } while (choice < 0 || choice > limitChoice);
        return choice;
    }

    public static User checkLogin() {
        User user = new User();
        UserBL userBL = new UserBL();
        try {
            while (true) {
                System.out.println("--------------------------------");
                System.out.println("|------------LOGIN-------------|");

                System.out.print("Input username: ");
                String username = scanner.nextLine();
                if (username.equals("")) {
                    System.out.println("Username not correct");
                    continue;
                }
                Console console = System.console();
                char[] passwordArray = console.readPassword("Input password: ");
                String password = new String(passwordArray);
                System.out.println("--------------------------------");
                if (password.equals("")) {
                    System.out.println("Password not correct\n");
                    continue;
                }
                user = userBL.getUser(username, password);
                if (user != null) {
                    clrscr();
                    System.out.println("Login successfully\n");
                    break;
                } else {
                    clrscr();
                    System.out.println("Username or Password not correct\n");
                }
            }

        } catch (Exception e) {
        }
        return user;
    }

    public static void insertProduct() {
        ProductBL productBL = new ProductBL();
        do {
            int choice1 = printMenu(menuInsert, 4);
            Product product = new Product();
            System.out.println("|          Menu Insert         |");
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
                case 0: {
                    product.setCategoryID(0);
                    break;
                }
            }
            if (product.getCategoryID() == 0) {
                break;
            }
            System.out.println("--------------------------------");
            System.out.println("|--------Insert Product--------|");
            while (product.getProductName() == null || product.getProductName().equals("")) {
                System.out.print("Product Name: ");
                product.setProductName(scanner.nextLine());
                if (product.getProductName() == null || product.getProductName().equals("")) {
                    System.out.println("Product name must not empty");
                }
            }
            while (product.getDescription() == null || product.getDescription().equals("")) {
                System.out.print("Description: ");
                product.setDescription(scanner.nextLine());
                if (product.getDescription() == null || product.getDescription().equals("")) {
                    System.out.println("Description must not empty");
                }
            }
            while (product.getPrice() <= 0) {
                try {
                    System.out.print("Price: ");
                    product.setPrice(Long.valueOf(scanner.nextLine()));
                    if (product.getPrice() <= 0) {
                        System.out.println("Price must > 0");
                    }
                } catch (Exception e) {
                    System.out.println("Price must > 0");
                }
            }
            while (product.getSize() == null || product.getSize().equals("")) {
                System.out.print("Size: ");
                product.setSize(scanner.nextLine());
                if (product.getSize() == null || product.getSize().equals("")) {
                    System.out.println("Size must not empty");
                }
            }
            while (product.getColor() == null || product.getColor().equals("")) {
                System.out.print("Color: ");
                product.setColor(scanner.nextLine());
                if (product.getColor() == null || product.getColor().equals("")) {
                    System.out.println("Color must not empty");
                }
            }
            while (product.getTimeWarranty() == null || product.getTimeWarranty().equals("")) {
                System.out.print("Time Warranty: ");
                product.setTimeWarranty(scanner.nextLine());
                if (product.getTimeWarranty() == null || product.getTimeWarranty().equals("")) {
                    System.out.println("Time Warranty must not empty");
                }
            }

            System.out.println("--------------------------------");
            showProduct(product);
            System.out.print("Are you already insert this product? (Yes/No): ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("yes")) {
                if (productBL.insertProductBL(product)) {
                    System.out.println("Insert completed!\n");
                } else {
                    System.out.println("Insert failed!\n");
                    System.out.println("Product already exists! (Name)\n");
                }
            } else {

                System.out.println("Canceled insert!\n");
            }
            System.out.print("Do you want to insert another products? (Yes/No): ");
            String confirm1 = scanner.nextLine();
            if (confirm1.equalsIgnoreCase("no")) {
                clrscr();
                break;
            }
            clrscr();
        } while (true);
    }

    public static void updateProduct() {

        while (true) {
            int categoryID = printMenu(menuUpdate, 4);
            switch (categoryID) {
                case 0: {
                    categoryID = 0;
                }
            }
            if (categoryID == 0) {
                break;
            }
            System.out.println("--------------------------------");
            System.out.println("|--------Update Product--------|");
            ProductBL productBL = new ProductBL();
            ArrayList<Product> listProducts = new ArrayList<>();
            listProducts = productBL.getByCategory(categoryID);
            if (listProducts.size() > 0) {

                int productID = printListProduct(listProducts, listProducts.size());
                if (productID == -1) {
                    continue;
                }
                Product product = getProductByID(productID);
                if (product != null) {
                    showProduct(product);
                    System.out.println("Input new information: ");
                    System.out.print("Product Name: ");
                    product.setProductName(scanner.nextLine());
                    while (product.getProductName() == null || product.getProductName().equals("")) {
                        System.out.println("Product name must not empty");
                        System.out.print("Product Name: ");
                        product.setProductName(scanner.nextLine());
                    }
                    System.out.print("Description: ");
                    product.setDescription(scanner.nextLine());
                    while (product.getDescription() == null || product.getDescription().equals("")) {
                        System.out.println("Description must not empty");
                        System.out.print("Description: ");
                        product.setDescription(scanner.nextLine());
                    }
                    while (true) {
                        try {
                            System.out.print("Price: ");
                            product.setPrice(Long.valueOf(scanner.nextLine()));
                            if (!(product.getPrice() > 0)) {
                                System.out.println("Price must > 0");
                                continue;
                            }
                            break;

                        } catch (Exception e) {

                            System.out.println("Price must > 0");
                            continue;
                        }
                    }
                    System.out.print("Size: ");
                    product.setSize(scanner.nextLine());
                    while (product.getSize() == null || product.getSize().equals("")) {
                        System.out.println("Size must not empty");
                        System.out.print("Size: ");
                        product.setSize(scanner.nextLine());
                    }
                    System.out.print("Color: ");
                    product.setColor(scanner.nextLine());
                    while (product.getColor() == null || product.getColor().equals("")) {
                        System.out.println("Color must not empty");
                        System.out.print("Color: ");
                        product.setColor(scanner.nextLine());
                    }
                    System.out.print("Time Warranty: ");
                    product.setTimeWarranty(scanner.nextLine());
                    while (product.getTimeWarranty() == null || product.getTimeWarranty().equals("")) {
                        System.out.println("Time Warranty must not empty");
                        System.out.print("Time Warranty: ");
                        product.setTimeWarranty(scanner.nextLine());
                    }
                    System.out.println("--------------------------------");
                    showProduct(product);
                    System.out.print("Are you already update this product? (Yes/No): ");
                    String confirm = scanner.nextLine();
                    if (confirm.equalsIgnoreCase("yes")) {
                        if (productBL.updateProductBL(product, product.getProductID())) {
                            System.out.println("Update completed!\n");
                        } else {
                            System.out.println("Update failed!\n");
                            System.out.println("This product is same name as another product!\n");
                        }
                    } else {
                        System.out.println("Canceled update!\n");
                    }

                } else {
                    System.out.println("productID not correct, please choose again");
                }
            } else {
                System.out.println("--------------------------------");
                System.out.print("Not found any products\n");
            }
            System.out.print("Do you want to update another product? (Yes/No): ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("no")) {
                clrscr();
                break;
            }

        }
        clrscr();
    }

    public static Product showProduct(Product product) {
        System.out.println("Product: ");
        System.out.println("ID: " + product.getProductID());
        System.out.println("Name: " + product.getProductName());
        System.out.println("Description: " + product.getDescription());
        System.out.println("Price: " + product.getPrice());
        System.out.println("Size: " + product.getSize());
        System.out.println("Color: " + product.getColor());
        System.out.println("Time Warranty: " + product.getTimeWarranty());
        System.out.println("--------------------------------------------");

        return product;
    }

    public static int printListProduct(ArrayList<Product> listProducts, int sizeListProduct) {
        int productID;
        int maxPage = (int) Math.ceil(((double) sizeListProduct + 1) / 10);
        for (int i = 1;; i++) {
            System.out.println(
                    "---------------------------------------------------------------------------------------------------------------------------------");
            System.out.println(
                    "|  ID   |                     Name                     |     Price      |       Size       |      Color     |   Time Warranty   |");
            System.out.println(
                    "---------------------------------------------------------------------------------------------------------------------------------");
            for (int j = i * 10 - 9; j <= i * 10; j++) {

                try {
                    System.out.format("|%7d|%46s|%16d|%18s|%16s|%19s|\n", listProducts.get(j - 1).getProductID(),
                            listProducts.get(j - 1).getProductName(), listProducts.get(j - 1).getPrice(),
                            listProducts.get(j - 1).getSize(), listProducts.get(j - 1).getColor(),
                            listProducts.get(j - 1).getTimeWarranty());

                } catch (Exception e) {
                    break;
                }
            }
            System.out.println(
                    "---------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("Page: " + i + "/" + maxPage);
            System.out.println("1. Previous page");
            System.out.println("2. Next page");
            System.out.println("3. Choose product");
            System.out.println("4. Select page");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": {
                    if (i == 1) {
                        i--;
                        break;
                    } else {
                        i -= 2;
                        break;
                    }
                }
                case "2": {
                    if (i >= (int) Math.ceil(((double) sizeListProduct + 1) / 10)) {
                        i--;
                        break;
                    } else {
                        break;
                    }
                }
                case "3": {
                    while (true) {
                        try {
                            System.out.print("Choice productID: ");
                            productID = Integer.valueOf(scanner.nextLine());
                            return productID;
                        } catch (Exception e) {
                            System.out.println("Please input number");
                        }
                    }
                }
                case "4": {
                    try {
                        System.out.print("Number of page: ");
                        int pageNumber = Integer.valueOf(scanner.nextLine());
                        if (pageNumber < 1 || pageNumber > maxPage) {
                            System.out.println("Not have page " + pageNumber);
                            i--;
                            break;
                        } else {
                            i = pageNumber - 1;
                            break;
                        }
                    } catch (Exception e) {
                        System.out.println("Please input number");
                    }
                }
                case "0": {
                    return -1;
                }
                default: {
                    System.out.println("Please choose 0-4");
                    i--;
                    break;
                }
            }
        }
    }

    public static Product getProductByID(int productID) {
        ProductBL productBL = new ProductBL();
        Product product = productBL.getProductByID(productID);
        return product;
    }

    public static void createOrder() {
        Order order = new Order();

        // insert customer
        Customer customer = insertCustomerToOrder();
        order.setCustomer(customer);
        // insert products
        ArrayList<Product> products = new ArrayList<>();
        while (true) {
            int categoryID = printMenu(menuInsertProductToOrder, 4);
            switch (categoryID) {
                case 0: {
                    categoryID = 0;
                }
            }
            if (categoryID == 0) {
                order.setProducts(products);
                break;
            }
            ArrayList<Product> listProducts = new ArrayList<>();
            ProductBL productBL = new ProductBL();
            listProducts = productBL.getByCategory(categoryID);
            if (listProducts.size() > 0) {
                while (true) {
                    int productID = printListProduct(listProducts, listProducts.size());
                    if (productID == -1) {
                        break;
                    }
                    Product product = getProductByID(productID);
                    if (product != null) {
                        insertProductToOrder(products, product);
                        break;
                    } else {
                        System.out.println("productID not correct, please choose again");
                        break;
                    }
                }
            } else {
                System.out.println("--------------------------------");
                System.out.print("Not found any products\n");
            }

            System.out.print("Do you want to add another products? (Yes/No): ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("no")) {
                order.setProducts(products);
                clrscr();
                break;
            }
        }
        showOrder(order);
        System.out.print("Are you already create this order? (Yes/No): ");
        String confirm = scanner.nextLine();
        if (confirm.equals("yes")) {
            order.setOrderStatus(1);
            OrderBL orderBL = new OrderBL();
            if (orderBL.insertOrder(order)) {
                clrscr();
                System.out.println("Create successfully");
                System.out.println("Your order");
                System.out.println(
                        "----------------------------------------------------------------------------------------------------");
                System.out.println(order.getShopName());
                System.out.println("Address: " + order.getShopAddress());
                System.out.println("Hotline: " + order.getHotline());
                System.out.println("Order ID: " + order.getOrderID());

                System.out.println(
                        "----------------------------------------------------------------------------------------------------");
                showOrder(order);
                System.out.println("                                                              HA NOI, "
                        + order.getTimeCreate().getDate() + "/" + (order.getTimeCreate().getMonth() + 1) + "/"
                        + (order.getTimeCreate().getYear() + 1900));
                System.out.println("          Seller                                                 Buyer");
                System.out.println("         Lân béo     ");
            } else {
                System.out.println("--------------------------------");
                System.out.println("Create failed");
            }
        } else {
            System.out.println("Canceled order creation");
        }
    }

    public static Customer insertCustomerToOrder() {
        Customer customer = new Customer();
        System.out.println("--------------------------------");
        System.out.println("|--------Insert Customer-------|");
        System.out.print("Name Customer: ");
        customer.setCustomerName(scanner.nextLine());
        while (customer.getCustomerName() == null || customer.getCustomerName().isEmpty()) {
            System.out.println("Name Customer must have characters ");
            System.out.print("Name Customer: ");
            customer.setCustomerName(scanner.nextLine());
        }
        System.out.print("Address Customer: ");
        customer.setCustomerAddress(scanner.nextLine());
        while (customer.getCustomerAddress() == null || customer.getCustomerAddress().isEmpty()) {
            System.out.println("Address Customer must have characters ");
            System.out.print("Address Customer: ");
            customer.setCustomerAddress(scanner.nextLine());
        }
        Validation validPhoneNumber = new Validation();
        System.out.print("Phone Number: ");
        customer.setPhoneNumber(scanner.nextLine());
        while (!validPhoneNumber.isValidPhoneNumber(customer.getPhoneNumber())) {
            System.out.println("PhoneNumber have to 10 numbers ");
            System.out.print("Phone Number: ");
            customer.setPhoneNumber(scanner.nextLine());
        }
        System.out.println("--------------------------------");
        return customer;
    }

    public static ArrayList<Product> insertProductToOrder(ArrayList<Product> products, Product product) {

        showProduct(product);
        System.out.print("Do you want to add this product? (yes/no): ");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("no")) {
            return products;
        } else if (confirm.equalsIgnoreCase("yes")) {

            while (!(product.getQuantity() > 0))
                try {
                    System.out.print("Input quantity: ");
                    product.setQuantity(Integer.valueOf(scanner.nextLine()));
                    if (!(product.getQuantity() > 0)) {
                        System.out.println("Quantity must > 0");
                    }
                } catch (Exception e) {
                    System.out.println("Quantity must > 0");
                }
            products.add(product);
        }
        return products;
    }

    public static void showOrder(Order order) {
        System.out.println(
                "----------------------------------------------------------------------------------------------------");
        if (order.getOrderStatus() == 0) {
            System.out.println("Status: Waiting for confirm");
        } else if (order.getOrderStatus() == 1) {
            System.out.println("Status: Created");
        } else if (order.getOrderStatus() == 2) {
            System.out.println("Status: Updated");
        }
        System.out.println(
                "----------------------------------------------------------------------------------------------------");
        System.out.println("Customer");
        System.out.println("ID: " + order.getCustomer().getCustomerID());
        System.out.println("Name: " + order.getCustomer().getCustomerName());
        System.out.println("PhoneNumber: " + order.getCustomer().getPhoneNumber());
        System.out.println("Address: " + order.getCustomer().getCustomerAddress() + "\n");
        System.out.println("List products:");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------");
        System.out.println(
                "|  ID   |                     Name                     |       Price       |   Quantity   |     Amount    |");
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------");
        long total = 0;
        for (Product product : order.getProducts()) {
            System.out.format("|%7d|%45s |%15d VND|%13d |%11d VND|\n", product.getProductID(), product.getProductName(),
                    product.getPrice(), product.getQuantity(), product.getPrice() * product.getQuantity());
            total += product.getPrice() * product.getQuantity();
        }
        System.out.println(
                "-----------------------------------------------------------------------------------------------------------");
        System.out
                .println("                                                                                Total price: "
                        + total + " VND");

        System.out.println(
                "-----------------------------------------------------------------------------------------------------------");
    }

    public static void updateOrder() {
        Order order = getOrderByID();
        Date date = new Date();
        if (order != null) {
            showOrder(order);
            if (order.getTimeCreate().getDate() == date.getDate() && order.getTimeCreate().getMonth() == date.getMonth()
                    && order.getTimeCreate().getYear() == date.getYear()) {
                System.out.print("Do you want to update this order? (Yes/No): ");
                String confirm = scanner.nextLine();
                if (confirm.equals("yes")) {
                    System.out.println("--------------------------------");
                    System.out.println("|-------Menu Update Order------|");
                    System.out.println("| 1. Customer                  |");
                    System.out.println("| 2. List Products             |");
                    System.out.println("--------------------------------");
                    System.out.print("Update?(1/2): ");
                    int choice = Integer.valueOf(scanner.nextLine());
                    switch (choice) {
                        case 1: {
                            updateCustomer();
                            break;
                        }
                        case 2: {
                            updateProductInOrder(order.getProducts(), order.getOrderID());
                            break;
                        }
                    }
                }
            } else {
                System.out.println("This order is not created today, can't update");
            }
        }
    }

    public static Order getOrderByID() {
        Order order = new Order();
        OrderBL orderBL = new OrderBL();
        do {
            try {
                System.out.println("--------------------------------");
                System.out.println("|---------Update Order---------|");
                System.out.print("Input orderID: ");
                int orderID = Integer.valueOf(scanner.nextLine());
                order = orderBL.getByID(orderID);
                if (order.getOrderID() == orderID) {
                    break;
                } else {
                    System.out.print("Order not found!\n Do you want to continue?(Yes/No): ");
                    String confirm = scanner.nextLine();
                    if (confirm.equalsIgnoreCase("NO")) {
                        return null;
                    }
                }
            } catch (Exception e) {
                System.out.print("Order not found!\nDo you want to continue?(Yes/No): ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("NO")) {
                    return null;
                }
            }
        } while (true);
        return order;
    }

    public static void updateCustomer() {
        Customer customer = new Customer();
        CustomerBL customerBL = new CustomerBL();
        Validation valid = new Validation();
        while (true) {
            int customerID;
            System.out.println("--------------------------------");
            System.out.println("|-------Update Customer--------|");
            while (true) {
                try {
                    System.out.print("Input customerID: ");
                    customerID = Integer.valueOf(scanner.nextLine());
                    if (customerID < 0) {
                        System.out.println("CustomerID must > 0");
                    }
                    customer = customerBL.getCustomer(customerID);
                    System.out.println(customer);
                    break;
                } catch (Exception e) {
                    System.out.println("CustomerID must > 0");
                    continue;
                }

            }
            if (customer != null) {
                try {
                    System.out.println("Input new information: ");
                    System.out.print("Name Customer: ");
                    customer.setCustomerName(scanner.nextLine());
                    while (customer.getCustomerName() == null || customer.getCustomerName().isEmpty()) {
                        System.out.println("Name Customer must have characters ");
                        System.out.print("Name Customer: ");
                        customer.setCustomerName(scanner.nextLine());
                    }
                    System.out.print("Address Customer: ");
                    customer.setCustomerAddress(scanner.nextLine());
                    while (customer.getCustomerAddress() == null || customer.getCustomerAddress().isEmpty()) {
                        System.out.println("Address Customer must have characters ");
                        System.out.print("Address Customer: ");
                        customer.setCustomerName(scanner.nextLine());
                    }
                    System.out.print("Phone Number: ");
                    customer.setPhoneNumber(scanner.nextLine());
                    while (!valid.isValidPhoneNumber(customer.getPhoneNumber())) {
                        System.out.println("Phone Number have to 10 number: ");
                        System.out.print("Phone Number: ");
                        customer.setPhoneNumber(scanner.nextLine());
                    }
                    System.out.println("--------------------------------");
                    System.out.println(customer);
                    System.out.print("Are you already update customer? (Yes/No)");
                    String confirm = scanner.nextLine();
                    if (confirm.equalsIgnoreCase("yes")) {
                        if (customerBL.updateCustomer(customer, customerID)) {
                            System.out.println("Update completed!\n");
                            
                            break;
                        } else {
                            System.out.println("Update failed");
                            System.out.print("Do you want to update again? (Yes/No): ");
                            String confirm1 = scanner.nextLine();
                            if (confirm1.equalsIgnoreCase("no")) {
                                break;
                            }
                        }
                    } else {
                        System.out.println("Canceled customer update!");
                        break;
                    }
                } catch (Exception e) {
                    System.out.println("Update failed");
                    System.out.print("Do you want to update again? (Yes/No): ");
                    String confirm = scanner.nextLine();
                    if (confirm.equalsIgnoreCase("no")) {
                        break;
                    }
                }

            } else {
                System.out.println("--------------------------------");
                System.out.print("Customer not found \n");
                System.out.print("Do you want to update again? (Yes/No): ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("no")) {
                    break;
                }
            }
        }
    }

    public static void updateProductInOrder(ArrayList<Product> listProductsInOrder, int orderID) {
        Order order = new Order();
        order.setOrderID(orderID);
        ArrayList<Product> productsToUpdate = listProductsInOrder;
        ArrayList<Product> productsToPrint = new ArrayList<>();
        System.out.print("Reason to update: ");
        String reasonUpdate = scanner.nextLine();
        OrderBL orderBL = new OrderBL();
        OrderDetailsBL orderDetailsBL = new OrderDetailsBL();

        while (true) {
            int choice = printMenu(menuAddProductToUpdateOrder, 1);
            if (choice == 1) {
                System.out.print("Input productID: ");
                try {
                    int productID = Integer.valueOf(scanner.nextLine());
                    int count = 0;
                    for (Product product : listProductsInOrder) {
                        if (product.getProductID() == productID) {
                            showProduct(getProductByID(productID));
                            productsToUpdate.remove(product);
                            System.out.print("Input new quantity: ");
                            try {
                                product.setQuantity(Integer.valueOf(scanner.nextLine()));
                                while (product.getQuantity() < 0) {
                                    System.out.println("Quantity >= 0");
                                    System.out.print("Input new quantity: ");
                                    product.setQuantity(Integer.valueOf(scanner.nextLine()));
                                }
                                productsToUpdate.add(product);
                                count++;
                                break;
                            } catch (Exception e) {
                                System.out.println("Quantity is a number");
                            }
                        }

                    }

                    for (Product product : productsToUpdate) {
                        if (product.getQuantity() > 0) {
                            productsToPrint.add(product);
                        }
                    }
                    if (count == 1) {
                        order.setProducts(productsToPrint);
                        showOrder(order);
                        continue;
                    }
                    System.out.println("Not found this product in order!");
                } catch (Exception e) {
                    System.out.print("ProductID must > 0 ");
                    continue;
                }

            } else if (choice == 0) {
                order.setProducts(productsToPrint);
                break;
            }
        }
        showOrder(order);
        System.out.print("  Are you already update this order (Yes/No): ");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("yes")) {
            order.setOrderStatus(2);
            order.setProducts(productsToUpdate);
            if (orderDetailsBL.updateOrderDetails(order, order.getOrderID())
                    && orderBL.updateOrder(order.getOrderID(), order.getOrderStatus(), reasonUpdate)) {
                clrscr();
                System.out.println(" Update completed");
                order.setProducts(productsToPrint);
                showOrder(order);
            } else {
                clrscr();
                System.out.println(" Update failed");
            }
        } else {
            clrscr();
            System.out.println("Canceled update order");
        }
    }
}