package com.company.view;

import com.company.controller.Controller;
import com.company.model.*;
import java.util.Scanner;

/**
 * Created by itbrainiacs1 on 12/14/16.
 */
public class Menu
{
    private Controller controller;
    private Scanner scanner = new Scanner(System.in);
    public Menu(Controller controller){
        this.controller = controller;
    }

    public void run(){
        while(true)
        {
            this.showMenu();
        }
    }

    private String nameReader(){
        String name = null;
        try {
            name = scanner.nextLine();
            if(name.matches(".*\\d+.*")){
                throw new StringContainsNumbersException();
            }
        } catch (Exception e) {
            if(e instanceof StringContainsNumbersException){
                System.out.println("Warning you have a number in the name! Suggestion: delete and reenter the name.");
            }
            else{
                System.out.println("We didn't saw that coming! :)");
            }
        }
        return name;
    }

    private int numberReader(){
        int number = 0;
        try {
            number = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Error, please input a number! Nothing changed.");
        }
        return number;
    }

    private void showStudentSubMenus(){
        System.out.println("    1. Add Student");
        System.out.println("    2. View all Students");
        System.out.println("    3. Remove Student");
        System.out.println("    4. Return to main menu");
        String userInput = "";
        userInput = scanner.nextLine();
        switch (userInput){
            case "0":
            {
                scanner.close();
                break;
            }
            case "1":
            {
                System.out.println("Input First Name: ");
                String firstName = nameReader();
                System.out.println("Input Last Name: ");
                String lastName = nameReader();
                System.out.println("Input Age: ");
                int age = numberReader();
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
                int pos = numberReader();
                if(pos == -1){
                    break;
                }
                try {
                    this.controller.removeStudentFormPosition(pos);
                } catch (Exception e) {
                    if(e instanceof IndexOutOfBoundsException) {
                        System.out.println("Index out of bounds, please recheck the number of students!");
                    }
                    else {
                        System.out.println("We didn't saw that coming! :)");
                    }
                }
                break;
            }
            case "4" : {
                this.showMenu();
                break;
            }
            default : {
                System.out.println("Please input a valid number!(a number between 1 and 4, to close the app please input 0)");
                break;
            }
        }
    }

    private void showDisciplineSubMenus(){
        System.out.println("    1. Add Discipline");
        System.out.println("    2. View all Disciplines");
        System.out.println("    3. Remove Discipline");
        System.out.println("    4. Return to main menu");
        String userInput = "";
        userInput = scanner.nextLine();
        switch (userInput){
            case "0" : {
                scanner.close();
                break;
            }
            case "1" : {
                System.out.println("Input discipline name: ");
                String disciplineName = nameReader();
                Discipline discipline = new Discipline(disciplineName);
                this.controller.addDiscipline(discipline);
                break;
            }
            case "2" : {
                for (Discipline discipline : this.controller.getAllDisciplines()){
                    System.out.println(discipline.toString());
                }
                break;
            }
            case "3" : {
                for (Discipline discipline : this.controller.getAllDisciplines()){
                    System.out.println(discipline.toString());
                }

                System.out.println("Input position: ");
                int pos = numberReader();
                try {
                    this.controller.removeDisciplineFromPosition(pos);
                } catch (Exception e) {
                    if(e instanceof IndexOutOfBoundsException) {
                        System.out.println("Index out of bounds, please recheck the number of disciplines!");
                    }
                    else {
                        System.out.println("We didn't saw that coming! :)");
                    }
                }
                break;
            }
            case "4" : {
                this.showMenu();
                break;
            }
            default : {
                System.out.println("Please input a valid number!(a number between 1 and 4, to close the app please input 0)");
                break;
            }
        }
    }

