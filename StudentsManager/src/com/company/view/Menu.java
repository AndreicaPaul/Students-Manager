package com.company.view;

import com.company.controller.Controller;
import com.company.model.Discipline;
import com.company.model.Student;
import com.company.model.Teacher;

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
        System.out.println("7. Sort students by first name");
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

            }
            case "2" : {
                for(Student student : this.controller.getAllStudents()) {
                    System.out.println(student.toString());
                }
                break;
            }
            case "3" : {
                System.out.println("If you want to manually input the student press 1, if you want to select the student from a certain position press 2.");
                userInput = scanner.nextLine();
                switch (userInput) {
                    case "1" : {
                        System.out.println("Input First Name: ");
                        String firstName = scanner.nextLine();
                        System.out.println("Input Last Name: ");
                        String lastName = scanner.nextLine();
                        System.out.println("Input Age: ");
                        int age = Integer.parseInt(scanner.nextLine());
                        Student student = new Student(firstName, lastName, age);
                        this.controller.removeStdudent(student);
                        break;
                    }
                    case "2" : {
                        System.out.println("Note: this won't work unless you used function no.7 to sort the students");
                        System.out.println("Input position: ");
                        int pos = Integer.parseInt(scanner.nextLine());
                        this.controller.removeStudentFormPosition(pos);
                    }
                }
                break;
            }
            case "4" : {
                System.out.println("Input teacher name: ");
                String name = scanner.nextLine();
                System.out.println("Input teacher age: ");
                int age = Integer.parseInt(scanner.nextLine());
                Teacher teacher = new Teacher(name,age);
                System.out.println("Input discipline name: ");
                String disciplineName = scanner.nextLine();
                Discipline discipline = new Discipline(disciplineName,teacher);
                this.controller.addDiscipline(discipline);
                break;
            }
            case "5" : {
                for (Discipline discipline : this.controller.getAllDisciplines()){
                    System.out.println(discipline.toString());
                }
                break;
            }
            case "6" : {
                System.out.println("If you want to manually input the discipline press 1, if you want to select the discipline from a certain position press 2.");
                userInput = scanner.nextLine();
                switch (userInput) {
                    case "1" : {
                        System.out.println("Input teacher name: ");
                        String name = scanner.nextLine();
                        System.out.println("Input teacher age: ");
                        int age = Integer.parseInt(scanner.nextLine());
                        Teacher teacher = new Teacher(name,age);
                        System.out.println("Input discipline name: ");
                        String disciplineName = scanner.nextLine();
                        Discipline discipline = new Discipline(disciplineName,teacher);
                        this.controller.removeDiscipline(discipline);
                        break;
                    }
                    case "2" : {
                        System.out.println("Note: use no.5 function to make sure what you are deleting ;)");
                        System.out.println("Input position: ");
                        int pos = Integer.parseInt(scanner.nextLine());
                        this.controller.removeDisciplineFromPosition(pos);
                    }
                }
                break;
            }
            case "7" : {
                this.controller.sortByFirstName();
                break;
            }
            default:
            {
                System.out.println("Please input a valid number!(a number between 1 and 10, to close the app please input 0)");
                break;
            }
        }
    }

}
