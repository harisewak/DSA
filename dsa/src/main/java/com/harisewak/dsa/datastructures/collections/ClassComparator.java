package com.harisewak.dsa.datastructures.collections;

import java.util.Comparator;

public class ClassComparator implements Comparator<Student> {
    @Override
    public int compare(Student student, Student t1) {
        return student.getStandard() - t1.getStandard();
    }
}
