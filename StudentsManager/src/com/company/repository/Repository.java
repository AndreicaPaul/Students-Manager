package com.company.repository;

import com.company.model.Discipline;
import com.company.model.Grade;
import com.company.model.Student;
import com.company.model.Teacher;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.util.Objects;

/**
 * Created by itbrainiacs1 on 12/23/16.
 */

public class Repository {
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Discipline> disciplines = new ArrayList<>();
    private ArrayList<Grade> grades = new ArrayList<>();
    private ArrayList<Teacher> teachers = new ArrayList<>();

    public Repository (){
        //Read From File:
    }



    public ArrayList<Discipline> getDisciplines() {
        return disciplines;
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public ArrayList<Grade> getGrades() {return this.grades; }

    public void addStudent(Student student) {
        this.students.add(student);
//        this.saveObjectsInFile(this.students, "Students_list.txt");
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

    public Student getStudentFromPosition(int posStud){
        return  students.get(posStud);
    }

    public Discipline getDisciplineFromPosition(int posDisc){
        return  disciplines.get(posDisc);
    }

    public void removeGradeFromPosition (int pos){
        grades.remove(pos);
    }

    public void addTeacher (Teacher teacher){
        teachers.add(teacher);
    }

    public ArrayList<Teacher> getTeachers() {
        return this.teachers;
    }

    public void removeTeacher(int posT){
        teachers.remove(posT);
    }

    private void saveObjectsInFile(ArrayList<Object> objects, String fileName){
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(fileName, "UTF-8");
            for (Object object : objects) {
                writer.println(object.toString());
            }
            writer.close();
        } catch (Exception e) {
//            throw new Exception("Gresit");
        }

    }
}
