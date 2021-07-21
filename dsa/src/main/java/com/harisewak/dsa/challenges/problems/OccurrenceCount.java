package com.harisewak.dsa.challenges.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class OccurrenceCount {

    int[][] test_arrs = new int[][]{
            new int[]{3, 1, 2, 2, 1, 2, 3, 3},
            new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 0},
            new int[]{0, 0, 0, 0, 0, 0},
            new int[]{1, 1, 1, 4, 7, 20, 15},
            new int[]{45, 20, 16, 4, 45, 52, 45, 20, 16, 4, 45, 52}
    };

    int[] k_arr = new int[]{
            4,
            5,
            2,
            3,
            12
    };

    int[][] targets = new int[][]{
            new int[]{2, 3},
            new int[]{},
            new int[]{0},
            new int[]{1},
            new int[]{4, 16, 20, 45, 52}
    };

    /*
    calculate occurrence_count
    initialize num_of_elements to 0
    add elements to map:
        if an element is not present, set count as 1 and continue
        get count
        if count is -1, continue
        increment count
        if count is greater than occurrence_count, increment num_of_elements & set count as -1
    create an array of size[num_of_elements]
    store elements from map with value of -1 in it
    * */

    public int[] getRecurringElements(int[] arr, int k) {

        int occurrence_count = arr.length / k;
        //System.out.println("occurrence_count: " + occurrence_count);
        int num_of_elements = 0;

        Map<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < arr.length; i++) {

            if (!map.containsKey(arr[i])) {
                map.put(arr[i], 0);
            }

            Integer count = map.get(arr[i]);

            //System.out.println("count before: " + count);

            if (count == -1) continue;

            count++;

            if (count > occurrence_count) {
                num_of_elements++;
                count = -1;
            }

            map.put(arr[i], count);

            //System.out.println("arr[i]: " + arr[i] + ", count after: " + count + ", num_of_elements: " + num_of_elements);

        }

        int[] elementArr = new int[num_of_elements];

        Iterator<Integer> iterator = map.keySet().iterator();
        int index = 0;

        while (iterator.hasNext()) {
            Integer element = iterator.next();
            int count = map.get(element);
            if (count == -1) {
                elementArr[index++] = element;
            }
        }

        return elementArr;
    }

    public void test() {
        int failed = 0;

        for (int i = 0; i < test_arrs.length; i++) {

            int[] test_arr = test_arrs[i];
            int[] elements = getRecurringElements(test_arr, k_arr[i]);

            boolean outputMatches = true;

            if (elements.length == targets[i].length) {

                for (int j = 0; j < elements.length; j++) {
                    if (elements[j] != targets[i][j]) {
                        outputMatches = false;
                        break;
                    }
                }

            } else {
                outputMatches = false;
            }

            if (!outputMatches) {
                System.out.println("test failed");
                System.out.println("array: " + Arrays.toString(test_arr));
                System.out.println("expected: " + Arrays.toString(targets[i]) + ", found: " + Arrays.toString(elements));
                failed++;
            }
        }

        if (failed > 0) {
            System.out.println(failed + " out of " + test_arrs.length + " tests failed");
        } else {
            System.out.println("Hurray! All "+test_arrs.length+" tests passed successfully!");
        }
    }

    public void testFirstCase() {
        int[] test_arr = test_arrs[0];
        int[] elements = getRecurringElements(test_arr, k_arr[0]);

        boolean outputMatches = true;

        if (elements.length == targets[0].length) {

            for (int j = 0; j < elements.length; j++) {
                if (elements[j] != targets[0][j]) {
                    outputMatches = false;
                    break;
                }
            }

        } else {
            outputMatches = false;
        }

        if (!outputMatches) {
            System.out.println("test failed");
            System.out.println("array: " + Arrays.toString(test_arr));
            System.out.println("expected: " + Arrays.toString(targets[0]) + ", found: " + Arrays.toString(elements));
        } else {
            System.out.println("Hurray!! Test passed successfully!");
        }
    }

    public void testThisCase(int index) {
        int[] test_arr = test_arrs[index];
        int[] elements = getRecurringElements(test_arr, k_arr[index]);

        boolean outputMatches = true;

        if (elements.length == targets[index].length) {

            for (int j = 0; j < elements.length; j++) {
                if (elements[j] != targets[index][j]) {
                    outputMatches = false;
                    break;
                }
            }

        } else {
            outputMatches = false;
        }

        if (!outputMatches) {
            System.out.println("test failed");
            System.out.println("array: " + Arrays.toString(test_arr));
            System.out.println("expected: " + Arrays.toString(targets[index]) + ", found: " + Arrays.toString(elements));
        } else {
            System.out.println("Hurray!! Test passed successfully!");
        }
    }

}
