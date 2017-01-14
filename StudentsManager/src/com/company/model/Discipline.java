package com.company.model;

import java.util.ArrayList;

public class Discipline {
    private String name;
    private String description;
    private Teacher teacher;

    public Discipline(String name, String description, Teacher teacher){
        this.name = name;
        this.description = description;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Teacher getTeacher() {
        return teacher;
    }
}
