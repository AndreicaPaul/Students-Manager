package com.company.model;

/**
 * Created by itbrainiacs1 on 1/13/17.
 */
public class Teacher {
    private String name;
    private int age;

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    @Override
    public String toString() {
        return this.getName()+ "\n" + "Theacher age: " + this.getAge();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (age != teacher.age) return false;
        return name != null ? name.equals(teacher.name) : teacher.name == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + age;
        return result;
    }
}