    private void showGradeSubMenus(){
        System.out.println("    1. Give a Student a Grade");
        System.out.println("    2. View all Grades");
        System.out.println("    3. Remove Grade");
        System.out.println("    4. Return to main menu");
        String userInput = "";
        userInput = scanner.nextLine();
        switch (userInput){
            case "0" : {
                scanner.close();
                break;
            }
            case "1" : {
                for (Discipline discipline : this.controller.getAllDisciplines()){
                    System.out.println(discipline.toString());
                }
                System.out.println("Please input discipline's position: ");
                int posDisc = numberReader();
                for(Student student : this.controller.getAllStudents()) {
                    System.out.println(student.toString());
                }
                System.out.println("Please input student's position: ");
                int posStud = numberReader();
                System.out.println("Please input grade's value: ");
                int gradeValue = numberReader();
                Grade grade = new Grade(gradeValue, this.controller.getDisciplineFromPosition(posDisc), this.controller.getStudentFromPosition(posStud));
                this.controller.giveGrade(grade);
                break;
            }
            case "2" : {
                for(Grade grade : this.controller.getAllGrades()){
                    System.out.println(grade.toString());
                }
                break;
            }
            case "3" : {
                for(Grade grade : this.controller.getAllGrades()){
                    System.out.println(grade.toString());
                }

                System.out.println("Please input the grade's position");
                int pos = numberReader();
                try {
                    this.controller.removeGradeFromPosition(pos);
                } catch (Exception e) {
                    if(e instanceof IndexOutOfBoundsException) {
                        System.out.println("Index out of bounds, please recheck the number of grades!");
                    }
                    else {
                        System.out.println("We didn't saw that coming! :)");
                    }
                }
                break;
            }
            case "4" : {
                this.showMenu();
                break;
            }
            default : {
                System.out.println("Please input a valid number!(a number between 1 and 4, to close the app please input 0)");
                break;
            }
        }
    }

    private void showTeacherSubMenus(){
        System.out.println("    1. Add Teacher");
        System.out.println("    2. View Teachers");
        System.out.println("    3. Remove Teacher");
        System.out.println("    4. Return to main menu");
        String userInput = "";
        userInput = scanner.nextLine();
        switch (userInput)
        {
            case "0" : {
                scanner.close();
                break;
            }
            case "1" : {
                System.out.println("Please Input Teacher Name: ");
                String name = nameReader();
                System.out.println("Please Input Teacher Age: ");
                int age = numberReader();
                System.out.println("Please Input Teacher Discipline: ");
                String disciplineName = nameReader();
                Discipline discipline = new Discipline(disciplineName);
                Teacher teacher = new Teacher(name,age,discipline);
                this.controller.addTeacher(teacher);
                break;
            }
            case "2" : {
                for (Teacher teacher : this.controller.getTeachers()){
                    System.out.println(teacher.toString());
                }
                break;
            }
            case "3" : {
                for (Teacher teacher : this.controller.getTeachers()){
                    System.out.println(teacher.toString());
                }

                System.out.println("Please Input Teacher's postion: ");
                int pos = numberReader();
                try {
                    this.controller.removeTeacher(pos);
                } catch (Exception e) {
                    if(e instanceof IndexOutOfBoundsException)
                        System.out.println("Index out of bounds, please recheck the number of teachers!");
                    else {
                        System.out.println("We didn't saw that coming! :)");
                    }
                }
                break;
            }
            case "4" : {
                this.showMenu();
                break;
            }
            default:
            {
                System.out.println("Please input a valid number!(a number between 1 and 4, to close the app please input 0)");
                break;
            }
        }
    }

    private void showMenu(){
        System.out.println("1. Students");
        System.out.println("2. Disciplines");
        System.out.println("3. Grades");
        System.out.println("4. Teachers");
        String userInput = "";
        userInput = scanner.nextLine();
        switch (userInput)
        {
            case "0" : {
                scanner.close();
                break;
            }
            case "1" : {
                this.showStudentSubMenus();
                break;
            }
            case "2" : {
                this.showDisciplineSubMenus();
                break;
            }
            case "3" : {
                this.showGradeSubMenus();
                break;
            }
            case "4" : {
                this.showTeacherSubMenus();
                break;
            }
            default : {
                System.out.println("Please input a valid number(a number between 1 and 4, to exit input 0)");
            }

        }
    }
}