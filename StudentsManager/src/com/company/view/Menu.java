package com.company.view;

import com.company.controller.Controller;
import com.company.model.Student;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by itbrainiacs1 on 12/14/16.
 */
public class Menu
{
    private Controller controller;
    public Menu(Controller controller){
        this.controller = controller;
    }

    //Run menu non-stop
    public void run()
    {
        while(true)
        {
            this.showMenu();
        }
    }

    // Show menu and take input function
    private void showMenu()
    {
        System.out.println("1. Add Student");
        System.out.println("2. View all Students");
        System.out.println("3. Remove Student");
        System.out.println("4. Add Discipline");
        System.out.println("5. View all Disciplines");
        System.out.println("6. Remove discipline");
        Scanner scanner = new Scanner(System.in);
        String userInput = "";
        userInput = scanner.nextLine();
        switch (userInput)
        {
            case "0":
            {
                scanner.close();
            }
            case "1":
            {
                System.out.println("Input First Name: ");
                String firstName = scanner.nextLine();
                System.out.println("Input Last Name: ");
                String lastName = scanner.nextLine();
                System.out.println("Input Age: ");
                int age = Integer.parseInt(scanner.nextLine());
                Student student = new Student(firstName,lastName,age);
                this.controller.addStudent(student);
                break;
<<<<<<< HEAD
            }
            case "2":
            {
                this.controller.showStudents();
                break;
            }
            case"3":
            {
                System.out.println("Input First Name: ");
                String firstName = scanner.nextLine();
                System.out.println("Input Last Name: ");
                String lastName = scanner.nextLine();
                System.out.println("Input Age: ");
                int age = Integer.parseInt(scanner.nextLine());
                Student student = new Student(firstName,lastName,age);
                this.controller.removeStudent(student);
                break;
            }
            case "4" :
            {
                System.out.println("Input Disciplines Name: ");
                String name = scanner.nextLine();
                System.out.println("Input Teacher's Name: ");
                String teacherName = scanner.nextLine();
                System.out.println("Add students(input 1 to add student everytime and 0 to stop): ");
                ArrayList<Student> studentsThatAttendThisDiscipline = new ArrayList<Student>();
                while(Integer.parseInt(scanner.nextLine())!=0) {
                    System.out.println("Input First Name: ");
                    String firstName = scanner.nextLine();
                    System.out.println("Input Last Name: ");
                    String lastName = scanner.nextLine();
                    System.out.println("Input Age: ");
                    int age = Integer.parseInt(scanner.nextLine());
                    Student student = new Student(firstName, lastName, age);
                    studentsThatAttendThisDiscipline.add(student);
                }
=======
            }
            case "2" : {
                for(Student student : this.controller.getAllStudents()) {
                    System.out.println(student.toString());
                }
                break;
            }
            case "3" : {
                System.out.println("Input First Name: ");
                String firstName = scanner.nextLine();
                System.out.println("Input Last Name: ");
                String lastName = scanner.nextLine();
                System.out.println("Input Age: ");
                int age = Integer.parseInt(scanner.nextLine());
                Student student = new Student(firstName,lastName,age);
                this.controller.removeStdudent(student);
                break;
            }

>>>>>>> origin/master

            }
            default:
            {
                System.out.println("Please input a valid number!(a number between 1 and 10, to close the app please input 0)");
                break;
            }
        }
    }

}
