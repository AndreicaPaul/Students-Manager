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

    private String getUserInput(String inputMessage) {
        System.out.println(inputMessage);
        String name = null;
        try {
            name = scanner.nextLine();
        } catch (Exception e) {
            System.out.println("An error occurred!");
        }
        return name;
    }

    private boolean throwException(String name){
        try {
            if (name.matches(".*\\d+.*")) {
                throw new StringContainsNumbersException();
            }
        } catch (StringContainsNumbersException e){
            return true;
            }
        return false;
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
                String firstName = getUserInput("Input first name: ");
                String lastName = getUserInput("Input last name: ");
                try {
                    int age = Integer.parseInt(getUserInput("Input age: "));
                    Student student = new Student(firstName,lastName,age);
                    this.controller.addStudent(student);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number! Nothing saved.");
                } catch (StringContainsNumbersException e) {
                    System.out.println(e.getMessage());
                }
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
                    this.controller.removeStudentFormPosition(Integer.parseInt(getUserInput("Input position.")));
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Index out of bounds, please recheck the number of students!");
                } catch (Exception e) {
                    System.out.println("We didn't saw that coming! :)");
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
                String disciplineName = getUserInput("Input discipline name: ");
                if(throwException(disciplineName)){
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
                    this.controller.removeDisciplineFromPosition(Integer.parseInt(getUserInput("Input position: ")));
                } catch (IndexOutOfBoundsException e){
                    System.out.println("Index out of bounds.");
                } catch (Exception e) {
                    System.out.println("We didn't saw that coming! :)");
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
                int posDisc = Integer.parseInt(getUserInput("Input discipline position: "));
                for(Student student : this.controller.getAllStudents()) {
                    System.out.println(student.toString());
                }
                int posStud = Integer.parseInt(getUserInput("Input student position: "));
                System.out.println("Please input grade's value: ");
                int gradeValue = 0;
                try {
                    gradeValue = Integer.parseInt(getUserInput("Input grade value: "));
                } catch (NumberFormatException e) {
                    System.out.println("Please input a number! Nothing changed.");
                    break;
                }
                Grade grade = null;
                try {
                    grade = new Grade(gradeValue, this.controller.getDisciplineFromPosition(posDisc), this.controller.getStudentFromPosition(posStud));
                } catch (Exception e) {
                    System.out.println("Big error here, please reenter data!");
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
                    this.controller.removeGradeFromPosition(Integer.parseInt(getUserInput("Input position: ")));
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
                String name = getUserInput("Please Input Teacher Name: ");
                if(throwException(name)){
                    System.out.println("You have a number in your name! Nothing saved.");
                    break;
                }
                System.out.println();
                int age = 0;
                try {
                    age = Integer.parseInt(getUserInput("Please Input Teacher Age: "));
                } catch (NumberFormatException e) {
                    System.out.println("Please input a number! Nothing saved.");
                    break;
                }
                String disciplineName = getUserInput("Please Input Teacher Discipline: ");
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
                    this.controller.removeTeacher(Integer.parseInt(getUserInput("Input position")));
                } catch (Exception e) {
                    if(e instanceof IndexOutOfBoundsException)
                        System.out.println("Index out of bounds, please recheck the number of teachers!");              ///modificari!
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