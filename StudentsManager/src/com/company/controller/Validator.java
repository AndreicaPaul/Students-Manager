package com.company.controller;
import com.company.model.Discipline;
import com.company.model.StringContainsNumbersException;
import com.company.model.Student;
import com.company.model.Teacher;
public class Validator {
    public static void validateStudent(Student student) throws StringContainsNumbersException, NumberFormatException {
        if (student.getFirstName().matches(".*\\d+.*")) {
            throw new StringContainsNumbersException("Invalid first name.");
        }
        if (student.getLastName().matches(".*\\d+.*")) {
            throw new StringContainsNumbersException("Invalid last name.");
        }
        if (student.getAge() <= 7){
            throw new NumberFormatException("Invalid age.");
        }
    }
    public static void validateDiscipline (Discipline discipline) throws StringContainsNumbersException{
        if (discipline.getName().matches(".*\\d+.*")) {
            throw new StringContainsNumbersException("Invalid discipline name.");
        }
    }
    public static void validateTeacher(Teacher teacher) throws StringContainsNumbersException, NumberFormatException{
        if(teacher.getAge() < 18){
            throw new NumberFormatException("Invalid age.");
        }
        if(teacher.getName().matches(".*\\d+.*"));{
            throw new StringContainsNumbersException("Invalid name.");
        }

    }
}
