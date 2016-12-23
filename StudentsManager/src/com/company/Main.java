package com.company;

import com.company.controller.Controller;
import com.company.repository.Repository;
import com.company.view.Menu;

import java.util.Scanner;

public class Main {

    public static void cases (String userInput,String studentsData[][],int lastStudentIndex,int lastDisciplineIndex) {
        Scanner scanner = new Scanner(System.in);

        switch (userInput) {
            case "1": {
                System.out.println("Please input first name: ");
                userInput = scanner.nextLine();
                studentsData[lastStudentIndex][0] = userInput;
                System.out.println("Please input last name: ");
                userInput = scanner.nextLine();
                studentsData[lastStudentIndex][1] = userInput;
                break;
            }
            case "2": {
                int i,j;
                for(i = 1; i < lastStudentIndex; i++) {
                    for (j = 0; j <= 1; j++) {
                        System.out.print(studentsData[i][j]);
                        System.out.print(" ");
                    }
                    System.out.println();
                }
                break;
            }
            case "3": {
                System.out.println("Please input students name: ");
                userInput = scanner.nextLine();
                for (int i = 1; i < lastStudentIndex; i++){
                   if(studentsData[i][0].contains(userInput)){
                       for(int j = i; j < lastStudentIndex-1; j++){
                           studentsData[j][0] = studentsData[j+1][0];
                           studentsData[j][1] = studentsData[j+1][1];
                       }
                       break;
                    }
                }
                break;
            }
            case "4": {
                System.out.println("Insert Discipline: ");
                userInput = scanner.nextLine();
                studentsData[0][lastDisciplineIndex] = userInput;
                break;
            }
            case "5": {
                int j;
                for(j = 2; j < lastDisciplineIndex; j++) {
                    System.out.println(studentsData[0][j]);
                }
                break;
            }
            case "6": {
                System.out.println("Please input the name of the discipline: ");
                userInput = scanner.nextLine();
                for(int i = 2; i < lastDisciplineIndex; i++){
                    if(studentsData[0][i].contains(userInput)){
                        for(int j = i; j < lastDisciplineIndex-1; j++)
                            studentsData[0][j] = studentsData[0][j+1];
                        break;
                    }
                }
                break;
            }
            default: {
                //Ask for valid input from user
                System.out.println("Please Provide a valid input (numbers from 1 to 8), if you want to exit input 0.");
                break;
            }
        }
    }
    public static void main(String[] args) {
        /* /declarations */
        String userInput = "1";

        Repository repository = new Repository();
        Controller controller = new Controller(repository);
        Menu menu = new Menu(controller);
        menu.run();


//        Scanner scanner = new Scanner(System.in);
//        String studentsData[][] = new String[28][20];
//        int getData = 1;
//        int lastStudentIndex = 1;
//        int lastDisciplineIndex = 2;
//        /* /declarations */
//
//        while (getData != 0) {
//            System.out.println("What do you want to do next?");
//            menu.showMenu();
//            userInput = scanner.nextLine();
//            Main.cases(userInput, studentsData,lastStudentIndex,lastDisciplineIndex);
//            getData = Integer.parseInt(userInput);
//            switch (getData){
//                case 1: {
//                    lastStudentIndex++;
//                    break;
//                }
//                case 3: {
//                    lastStudentIndex--;
//                    break;
//                }
//                case 4: {
//                    lastDisciplineIndex++;
//                    break;
//                }
//                case 6: {
//                    lastDisciplineIndex--;
//                    break;
//                }
//                default: {
//                    break;
//                }
//            }
//        }
    }
}
