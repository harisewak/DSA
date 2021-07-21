package com.harisewak.dsa.datastructures.collections;

import java.util.Comparator;

public class AgeComparator implements Comparator<Student> {
    @Override
    public int compare(Student student, Student t1) {
        return student.getAge() - t1.getAge();
    }
}
