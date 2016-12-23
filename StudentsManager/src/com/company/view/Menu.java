package com.company.view;

import com.company.controller.Controller;
import com.company.model.Student;

import java.util.Scanner;

/**
 * Created by itbrainiacs1 on 12/14/16.
 */
public class Menu {
    private Controller controller;

    public Menu(Controller controller){
        this.controller = controller;
    }
    private void showMenu() {
        System.out.println("1. Add Student");
        System.out.println("2. View all Students");
        System.out.println("3. Remove Student");
        System.out.println("4. Add Discipline");
        System.out.println("5. View all Disciplines");
        System.out.println("6. Remove discipline");
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        userInput = scanner.nextLine();
        switch (userInput){
            case "1": {
                System.out.println("Input First Name: ");
                String firstName = scanner.nextLine();
                System.out.println("Input Last Name: ");
                String lastName = scanner.nextLine();
                System.out.println("Input Age: ");
                int age = Integer.parseInt(scanner.nextLine());
                Student student = new Student(firstName,lastName,age);
                this.controller.addStudent(student);
            }

        }
    }
    public void run(){
        while(true){
            this.showMenu();
        }
    }
}
