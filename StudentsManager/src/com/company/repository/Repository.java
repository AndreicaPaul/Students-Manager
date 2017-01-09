package com.company.repository;

import com.company.model.Student;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by itbrainiacs1 on 12/23/16.
 */
public class Repository
{
    private ArrayList<Student> students = new ArrayList<Student>();

    public void addStudent(Student student)
    {
        students.add(student);
    }

    public void showStudents()
    {
        for(Student i : students)
        {
            System.out.print(i.getFirstName() + " ");
            System.out.print(i.getLastName()+ " ");
            System.out.println(i.getAge());
        }
    }

    public void removeStudent(Student student)
    {
        students.remove(student);
    }
}
