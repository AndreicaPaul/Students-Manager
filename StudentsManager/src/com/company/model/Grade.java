package com.company.model;

/**
 * Created by itbrainiacs1 on 1/13/17.
 */
public class Grade {
    private int value;
    private Discipline discipline;
    private Student student;

    public Grade(int value, Discipline discipline, Student student) {
        this.value = value;
        this.discipline = discipline;
        this.student = student;
    }

    public Student getStudent() {
        return student;
    }

    public Discipline getDiscipline() {

        return discipline;
    }

    public int getValue() {

        return value;
    }
}
