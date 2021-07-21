package com.harisewak.dsa.challenges.problems;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class LongestSubSequence {

    int[][] test_arrs = new int[][]{
            new int[]{192, 48, 148, 84, 129, 1, 71, 186, 172, 3, 165, 141, 196, 53, 85, 49, 74, 0, 72, 188, 164, 45},
            new int[]{61, 130},
            new int[]{1,2,3,4,5},
            new int[]{2, 6, 1, 9, 4, 5, 3},
            new int[]{1, 9, 3, 10, 4, 20, 2},
            new int[]{50, 75, 20, 32, 21, 55, 22, 70, 80, 23},
            new int[]{10, 100, 50, 2, 1, 7, 6, 20, 4, 300, 5, 90, 3}
    };

    int[] targets = new int[]{
            2,
            1,
            5,
            6,
            4,
            4,
            7
    };

    /*
    iterate through the array while storing each element in a sorted set
    iterate through the sorted set keeping a count when the current value == next value + 1
    * */

    public int findLongestConseqSubseq(int arr[], int N) {
        Set<Integer> sortedValues = new TreeSet<>();

        for (int i = 0; i < arr.length; i++) {
            sortedValues.add(arr[i]);
//            System.out.println("adding.. " + arr[i]);
        }

        Iterator<Integer> iterator = sortedValues.iterator();

        int count = 0;
        int longestCount = 1;
        int previous = Integer.MIN_VALUE;

        while (iterator.hasNext()) {

            Integer current = iterator.next();
//            System.out.println("previous: " + previous + ", current: " + current);

            if (current == previous + 1) {
                // first time, increments twice e.g. (1 == 2) is two consecutive integers
                if (count == 0) {
                    count++;
//                    System.out.println("count: "+count);
                }
                count++;
//                System.out.println("count: "+count);

            } else {

                if (count > longestCount) {
                    longestCount = count;
                }

               count = 0;
            }

            previous = current;
        }

        if (count > longestCount) {
            longestCount = count;
        }

        return longestCount;
    }

    public void test() {
        int failed = 0;

        for (int i = 0; i < test_arrs.length; i++) {
            int[] test_arr = test_arrs[i];
            long product = findLongestConseqSubseq(test_arr, 0);
            if (targets[i] != product) {
                System.out.println("test failed");
                System.out.println("array: " + Arrays.toString(test_arr));
                System.out.println("expected: " + targets[i] + ", found: " + product);
                failed++;
            }
        }

        if (failed > 0) {
            System.out.println(failed + " out of " + test_arrs.length + " tests failed");
        } else {
            System.out.println("Hurray! All tests passed!");
        }
    }

    public void testFirstCase() {
        int result = findLongestConseqSubseq(test_arrs[0], 0);
        System.out.println("array: " + Arrays.toString(test_arrs[0]));
        System.out.println("expected: " + targets[0] + ", found: " + result);
    }

}
