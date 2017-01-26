package com.company.view;

import com.company.controller.Controller;
import com.company.model.*;

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
        System.out.println("6. Remove Discipline");
        System.out.println("7. Give a Student a Grade");
        System.out.println("8. View all Grades");
        System.out.println("9. Remove Grade");
        System.out.println("10. Add Teacher");
        System.out.println("11. View Teachers");
        System.out.println("12. Remove Teacher");
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
                String firstName = null;
                try {
                    firstName = scanner.nextLine();
                    if(firstName.matches(".*\\d+.*")){
                        throw new StringContainsNumbersException();
                    }
                } catch (StringContainsNumbersException e) {
                    System.out.println("Warning you have a number in the name! Suggestion: delete and reenter the name.");
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Input Last Name: ");
                String lastName = null;
                try {
                    lastName = scanner.nextLine();
                    if(lastName.matches(".*\\d+.*")){
                        throw  new StringContainsNumbersException();
                    }
                } catch (StringContainsNumbersException e) {
                    System.out.println("Warning you have a number in the name! Suggestion: delete and reenter the name.");
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Input Age: ");
                int age = 0;
                try {
                    age = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Error, please input a number! This student won't be saved.");
                    break;
                }
                Student student = new Student(firstName,lastName,age);
                this.controller.addStudent(student);
                break;

            }
            case "2" : {
                this.controller.sortByFirstName();
                for(Student student : this.controller.getAllStudents()) {
                    System.out.println(student.toString());
                }
                break;
            }
            case "3" : {
                this.controller.sortByFirstName();
                for(Student student : this.controller.getAllStudents()) {
                    System.out.println(student.toString());
                }
                System.out.println("Input position: ");
                int pos = 0;
                try {
                    pos = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Error, please input a number! Nothing erased.");
                    break;
                }
                this.controller.removeStudentFormPosition(pos);
                break;
            }
            case "4" : {
                System.out.println("Input discipline name: ");
                String disciplineName = null;
                try {
                    disciplineName = scanner.nextLine();
                    if(disciplineName.matches(".*\\d+.*")){
                        throw new StringContainsNumbersException();
                    }
                } catch (StringContainsNumbersException e) {
                    System.out.println("Warning you have a number in the name! Suggestion: delete and reenter the name.");
                }
                Discipline discipline = new Discipline(disciplineName);
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
                for (Discipline discipline : this.controller.getAllDisciplines()){
                    System.out.println(discipline.toString());
                }
                System.out.println("Input position: ");
                int pos = 0;
                try {
                    pos = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Error, please input a number! Nothing erased.");
                    break;
                }
                this.controller.removeDisciplineFromPosition(pos);
                break;
            }
            case "7" : {
                for (Discipline discipline : this.controller.getAllDisciplines()){
                    System.out.println(discipline.toString());
                }
                System.out.println("Please input discipline's position: ");
                int posDisc = 0;
                try {
                    posDisc = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Error, please input a number! The app will reset now.");
                    break;
                }
                for(Student student : this.controller.getAllStudents()) {
                    System.out.println(student.toString());
                }
                System.out.println("Please input student's position: ");
                int posStud = 0;
                try {
                    posStud = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Error, please input a number! The app will reset now.");
                    break;
                }
                System.out.println("Please input grade's value: ");
                int gradeValue = 0;
                try {
                    gradeValue = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Error, please input a number! The app will reset now.");
                    break;
                }
                Grade grade = new Grade(gradeValue, this.controller.getDisciplineFromPosition(posDisc), this.controller.getStudentFromPosition(posStud));
                this.controller.giveGrade(grade);
                break;
            }
            case "8" : {
                for(Grade grade : this.controller.getAllGrades()){
                    System.out.println(grade.toString());
                }
                break;
            }
            case "9" : {
                for(Grade grade : this.controller.getAllGrades()){
                    System.out.println(grade.toString());
                }
                System.out.println("Please input the grade's position");
                int pos = 0;
                try {
                    pos = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Error, please input a number! Nothing erased.");
                    break;
                }
                this.controller.removeGradeFromPosition(pos);
                break;
            }
            case "10" : {
                System.out.println("Please Input Teacher Name: ");
                String name = null;
                try {
                    name = scanner.nextLine();
                    if(name.matches(".*\\d+.*")){
                        throw new StringContainsNumbersException();
                    }
                } catch (StringContainsNumbersException e) {
                    System.out.println("Warning you have a number in the name! Suggestion: delete and reenter the name.");
                }
                System.out.println("Please Input Teacher Age: ");
                int age = 0;
                try {
                    age = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Error, please input a number! App will reset now.");
                    break;
                }
                System.out.println("Please Input Teacher Discipline: ");
                String disciplineName = null;
                try {
                    disciplineName = scanner.nextLine();
                    if(disciplineName.matches(".*\\d+.*")){
                        throw new StringContainsNumbersException();
                    }
                } catch (StringContainsNumbersException e) {
                    System.out.println("Warning you have a number in the name! Suggestion: delete and reenter the name.");
                }
                Discipline discipline = new Discipline(disciplineName);
                Teacher teacher = new Teacher(name,age,discipline);
                this.controller.addTeacher(teacher);
                break;
            }
            case "11" : {
                for (Teacher teacher : this.controller.getTeachers()){
                    System.out.println(teacher.toString());
                }
                break;
            }
            case "12" : {
                for (Teacher teacher : this.controller.getTeachers()){
                    System.out.println(teacher.toString());
                }
                System.out.println("Please Input Teacher's postion: ");
                int posT = 0;
                try {
                    posT = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Error, please input a number! Nothing erased.");
                    break;
                }
                this.controller.removeTeacher(posT);
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
