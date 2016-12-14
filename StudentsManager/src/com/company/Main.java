package com.company;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String userInput = "";
        Menu menu = new Menu();
        menu.showMenu();

        System.out.println("Please input your choice: ");
        Scanner scanner = new Scanner(System.in);
        userInput = scanner.nextLine();

        switch (userInput) {
            case "1": {
                System.out.println("Your choice is 1");
                break;
            }
            case "2": {
                break;
            }
            case "3": {
                break;
            }
            default: {
                //Ask for valid input from user
                break;
            }
        }
    }
}
