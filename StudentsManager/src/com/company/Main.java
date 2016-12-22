package com.company;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.Console;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void cases (String userInput,String studentsNames[][],int lastStudentIdex) {
        Scanner scanner = new Scanner(System.in);
        switch (userInput) {
            case "1": {
                System.out.println("Please input first name: ");
                userInput = scanner.nextLine();
                studentsNames[lastStudentIdex][0] = userInput;
                System.out.println("Please input last name: ");
                userInput = scanner.nextLine();
                studentsNames[lastStudentIdex][1] = userInput;
                break;
            }
            case "2": {
                int i,j;
                for(i = 0; i < lastStudentIdex; i++) {
                    for (j = 0; j <= 1; j++) {
                        System.out.print(studentsNames[i][j]);
                        System.out.print(" ");
                    }
                    System.out.println();
                }
                break;
            }
            case "3": {
                System.out.println("Please input students name: ");
                userInput = scanner.nextLine();
                for (int i = 0; i < lastStudentIdex; i++){
                   if(studentsNames[i][0].contains(userInput)){
                       studentsNames[i][0] = null;
                       for(int j = i; j < lastStudentIdex-1; j++){
                           studentsNames[j][0] = studentsNames[j+1][0];
                           studentsNames[j][1] = studentsNames[j+1][1];
                       }
                       break;
                    }
                }
                break;
            }
            case "4": {

            }
            default: {
                //Ask for valid input from user
                System.out.println("Please Provide a valid input.(numbers from 1 to 8)");
                break;
            }
        }
    }
    public static void main(String[] args) {


        String userInput = "1";
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        String studentsNames[][] = new String[28][20];
        int getData = 1;
        int lastStudentIndex = 0;
        while (getData > 0 && getData < 9) {
            System.out.println("What do you want to do next?");
            menu.showMenu();
            userInput = scanner.nextLine();
            Main.cases(userInput, studentsNames,lastStudentIndex);
            getData = Integer.parseInt(userInput);
            switch (getData){
                case 1: {
                    lastStudentIndex++;
                    break;
                }
                case 3: {
                    lastStudentIndex--;
                    break;
                }
                default: {
                    break;
                }
            }
        }
    }
}
