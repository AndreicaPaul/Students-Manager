package com.company.repository;
import com.company.model.*;
import java.util.ArrayList;
import java.util.Collections;
import java.io.PrintWriter;

public class Repository {

    //declarations---------------------------------------------------------------------------------------------
    private ArrayList<Student> students = new ArrayList<>();
    private ArrayList<Discipline> disciplines = new ArrayList<>();
    private ArrayList<Grade> grades = new ArrayList<>();
    private ArrayList<Teacher> teachers = new ArrayList<>();
    //---------------------------------------------------------------------------------------------------------

    public Repository (){
    }

    //General writer
    private void saveObjectsInFile(ArrayList<? extends Object> mySuperclassArrayList, String fileName) throws Exception {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(fileName, "UTF-8");
            for (Object mySuperclass : mySuperclassArrayList) {
                writer.println(mySuperclass.toString());
            }
            writer.close();
        } catch (Exception e) {
            throw new Exception("Gresit");
        }

    }

    public void addStudent(Student student) {
        this.students.add(student);
        try {
            this.saveObjectsInFile(this.students, "Students_list.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addDiscipline(Discipline discipline){
        disciplines.add(discipline);
        try {
            this.saveObjectsInFile(this.disciplines, "Disciplines_list.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void giveGrade (Grade grade){
        grades.add(grade);
        try {
            this.saveObjectsInFile(this.grades, "Grades_list.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addTeacher (Teacher teacher){
        teachers.add(teacher);
        try {
            this.saveObjectsInFile(this.teachers, "Teachers_list.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Discipline> getDisciplines() {
        return disciplines;
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public ArrayList<Grade> getGrades() {return this.grades; }

    public ArrayList<Teacher> getTeachers() {
        return this.teachers;
    }

    public Student getStudentFromPosition(int posStud){
        return  students.get(posStud);
    }

    public Discipline getDisciplineFromPosition(int posDisc){
        return  disciplines.get(posDisc);
    }

    public void removeStudent(Student student)
    {
        students.remove(student);
    }

    public void removeDiscipline(Discipline discipline){
        disciplines.remove(discipline);
    }

    public void removeStudentFromPosition (int pos){
        students.remove(pos);
    }

    public void removeDisciplineFromPosition (int pos){
        disciplines.remove(pos);
    }

    public void removeGradeFromPosition (int pos){
        grades.remove(pos);
    }

    public void removeTeacher(int posT){
        teachers.remove(posT);
    }

    public void sortByFirstName(){
        try {
            Collections.sort(students, Student.StuNameComparator);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
