package com.harisewak.dsa.challenges.problems;

import com.harisewak.dsa.algorithms.Sort;
import com.harisewak.dsa.challenges.Print;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import kotlin.jvm.JvmStatic;

public class TripletSum {

    int[][] test_arrs = new int[][]{
            new int[]{1, 4, 5, 10, 7},
            new int[]{557, 217, 627, 358, 527, 358, 338, 272, 870, 362, 897, 23, 618, 113, 718, 697, 586, 42, 424, 130, 230, 566, 560, 933},
            new int[]{1, 4, 45, 6, 10, 8},

            new int[]{1, 2, 4, 3, 6},

            new int[]{1, 2, 5, 6, 4}
    };

    boolean[] targets = new boolean[]{
            true,
            true,
            true,
            true,
            false
    };

    int[] x_values = new int[]{
            16,
            986,
            13,
            10,
            50
    };


    /*
    loop through the arr
    save each in a set
    run another loop inside
    check if set contains sum - arr[j]
    if it does return true
    in the end return false
    * */

    public static boolean find3Numbers_using_set(int A[], int n, int X) {

        int statement_index = 0;

        Set<Integer> set = new HashSet<>();

        for (int value : A) {
            set.add(value);
            statement_index++;
        }

        for (int i = 0; i < A.length; i++) {

            int sum = X - A[i];

            for (int j = i + 1; j < A.length; j++) {

                boolean result = set.contains(sum - A[j]);

                /*System.out.println(
                                "i: " + i
                                + ", A[i]: " + A[i]
                                + ",  sum: " + sum
                                + ", j: " + j
                                + ", A[j]: " + A[j]
                                + ",  set: " + set
                                + ", result: " + result
                );*/


                if (result) {
                    System.out.println("Found at statement no. "+statement_index);
                    return true;
                }

                statement_index++;
            }
        }

        return false;
    }


    /*

    write 3 nested loops each starting with i = 0, j = i + 1 & k = j + 1 respectively (next value)
    idea is to exhaust each combination of triplets to see if they match X
    return true when they do

    * */

    public static boolean find3Numbers(int A[], int n, int X) {

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < A.length; k++) {
                    if (A[i] + A[j] + A[k] == X) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean triplet_sum_Geeks4Geeks_two_pointer(int[] arr, int X) {
        int n = arr.length;
        quickSort(arr, 0, n - 1);

        for (int i = 0; i < n - 2; i++) {
            int l = i + 1;
            int r = n - 1;
            while (l < r) {
                int sum = arr[i] + arr[l] + arr[r];
                if (sum == X) return true;
                if (sum < X) l++;
                if (sum > X) r--;
            }
        }

        return false;
    }

    int[] quickSort(int[] arr, int start, int end) {

        if (start >= end) {
            return arr;
        }

        int pivotIndex = start;
        int next = pivotIndex + 1;
        while (next <= end) {
            if (arr[next] < arr[pivotIndex]) {
                int temp = arr[next];
                arr[next] = arr[pivotIndex];
                arr[pivotIndex] = temp;
                pivotIndex = next;
                next = pivotIndex + 1;
            } else {
                next++;
            }
        }

        quickSort(arr, start, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, end);

        return arr;
    }


    public void test() {
        int failed = 0;

        for (int i = 0; i < test_arrs.length; i++) {
            int[] test_arr = test_arrs[i];
            boolean result = find3Numbers_using_set(test_arr, 0, x_values[i]);
            if (targets[i] != result) {
                System.out.println("test failed");
                System.out.println("array: " + Arrays.toString(test_arr));
                System.out.println("X: " + x_values[i]);
                System.out.println("expected: " + targets[i] + ", found: " + result);
                failed++;
            }
        }

        if (failed > 0) {
            System.out.println(failed + " out of " + test_arrs.length + " tests failed");
        } else {
            System.out.println("Hurray! All " + test_arrs.length + " tests passed!");
        }
    }

    public void testFirstCase() {
        boolean result = find3Numbers_using_set(test_arrs[0], test_arrs[0].length, x_values[0]);
        System.out.println("array: " + Arrays.toString(test_arrs[0]));
        System.out.println("X: " + x_values[0]);
        System.out.println("expected: " + targets[0] + ", found: " + result);
    }

    public void testThisCase(int index) {
        boolean result = find3Numbers_using_set(test_arrs[index], test_arrs[index].length, x_values[index]);
        System.out.println("array: " + Arrays.toString(test_arrs[index]));
        System.out.println("X: " + x_values[index]);
        System.out.println("expected: " + targets[index] + ", found: " + result);
    }

}
