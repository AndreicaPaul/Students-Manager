package com.company.controller;

import com.company.model.Student;
import com.company.repository.Repository;

import java.util.ArrayList;

/**
 * Created by itbrainiacs1 on 12/23/16.
 */
public class Controller
{
    private Repository repository;

    public Controller(Repository repository) {
        this.repository = repository;
    }

    public void addStudent(Student student) {
        this.repository.addStudent(student);
    }

    public void removeStdudent (Student student) {
        this.repository.removeStudent(student);
}

    public ArrayList<Student> getAllStudents(){
        return this.repository.getStudents();
    }
}
