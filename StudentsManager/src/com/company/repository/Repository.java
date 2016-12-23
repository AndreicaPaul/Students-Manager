package com.company.repository;

import com.company.model.Student;

import java.util.ArrayList;

/**
 * Created by itbrainiacs1 on 12/23/16.
 */
public class Repository {
    private ArrayList<Student> students = new ArrayList<Student>();

    public Repository() {

    }

    public void addStudent(Student student){
        students.add(student);
    }


}
