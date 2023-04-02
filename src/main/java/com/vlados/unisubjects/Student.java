package com.vlados.unisubjects;

import java.util.HashMap;
import java.util.Map;

public class Student {

    private static final Student studentInstance = new Student();

    private String name;

    private int age;

    private int course;

    private double averageGrade;

    public static Student getStudent() {
        return studentInstance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCourse() {
        return course;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public double getAverageGrade() {
        return averageGrade;
    }

    public void setAverageGrade(double averageGrade) {
        this.averageGrade = averageGrade;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", age: " + age + ", course: " + course + ", average grade: " + averageGrade;
    }
}
