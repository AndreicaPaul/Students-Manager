package com.company.model;

import java.util.ArrayList;

/**
 * Created by Paul on 12-Jan-17.
 */
public class Discipline {
    private String name;
    private String teacherName;
    private ArrayList<Student> studentsThatAttendThisDiscipline = new ArrayList<Student>();
    private int[] studentsGrades = new int[28];

    public String getName() {
        return name;
    }

    public ArrayList<Student> getStudentsThatAttendThisDiscipline() {
        return studentsThatAttendThisDiscipline;
    }

    public String getTeacherName() {

        return teacherName;
    }

    public int[] getStudentsGrades() {
        return studentsGrades;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public void setStudentsGrades(int[] studentsGrades) {
        this.studentsGrades = studentsGrades;
    }

    public void setStudentsThatAttendThisDiscipline(ArrayList<Student> studentsThatAttendThisDiscipline) {

        this.studentsThatAttendThisDiscipline = studentsThatAttendThisDiscipline;
    }
}
