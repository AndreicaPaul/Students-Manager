package com.company.repository;

import com.company.model.Student;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

/**
 * Created by itbrainiacs1 on 12/23/16.
 */
<<<<<<< HEAD
public class Repository
{
    public ArrayList<Student> students = new ArrayList<Student>();

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
=======
public class Repository {
    private ArrayList<Student> students = new ArrayList<Student>();



    public Repository() {

    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public void addStudent(Student student){
        students.add(student);
    }
    public void removeStudent(Student student){
        students.remove(student);
>>>>>>> origin/master
    }

    public void removeStudent(Student student)
    {
        int j = 0;
        for (Student i : students)
        {
            System.out.println(i.getFirstName());
            System.out.println(student.getFirstName());
            if(i.equals(student))
            {
                System.out.println("da");
                students.remove(j);
            }
            j++;
        }
    }
}
