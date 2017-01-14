package com.company.repository;

import com.company.model.Discipline;
import com.company.model.Student;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by itbrainiacs1 on 12/23/16.
 */

public class Repository {
    private ArrayList<Student> students = new ArrayList<Student>();
    private ArrayList<Discipline> disciplines = new ArrayList<>();


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

}
