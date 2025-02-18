package org.loginapp;

import org.loginapp.service.UserService;

import java.util.InvalidPropertiesFormatException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome, Sir.");

        Scanner scanner = new Scanner(System.in);
        UserService userService = new UserService();
        boolean flag = true;
        while (flag) {
            System.out.println("Register-->1: Login-->2: Exit-->3");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter email: ");
                    String regEmail = scanner.nextLine();
                    while (!regEmail.matches(".*@.*")) {
                        System.out.println("Enter valid email: ");
                        regEmail = scanner.nextLine();
                    }
                    System.out.print("Enter password: ");
                    String regPassword = scanner.nextLine();
                    while (!regPassword.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d).{6,20}$")) {
                        System.out.print("Enter valid password");
                        regPassword = scanner.nextLine();
                    }
                    if (userService.registerUser(regEmail, regPassword)) {
                        System.out.println("Registartion succesfull...");
                    }

                    break;
                case 2:
                    System.out.print("Enter email: ");
                    String logEmail = scanner.nextLine();
                    while (!logEmail.matches(".*@.*")) {
                        System.out.println("Enter valid email: ");
                        logEmail = scanner.nextLine();
                    }
                    System.out.print("Enter password");
                    String logPassword = scanner.nextLine();
                    if (userService.loginUser(logEmail, logPassword)) {
                        System.out.println("Login successful!");
                    } else {
                        System.out.println("Invalid username or password.");
                    }
                    break;
                case 3:
                    break;
            }

        }


    }
}