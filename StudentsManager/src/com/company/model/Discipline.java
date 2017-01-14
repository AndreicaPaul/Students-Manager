package com.company.model;

import java.util.ArrayList;

public class Discipline {
    private String name;
    private Teacher teacher;

    public Discipline(String name, Teacher teacher){
        this.name = name;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    @Override
    public String toString() {
        return "Teacher name: "+this.getTeacher() + "\n" + "Discipline name: " + this.getName() + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Discipline that = (Discipline) o;

        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return teacher != null ? teacher.equals(that.teacher) : that.teacher == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (teacher != null ? teacher.hashCode() : 0);
        return result;
    }
}
