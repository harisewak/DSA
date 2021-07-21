package com.harisewak.dsa.challenges;


import com.harisewak.dsa.challenges.problems.ComplementaryBrackets;
import com.harisewak.dsa.challenges.problems.IsTimeLessThan12AndInTargetKt;
import com.harisewak.dsa.challenges.problems.RemoveDuplicates;
import com.harisewak.dsa.challenges.problems.RotateArray;
import com.harisewak.dsa.challenges.problems.TripletSum;
import com.harisewak.dsa.datastructures.implementation.DoublyLinkedList;
import com.harisewak.dsa.datastructures.implementation.Queue;
import com.harisewak.dsa.datastructures.implementation.Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DriverCode {

    public static void main(String[] args) {
        int[] arr = new int[]{5, 2, 2, 3, 2, 5};
        int numOfTimes = findCount(arr);
    }

    private static int findCount(int[] arr) {
        // store count in a hashmap
        // iterate through hashmap to find number with max count
        Map<Integer, Integer> hashMap = new HashMap<>();

        int maxCount = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            Integer key = arr[i];

            if (!hashMap.containsKey(key)) {
                hashMap.put(key, 1);
            } else {
                Integer count = hashMap.get(key);
                int updatedCount = count + 1;

                if (updatedCount > maxCount) {
                    maxCount = updatedCount;
                }

                hashMap.put(key, updatedCount);
            }
        }



        for (Integer key : hashMap.keySet()) {

        }
    }
}

