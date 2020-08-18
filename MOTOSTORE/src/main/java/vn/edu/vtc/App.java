package vn.edu.vtc;

import vn.edu.vtc.bl.ProductBL;
import vn.edu.vtc.bl.UserBL;
import vn.edu.vtc.persitance.Product;
import vn.edu.vtc.persitance.User;

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
        checkLogin();
        int choice = printMenu(mainMenu, 4);
        switch (choice) {
            case 1: {
                int choice1 = printMenu(menuInsert, 4);
                insertProduct(choice1);
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
        while (true) {
            System.out.print("Input username: ");
            String username = scanner.nextLine();
            if (username.equals("")) {
                System.out.println("Username not correct type");
                continue;
            }
            Console console = System.console();
            char[] passwordArray = console.readPassword("Input password: ");
            String password = new String(passwordArray);
            UserBL userBL = new UserBL();
            user = userBL.getUser(username, password);
            if (user != null) {
                System.out.println("Login successfully");

                break;
            } else {
                System.out.println("Login failed");
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

    public static boolean updateProduct() {

        return true;
    }

    public static boolean insertOrder() {

        return true;
    }

    public static boolean updateOrder() {

        return true;
    }
}