package com.harisewak.dsa.challenges.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IsSubset {

    int[][] test_arrs_a1 = new int[][]{
            new int[]{11, 1, 13, 21, 3, 7},

            new int[]{1, 2, 3, 4, 5, 6},

            new int[]{10, 5, 2, 23, 19}
    };

    int[][] test_arrs_a2 = new int[][]{
            new int[]{11, 3, 7, 1},

            new int[]{1, 2, 4},

            new int[]{19, 5, 3}
    };

    boolean[] targets = new boolean[]{
            true,
            true,
            false
    };

    /*
    function is_subset(a1, a2):

    if (a2.length > a1.length) return false
    initialize set
    store a1 values in set
    initialize counter
    loop through a2 and check if its values are present in the set, increment counter if so
    if (counter == a2.size) return true else false

    * */

    public boolean is_subset(int[] a1, int[] a2) {

        if (a2.length > a1.length) return false;

        Set<Integer> set = new HashSet<>();

        for (int a1Value : a1) {
            set.add(a1Value);
        }

        int counter = 0;

        for (int a2Value : a2) {
            if (set.contains(a2Value)) {
                counter++;
            }
        }

        if (counter == a2.length) return true;
        else return false;
    }

    public String isSubset( long a1[], long a2[], long n, long m) {

        if (a2.length > a1.length) return "No";

        Set<Long> set = new HashSet<>();

        for (long a1Value : a1) {
            set.add(a1Value);
        }

        int counter = 0;

        for (long a2Value : a2) {
            if (set.contains(a2Value)) {
                counter++;
            }
        }

        if (counter == a2.length) return "Yes";
        else return "No";
    }

    public void test() {

        int failed = 0;

        for (int i = 0; i < test_arrs_a1.length; i++) {

            int[] test_arr_a1 = test_arrs_a1[i];
            int[] test_arr_a2 = test_arrs_a2[i];

            boolean result = is_subset(test_arr_a1, test_arr_a2);

            if (result != targets[i]) {
                System.out.println("test failed");
                System.out.println("a1: " + Arrays.toString(test_arr_a1));
                System.out.println("a2: " + Arrays.toString(test_arr_a2));
                System.out.println("expected: " + targets[i] + ", found: " + result);
                failed++;
            }
        }

        if (failed > 0) {
            System.out.println(failed + " out of " + test_arrs_a1.length + " tests failed");
        } else {
            System.out.println("Hurray! All " + test_arrs_a1.length + " tests passed!");
        }
    }

    public void testFirstCase() {
        boolean result = is_subset(test_arrs_a1[0], test_arrs_a2[0]);
        System.out.println("a1: " + Arrays.toString(test_arrs_a1[0]));
        System.out.println("a2: " + Arrays.toString(test_arrs_a2[0]));
        System.out.println("expected: " + targets[0] + ", found: " + result);
    }

    public void testThisCase(int index) {
        boolean result = is_subset(test_arrs_a1[index], test_arrs_a2[index]);
        System.out.println("a1: " + Arrays.toString(test_arrs_a1[index]));
        System.out.println("a2: " + Arrays.toString(test_arrs_a2[index]));
        System.out.println("expected: " + targets[index] + ", found: " + result);
    }

}
