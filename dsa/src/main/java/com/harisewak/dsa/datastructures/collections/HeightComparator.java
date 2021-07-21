package com.harisewak.dsa.datastructures.collections;

import java.util.Comparator;

public class HeightComparator implements Comparator<Student> {
    @Override
    public int compare(Student student, Student otherStudent) {
        return Float.compare(student.getHeight(), otherStudent.getHeight());
    }

}
