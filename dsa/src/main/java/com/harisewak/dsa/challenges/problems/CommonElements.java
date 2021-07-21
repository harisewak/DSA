package com.harisewak.dsa.challenges.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class CommonElements {


    /*
    1. Store all elements of first array in hashmap
    2. Compare each element of second array with hashmap, if a value is not found, delete it
    3. Follow the same process for third array
    */

    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) {

        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < A.length; i++) {
            int value = 1;
            map.put(A[i], value);
            System.out.println("A -> key: " + A[i] + ", value: " + value);
        }

        for (int i = 0; i < B.length; i++) {
            if (map.containsKey(B[i])) {
                int value = map.get(B[i]) + 1;
                if (value > 2) {
                    value = 2;
                }
                map.put(B[i], value);
                System.out.println("B -> key: " + B[i] + ", value: " + value);
            }
        }

        Iterator<Integer> iterator1 = map.keySet().iterator();

        while (iterator1.hasNext()) {
            Integer next = iterator1.next();
            if (map.get(next) < 2) {
                map.put(next, -1);
            }
            System.out.println("removing..");
        }

        for (int i = 0; i < C.length; i++) {
            if (map.containsKey(C[i]) && map.get(C[i]) != -1) {
                int value = map.get(C[i]) + 1;
                if (value > 3) {
                    value = 3;
                }
                map.put(C[i], value);
                System.out.println("C -> key: " + C[i] + ", value: " + value);
            }
        }

        Iterator<Map.Entry<Integer, Integer>> iterator = map.entrySet().iterator();

        ArrayList<Integer> result = new ArrayList<>();

        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            if (next.getValue() > 2) {
                result.add(next.getKey());
            }
        }

        return result;
    }

}
