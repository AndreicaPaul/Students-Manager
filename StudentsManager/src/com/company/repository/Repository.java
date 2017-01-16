package com.company.repository;

import com.company.model.Discipline;
import com.company.model.Grade;
import com.company.model.Student;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by itbrainiacs1 on 12/23/16.
 */

public class Repository {
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Discipline> disciplines = new ArrayList<>();
    private  ArrayList<Grade> grades = new ArrayList<>();

    public Repository() {

    }

    public ArrayList<Discipline> getDisciplines() {
        return disciplines;
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public void addStudent(Student student){
        students.add(student);
    }

    public void removeStudent(Student student)
    {
        students.remove(student);
    }

    public void addDiscipline(Discipline discipline){
        disciplines.add(discipline);
    }

    public void removeDiscipline(Discipline discipline){
        disciplines.remove(discipline);
    }

    public void sortByFirstName(){
        Collections.sort(students, Student.StuNameComparator);
    }

    public void removeStudentFromPosition (int pos){
        students.remove(pos);
    }

    public void removeDisciplineFromPosition (int pos){
        disciplines.remove(pos);
    }

    public void giveGrade (Grade grade){
        grades.add(grade);
    }
}
