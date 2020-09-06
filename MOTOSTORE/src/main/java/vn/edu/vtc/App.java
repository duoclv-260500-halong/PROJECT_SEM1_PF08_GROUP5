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
import java.util.Scanner;

public class App {
    private static Scanner scanner = new Scanner(System.in);
    static ArrayList<String> mainMenu = new ArrayList<String>();
    static ArrayList<String> menuInsert = new ArrayList<String>();
    static ArrayList<String> menuUpdate = new ArrayList<String>();
    static ArrayList<String> menuInsertProductToOrder = new ArrayList<String>();

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
        checkLogin();
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

    public static int printMenu(ArrayList<String> nameList, int limitChoice) {
        System.out.println("--------------------------------");
        System.out.println("|-----Welcome to MOTOSTORE-----|");
        for (String string : nameList) {
            System.out.println("| " + string + " |");
        }
        int choice = -1;
        System.out.println("--------------------------------");
        do {
            System.out.print("  Choice: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice < 0 || choice > limitChoice) {
                    System.out.println("  Choice 0 - " + limitChoice);
                }
            } catch (Exception e) {
                System.out.println("  Choice 0 - " + limitChoice);
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

                System.out.print("  Input username: ");
                String username = scanner.nextLine();
                if (username.equals("")) {
                    System.out.println("  Username not correct");
                    continue;
                }
                Console console = System.console();
                char[] passwordArray = console.readPassword("  Input password: ");
                String password = new String(passwordArray);
                System.out.println("--------------------------------");
                if (password.equals("")) {
                    System.out.println("  Password not correct\n");
                    continue;
                }
                user = userBL.getUser(username, password);
                if (user != null) {
                    System.out.println("  Login successfully\n");
                    break;
                } else {
                    System.out.println("  Username or Password not correct\n");
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
                System.out.print("  Product Name: ");
                product.setProductName(scanner.nextLine());
                if (product.getProductName() == null || product.getProductName().equals("")) {
                    System.out.println("  Product name must not empty");
                }
            }
            while (product.getDescription() == null || product.getDescription().equals("")) {
                System.out.print("  Description: ");
                product.setDescription(scanner.nextLine());
                if (product.getDescription() == null || product.getDescription().equals("")) {
                    System.out.println("  Description must not empty");
                }
            }
            while (product.getPrice() <= 0) {
                try {
                    System.out.print("  Price: ");
                    product.setPrice(Long.valueOf(scanner.nextLine()));
                    if (product.getPrice() <= 0) {
                        System.out.println("  Price must > 0");
                    }
                } catch (Exception e) {
                    System.out.println("  Price must > 0");
                }
            }
            while (product.getSize() == null || product.getSize().equals("")) {
                System.out.print("  Size: ");
                product.setSize(scanner.nextLine());
                if (product.getSize() == null || product.getSize().equals("")) {
                    System.out.println("  Size must not empty");
                }
            }
            while (product.getColor() == null || product.getColor().equals("")) {
                System.out.print("  Color: ");
                product.setColor(scanner.nextLine());
                if (product.getColor() == null || product.getColor().equals("")) {
                    System.out.println("  Color must not empty");
                }
            }
            while (product.getTimeWarranty() == null || product.getTimeWarranty().equals("")) {
                System.out.print("  Time Warranty: ");
                product.setTimeWarranty(scanner.nextLine());
                if (product.getTimeWarranty() == null || product.getTimeWarranty().equals("")) {
                    System.out.println("  Time Warranty must not empty");
                }
            }

            System.out.println("--------------------------------");
            showProduct(product);
            System.out.print("Are you already insert this product? (Yes/No): ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("yes")) {
                if (productBL.insertProductBL(product)) {
                    System.out.println("  Insert completed!\n");
                } else {
                    System.out.println("  Insert failed!\n");
                }
            } else {
                System.out.println("  Insert failed!\n");
            }
            System.out.print("  Do you want to insert another products? (Yes/No): ");
            String confirm1 = scanner.nextLine();
            if (confirm1.equalsIgnoreCase("no")) {
                break;
            }
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
                    System.out.println("  Input new information: ");
                    System.out.print("  Product Name: ");
                    product.setProductName(scanner.nextLine());
                    while (product.getProductName() == null || product.getProductName().equals("")) {
                        System.out.println("  Product name must not empty");
                        System.out.print("  Product Name: ");
                        product.setProductName(scanner.nextLine());
                    }
                    System.out.print("  Description: ");
                    product.setDescription(scanner.nextLine());
                    while (product.getDescription() == null || product.getDescription().equals("")) {
                        System.out.println("  Description must not empty");
                        System.out.print("  Description: ");
                        product.setDescription(scanner.nextLine());
                    }
                    while (true) {
                        try {
                            System.out.print("  Price: ");
                            product.setPrice(Long.valueOf(scanner.nextLine()));
                            if (!(product.getPrice() > 0)) {
                                System.out.println("  Price must > 0");
                                continue;
                            }
                            break;

                        } catch (Exception e) {

                            System.out.println("  Price must > 0");
                            continue;

                        }
                    }
                    System.out.print("  Size: ");
                    product.setSize(scanner.nextLine());
                    while (product.getSize() == null || product.getSize().equals("")) {
                        System.out.println("  Size must not empty");
                        System.out.print("  Size: ");
                        product.setSize(scanner.nextLine());
                    }
                    System.out.print("  Color: ");
                    product.setColor(scanner.nextLine());
                    while (product.getColor() == null || product.getColor().equals("")) {
                        System.out.println("  Color must not empty");
                        System.out.print("  Color: ");
                        product.setColor(scanner.nextLine());
                    }
                    System.out.print("  Time Warranty: ");
                    product.setTimeWarranty(scanner.nextLine());
                    while (product.getTimeWarranty() == null || product.getTimeWarranty().equals("")) {
                        System.out.println("  Time Warranty must not empty");
                        System.out.print("  Time Warranty: ");
                        product.setTimeWarranty(scanner.nextLine());
                    }
                    System.out.println("--------------------------------");
                    showProduct(product);
                    System.out.print("Are you already update this product? (Yes/No): ");
                    String confirm = scanner.nextLine();
                    if (confirm.equalsIgnoreCase("yes")) {
                        if (productBL.updateProductBL(product, product.getProductID())) {
                            System.out.println("  Update completed!\n");
                        } else {
                            System.out.println("  Update failed!\n");
                        }
                    } else {
                        System.out.println("  Update failed!\n");
                    }

                } else {
                    System.out.println("productID not correct, please choose again");
                }
            } else {
                System.out.println("--------------------------------");
                System.out.print("  Not found any products\n");
            }
            System.out.print("  Do you want to update another product? (Yes/No): ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("no")) {
                break;
            }
        }
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
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------------------");
        System.out.println(
                "|  ID   |                     Name                     |     Price      |       Size       |      Color     |   Time Warranty   |");
        for (int i = 1;; i++) {
            System.out.println(
                    "---------------------------------------------------------------------------------------------------------------------------------");
            for (int j = i * 10 - 9; j <= i * 10; j++) {

                try {
                    System.out.format("|%4d   |%32s              |%12d    |%13s     |  %12s  |     %9s     |\n",
                            listProducts.get(j - 1).getProductID(), listProducts.get(j - 1).getProductName(),
                            listProducts.get(j - 1).getPrice(), listProducts.get(j - 1).getSize(),
                            listProducts.get(j - 1).getColor(), listProducts.get(j - 1).getTimeWarranty());

                } catch (Exception e) {
                    break;
                }
            }
            System.out.println(
                    "---------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("1. Trang truoc");
            System.out.println("2. Trang sau");
            System.out.println("3. Chon san pham");
            System.out.println("0. Exit");
            System.out.print("Choice: ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1": {
                    if (i == 1) {
                        System.out.println("Can't go to the previous page, you're on the first page");
                        i--;
                        break;
                    } else {
                        i -= 2;
                        break;
                    }
                }
                case "2": {
                    if (i >= (int) Math.ceil(((double) sizeListProduct + 1) / 10)) {
                        System.out.println("Can't go to the next page, you're on the last page");
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
                case "0": {
                    return -1;
                }
                default: {
                    System.out.println("Please choose 1-3");
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
                System.out.print("  Not found any products\n");
            }

            System.out.print("  Do you want to add another products? (Yes/No): ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("no")) {
                order.setProducts(products);
                break;
            }
        }
        showOrder(order);
        System.out.print("Are you already create this order? (Yes/No): ");
        String confirm = scanner.nextLine();
        if (confirm.equals("yes")) {
            OrderBL orderBL = new OrderBL();
            if (orderBL.insertOrder(order)) {
                System.out.println("  Create completed");
                System.out.println("  Your order");
                System.out.println(
                        "----------------------------------------------------------------------------------------------------");
                System.out.println("  " + order.getShopName());
                System.out.println("  Address: " + order.getShopAddress());
                System.out.println("  Hotline: " + order.getHotline());
                System.out.println("  Order ID: " + order.getOrderID());
                System.out.println(
                        "----------------------------------------------------------------------------------------------------");
                showOrder(order);
                System.out.println("          Seller                                                 Buyer");
                System.out.println("         Lân béo     ");
            } else {
                System.out.println("--------------------------------");
                System.out.println("  Create failed");
            }
        } else {
            System.out.println("  Canceled order creation");
        }
    }

    public static Customer insertCustomerToOrder() {
        Customer customer = new Customer();
        System.out.println("--------------------------------");
        System.out.println("|--------Insert Customer-------|");
        System.out.print("  Name Customer: ");
        customer.setCustomerName(scanner.nextLine());
        while (customer.getCustomerName() == null || customer.getCustomerName().isEmpty()) {
            System.out.println("  Name Customer must have characters ");
            System.out.print("  Name Customer: ");
            customer.setCustomerName(scanner.nextLine());
        }
        System.out.print("  Address Customer: ");
        customer.setCustomerAddress(scanner.nextLine());
        while (customer.getCustomerAddress() == null || customer.getCustomerAddress().isEmpty()) {
            System.out.println("  Address Customer must have characters ");
            System.out.print("  Address Customer: ");
            customer.setCustomerAddress(scanner.nextLine());
        }
        Validation validPhoneNumber = new Validation();
        System.out.print("  Phone Number: ");
        customer.setPhoneNumber(scanner.nextLine());
        while (!validPhoneNumber.isValidPhoneNumber(customer.getPhoneNumber())) {
            System.out.println("  PhoneNumber have to 10 numbers ");
            System.out.print("  Phone Number: ");
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

        System.out.println("Customer");
        System.out.println("ID: " + order.getCustomer().getCustomerID());
        System.out.println("Name: " + order.getCustomer().getCustomerName());
        System.out.println("PhoneNumber: " + order.getCustomer().getPhoneNumber());
        System.out.println("Address: " + order.getCustomer().getCustomerAddress() + "\n");
        System.out.println("List products:");
        System.out.println(
                "----------------------------------------------------------------------------------------------------");
        System.out.println(
                "|  STT  |                     Name                     |     Price      |   Quantity   |   Amount   |");
        System.out.println(
                "----------------------------------------------------------------------------------------------------");
        int i = 1;
        long total = 0;
        for (Product product : order.getProducts()) {
            System.out.format("|%4d   |%32s              |%12d    |%9d     |%9d   |\n", (i++), product.getProductName(),
                    product.getPrice(), product.getQuantity(), product.getPrice() * product.getQuantity());
            total += product.getPrice() * product.getQuantity();
        }
        System.out.println(
                "----------------------------------------------------------------------------------------------------");
        System.out.println("                                                          Total price:" + total);
        System.out.println(
                "                                                              HA NOI, " + java.time.LocalDate.now());
        System.out.println(
                "----------------------------------------------------------------------------------------------------");
    }

    public static void updateOrder() {
        Order order = getOrderByID();
        if (order != null) {
            showOrder(order);
            System.out.print("Do you want to update this order? (Yes/No): ");
            String confirm = scanner.nextLine();
            if (confirm.equals("yes")) {
                System.out.println("--------------------------------");
                System.out.println("|-------Menu Update Order------|");
                System.out.println("| 1. Customer                  |");
                System.out.println("| 2. List Products             |");
                System.out.println("--------------------------------");
                System.out.print(" Update?(1/2): ");
                int choice = Integer.valueOf(scanner.nextLine());
                switch (choice) {
                    case 1: {
                        updateCustomer();
                        break;
                    }
                    case 2: {
                        updateProductInOrder(order.getOrderID());
                        break;
                    }
                }
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
                System.out.print(" Input orderID: ");
                int orderID = Integer.valueOf(scanner.nextLine());
                order = orderBL.getByID(orderID);
                if (order.getOrderID() == orderID) {
                    break;
                } else {
                    System.out.print(" Order not found!\n Do you want to continue?(Yes/No): ");
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
                    System.out.print(" Input customerID: ");
                    customerID = Integer.valueOf(scanner.nextLine());
                    if (customerID < 0) {
                        System.out.println(" CustomerID must > 0");
                    }
                    customer = customerBL.getCustomer(customerID);
                    break;
                } catch (Exception e) {
                    System.out.println(" CustomerID must > 0");
                    continue;
                }

            }
            if (customer != null) {
                try {
                    System.out.print(" Name Customer: ");
                    customer.setCustomerName(scanner.nextLine());
                    while (customer.getCustomerName() == null || customer.getCustomerName().isEmpty()) {
                        System.out.println(" Name Customer must have characters ");
                        System.out.print(" Name Customer: ");
                        customer.setCustomerName(scanner.nextLine());
                    }
                    System.out.print(" Address Customer: ");
                    customer.setCustomerAddress(scanner.nextLine());
                    while (customer.getCustomerAddress() == null || customer.getCustomerAddress().isEmpty()) {
                        System.out.println(" Address Customer must have characters ");
                        System.out.print(" Address Customer: ");
                        customer.setCustomerName(scanner.nextLine());
                    }
                    System.out.print(" Phone Number: ");
                    customer.setPhoneNumber(scanner.nextLine());
                    while (!valid.isValidPhoneNumber(customer.getPhoneNumber())) {
                        System.out.println(" Phone Number have to 10 number: ");
                        System.out.print(" Phone Number: ");
                        customer.setPhoneNumber(scanner.nextLine());
                    }
                    System.out.println("--------------------------------");
                    System.out.print("Are you already update customer? (Yes/No)");
                    String confirm = scanner.nextLine();
                    if (confirm.equalsIgnoreCase("yes")) {
                        if (customerBL.updateCustomer(customer, customerID)) {
                            System.out.println("Update completed!\n");
                            System.out.println(customer);
                            break;
                        } else {
                            System.out.println(" Update failed");
                            System.out.print(" Do you want to update again? (Yes/No): ");
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
                    System.out.println(" Update failed");
                    System.out.print(" Do you want to update again? (Yes/No): ");
                    String confirm = scanner.nextLine();
                    if (confirm.equalsIgnoreCase("no")) {
                        break;
                    }
                }

            } else {
                System.out.println("--------------------------------");
                System.out.print(" Customer not found \n");
                System.out.print(" Do you want to update again? (Yes/No): ");
                String confirm = scanner.nextLine();
                if (confirm.equalsIgnoreCase("no")) {
                    break;
                }
            }
        }
    }

    public static void updateProductInOrder(int orderID) {
        Order order = new Order();
        order.setOrderID(orderID);
        order.setOrderStatus(2);
        System.out.print("Reason to update: ");
        String reasonUpdate = scanner.nextLine();
        OrderBL orderBL = new OrderBL();
        OrderDetailsBL orderDetailsBL = new OrderDetailsBL();
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
                System.out.print("  Not found any products\n");
            }

            System.out.print("  Do you want to add another products? (Yes/No): ");
            String confirm = scanner.nextLine();
            if (confirm.equalsIgnoreCase("no")) {
                order.setProducts(products);
                break;
            }
        }
        showOrder(order);
        System.out.print("  Are you already update this order (Yes/No): ");
        String confirm = scanner.nextLine();
        if (confirm.equalsIgnoreCase("yes")) {
            if (orderDetailsBL.updateOrderDetails(order, order.getOrderID()) && orderBL.updateOrder(order.getOrderID(), order.getOrderStatus(), reasonUpdate)) {
                System.out.println(" Update completed");
                showOrder(order);
            } else {
                System.out.println(" Update failed");
            }
        } else {
            System.out.println("Canceled update order");
        }
    }
}