package vn.edu.vtc;

import vn.edu.vtc.bl.UserBL;
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

        checkLogin();
        printMenu(mainMenu, 4);
        System.out.println("To be continue...");
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
            if (user != null){
                System.out.println("Login successfully");
                
                break;
            } else {
                System.out.println("Login failed");
            }
        }
        return user;

    }

    public static boolean insertProduct() {

        return true;
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