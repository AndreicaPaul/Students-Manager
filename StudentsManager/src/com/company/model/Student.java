package com.company.model;

import java.util.Comparator;

/**
 * Created by itbrainiacs1 on 12/23/16.
 */
public class Student {
    private String firstName;
    private String lastName;
    private int age;

    public Student(String firstName, String lastName, int age)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

<<<<<<< HEAD
    public int getAge() { return age; }
=======
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return this.firstName + " " + this.lastName + " " + this.getAge() + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        if (firstName != null ? !firstName.equals(student.firstName) : student.firstName != null) return false;
        return lastName != null ? lastName.equals(student.lastName) : student.lastName == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + age;
        return result;
    }

//    @Override
//    public int compare(Student s1, Student s2) {
//        if(s1.getFirstName().equals(s2.getFirstName()) &&
//                s1.getLastName().equals(s2.getLastName()) &&
//                s1.getAge() == s2.getAge()) {
//            return 0;
//        }
//        else if(s1.getAge() < s2.getAge()){
//            return 1;
//        }
//        else
//            return -1;
//
//    }
>>>>>>> origin/master
}
