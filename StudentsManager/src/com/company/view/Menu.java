package com.company.view;
import com.company.controller.Controller;
import com.company.model.*;
import java.util.Scanner;
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

    private String reader() {
        String name = null;
        try {
            name = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("An error occurred!");
        }
        return name;
    }

    private boolean exceptionThrower(String name){
        try {
            if (name.matches(".*\\d+.*")) {
                throw new StringContainsNumbersException();
            }
        } catch (StringContainsNumbersException e){
            return true;
            }
        return false;
    }

    private int positionInput(){
        System.out.println("Input position: ");
        int pos = 0;
        try {
            pos = Integer.parseInt(reader());
        } catch (NumberFormatException e) {
            System.out.println("Please input a number! Nothing changed.");
            return -1;
        }
        return pos;
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
                String firstName = reader();
                if (exceptionThrower(firstName)){
                    System.out.println("You have a number in the name! Name not saved.");
                    break;
                }
                System.out.println("Input Last Name: ");
                String lastName = reader();
                if(exceptionThrower(lastName)){
                    System.out.println("You have a number in the name! Name not saved.");
                    break;
                }
                System.out.println("Input Age: ");
                int age = 0;
                try {
                    age = Integer.parseInt(reader());
                } catch (NumberFormatException e) {
                    System.out.println("Please input a number! Nothing saved.");
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
                try {
                    this.controller.removeStudentFormPosition(positionInput());
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
                String disciplineName = reader();
                if(exceptionThrower(disciplineName)){
                    System.out.println("You have a number in the name! Name not saved.");
                    break;
                }
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
                try {
                    this.controller.removeDisciplineFromPosition(positionInput());
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
                int posDisc = positionInput();
                if(posDisc == -1){
                    break;
                }
                for(Student student : this.controller.getAllStudents()) {
                    System.out.println(student.toString());
                }
                int posStud = positionInput();
                if(posStud == -1){
                    break;
                }
                System.out.println("Please input grade's value: ");
                int gradeValue = 0;
                try {
                    gradeValue = Integer.parseInt(reader());
                } catch (NumberFormatException e) {
                    System.out.println("Please input a number! Nothing changed.");
                    break;
                }
                Grade grade = null;
                try {
                    grade = new Grade(gradeValue, this.controller.getDisciplineFromPosition(posDisc), this.controller.getStudentFromPosition(posStud));
                } catch (Exception e) {
                    System.out.println("Big error here, please reinput data!");
                    break;
                }
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
                try {
                    this.controller.removeGradeFromPosition(positionInput());
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
                String name = reader();
                if(exceptionThrower(name)){
                    System.out.println("You have a number in your name! Nothing saved.");
                    break;
                }
                System.out.println("Please Input Teacher Age: ");
                int age = 0;
                try {
                    age = Integer.parseInt(reader());
                } catch (NumberFormatException e) {
                    System.out.println("Please input a number! Nothing saved.");
                    break;
                }
                System.out.println("Please Input Teacher Discipline: ");
                String disciplineName = reader();
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
                try {
                    this.controller.removeTeacher(positionInput());
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