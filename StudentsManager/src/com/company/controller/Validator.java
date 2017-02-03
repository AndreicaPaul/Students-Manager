package com.company.controller;

import com.company.model.StringContainsNumbersException;
import com.company.model.Student;

/**
 * Created by itbrainiacs1 on 2/3/17.
 */
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
}
