package com.harisewak.dsa.challenges.problems;

import java.util.HashMap;
import java.util.Map;

public class SumPairs {

    public static void main(String[] args) {
        SumPairs sumPairs = new SumPairs();
        int result = sumPairs.getPairsCount(new int[]{1,1,2,3,4,5,6}, 5, 2);
        System.out.println("result: "+result);
    }

//    store distinct values as keys and their count as value in a map
//    check for its complementary, if found add number of occurrences to count variable
//    skip own check
//    divide count by 2 and return the result

    int getPairsCount(int[] arr, int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 0);
            }

            int value = map.get(arr[i]) + 1;
            map.put(arr[i], value);

            System.out.println("key: "+arr[i]+", value: "+value);
        }

        int count = 0;

        System.out.println("count: "+count);

        for (int i = 0; i < arr.length; i++) {
            if (map.get(k - arr[i]) != null) {
                count += map.get(k - arr[i]);
                System.out.println("count: "+count);
            }
            if (k - arr[i] == arr[i]) {
                System.out.println("complementary equals current");
                count--;
                System.out.println("count: "+count);
            }
        }

        return count/2;
    }

}
