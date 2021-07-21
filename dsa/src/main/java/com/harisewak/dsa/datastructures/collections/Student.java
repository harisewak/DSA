package com.harisewak.dsa.datastructures.collections;

import org.jetbrains.annotations.NotNull;

public class Student implements Comparable<Student> {
    private String name;
    private int age;
    private int standard;
    private float height;

    public Student(String name, int age, int standard, float height) {
        this.name = name;
        this.age = age;
        this.standard = standard;
        this.height = height;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getStandard() {
        return standard;
    }

    public float getHeight() {
        return height;
    }

    @Override
    public int compareTo(@NotNull Student student) {
        return this.name.compareTo(student.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", standard=" + standard +
                ", height=" + height +
                '}';
    }
}
