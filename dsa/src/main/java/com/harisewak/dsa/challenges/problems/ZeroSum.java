package com.harisewak.dsa.challenges.problems;

import java.util.HashMap;
import java.util.Map;

public class ZeroSum {

    /*
    array of +ve and -ve integers
    find subarray (min 1 element) with sum = 0

    Input: 4 2 -3 1 6
    Output: true

    either sums repeat OR sum is 0

    -1 -1 0
    -1
    -2
    -2

    sum = 0
    for arr 0 to n:
        sum = sum + arr[i]
        if (sum == 0):
            return true
        if (sum in map):
            return true
        else:
            store sum in map
     */

    static boolean findsum(int arr[],int n)
    {
        Map<Integer, Integer> map = new HashMap<>();

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (sum == 0) return true;
            if (map.containsKey(sum)) return true;
            map.put(sum, 0);
        }

        return false;
    }

}
