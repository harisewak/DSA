package com.harisewak.dsa.challenges.problems;

import com.harisewak.dsa.challenges.TestDataKt;

import java.util.Arrays;

public class MaxProduct {

    /*
    if arr.length == 1:
    return arr[0]

max_till_now = 0
max = 0

// find negative boundaries
negative_boundaries = []
boundary_index = 0
negative_count = 0
start_negative = -1
end_negative = -1

for arr 0 to n:
  if arr[i] < 0:
    if start_negative == -1:
        start_negative = i
    else if end_negative == -1:
        end_negative = i
    negative_count++

  if arr[i] == 0:
    if negative_count == 1:
        arr[start_negative] = 0
    else if negative_count % 2 != 0:
        negative_boundaries[boundary_index++] = start_negative
        negative_boundaries[boundary_index++] = end_negative
        start_negative = -1
        end_negative = -1
        negative_count = 0

if negative_boundaries.length > 0:
    boundary_index = 0

// calculate max when odd negatives (>1) are present in subarray
    start_boundary = calculate boundary before negative_boundaries[boundary_index]
    end_boundary = negative_boundaries[boundary_index+1] - 1
    max_till_now = multiply start_boundary until before negative_boundaries[boundary_index+1]
    if max_till_now > max:
        max = max_till_now
    start_boundary = negative_boundaries[boundary_index]+1
    end_boundary = calculate boundary after negative_boundaries[boundary_index+1]
    max_till_now = multiply after negative_boundaries[boundary_index] till negative_boundaries[boundary_index+1]
    if max_till_now > max:
        max = max_till_now
    boundary_index += 2

for arr 0 to n:
    if (max_till_now == 0):
        max_till_now = 1
    max_till_now = max_till_now * arr[i]
    if (max_till_now > max):
        max = max_till_now

return max
    * */

    public long maxProduct(int[] arr, int n) {
//        System.out.println("maxProduct");
        if (arr.length == 1) return arr[0];
        long max_till_now = 0;
        long max = 0;

        int[] negative_boundaries = new int[arr.length];
        int boundary_index = 0;
        boundary_index = findNegativeBoundaries(arr, negative_boundaries, boundary_index);

//        System.out.println("negative_boundaries: "+Arrays.toString(negative_boundaries));

        int negative_arr_size = boundary_index;
        if (negative_arr_size > 0) {
            boundary_index = 0;


            // calculate max when odd negatives (>1) are present in subarray
            while (boundary_index < negative_arr_size) {
                int start_boundary = calcStartBoundary(arr, negative_boundaries[boundary_index]);
                int end_boundary = negative_boundaries[boundary_index+1] - 1;
//                System.out.println("negative_boundaries[boundary_index]: "+negative_boundaries[boundary_index]+", negative_boundaries[boundary_index+1] - 1: "+(negative_boundaries[boundary_index+1] - 1));
//                System.out.println("start_boundary: "+start_boundary+", end_boundary: "+end_boundary);
                max_till_now = product(arr, start_boundary, end_boundary);
                if (max_till_now > max) max = max_till_now;
                start_boundary = negative_boundaries[boundary_index]+1;
                end_boundary = calcEndBoundary(arr, negative_boundaries[boundary_index+1]);
//                System.out.println("negative_boundaries[boundary_index]+1: "+(negative_boundaries[boundary_index]+1)+", negative_boundaries[boundary_index+1]: "+(negative_boundaries[boundary_index+1]));
//                System.out.println("start_boundary: "+start_boundary+", end_boundary: "+end_boundary);
                max_till_now = product(arr, start_boundary, end_boundary);
                if (max_till_now > max) max = max_till_now;
                boundary_index += 2;
            }
        }

        max_till_now = 1;

        for (int i = 0; i < arr.length; i++) {
            if (max_till_now == 0) max_till_now = 1;
            max_till_now = max_till_now * arr[i];
            if (max_till_now > max) max = max_till_now;
        }

        return max;
    }

    // DOESN'T WORK
    static long maxProduct_Geeks4Geeks(int arr[], int n)
    {

        // Variables to store maximum and minimum
        // product till ith index.
        long minVal = arr[0];
        long maxVal = arr[0];

        long maxProduct = arr[0];

        for (int i = 1; i < n; i++)
        {

            // When multiplied by -ve number,
            // maxVal becomes minVal
            // and minVal becomes maxVal.
            if (arr[i] < 0)
            {
                long temp = maxVal;
                maxVal = minVal;
                minVal =temp;

            }

            // maxVal and minVal stores the
            // product of subarray ending at arr[i].
            maxVal = Math.max(arr[i], maxVal * arr[i]);
            minVal = Math.min(arr[i], minVal * arr[i]);

            // Max Product of array.
            maxProduct = Math.max(maxProduct, maxVal);
        }

        // Return maximum product found in array.
        return maxProduct;
    }

    private int calcStartBoundary(int[] arr, int negative_index) {
        int result = -1;
        for (int i = negative_index; i >= 0; i--) {
            if (i == 0) {
                result = 0;
            }
            if (arr[i] == 0) {
                result = i+1;
                break;
            }
        }
        return result;
    }

    private int calcEndBoundary(int[] arr, int negative_index) {
        int result = -1;
        for (int i = negative_index; i < arr.length; i++) {
            if (i == arr.length - 1) {
                result = i;
            }
            if (arr[i] == 0) {
                result = i-1;
                break;
            }
        }
        return result;
    }


    private long product(int[] arr, int start, int end) {
        long result = 1;
        for (int i = start; i <= end; i++) {
            result *= arr[i];
        }
//        System.out.println("product: " + result);
        return result;
    }

    int findNegativeBoundaries(int[] arr, int[] negative_boundaries, int boundary_index) {
        int negative_count = 0;
        int start_negative = -1;
        int end_negative = -1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                if (start_negative == -1)
                    start_negative = i;
                else {
                    end_negative = i;
                }
                negative_count++;
//                System.out.println("value: "+arr[i]+", negative_count: "+negative_count);

            } else if (arr[i] == 0) {
                if (negative_count == 1) {
                    arr[start_negative] = 0;
                    start_negative = -1;
                    end_negative = -1;
                    negative_count = 0;
                } else if (negative_count % 2 != 0) {
                    negative_boundaries[boundary_index++] = start_negative;
                    negative_boundaries[boundary_index++] = end_negative;
                    start_negative = -1;
                    end_negative = -1;
                    negative_count = 0;
                } else {
                    start_negative = -1;
                    end_negative = -1;
                    negative_count = 0;
                }
            }

            if (i == arr.length - 1) {
//                System.out.println("the end: nc: "+negative_count);
                if (negative_count == 1) {
                    arr[start_negative] = 0;
                    start_negative = -1;
                    end_negative = -1;
                    negative_count = 0;
                } else if (negative_count % 2 != 0) {
//                    System.out.println("here");
                    negative_boundaries[boundary_index++] = start_negative;
                    negative_boundaries[boundary_index++] = end_negative;
                    start_negative = -1;
                    end_negative = -1;
                    negative_count = 0;
                } else {
//                    System.out.println("not here");
                    start_negative = -1;
                    end_negative = -1;
                    negative_count = 0;
                }
            }

//            System.out.println("arr[i]: " + arr[i] + ", start_negative: " + start_negative + ", end_negative: " + end_negative+", boundary_index: "+boundary_index+", negative_count: "+negative_count);
        }

//        System.out.println("negative_boundaries: " + Arrays.toString(negative_boundaries) + ", boundary_index: "+boundary_index);

        return boundary_index;
    }

    public void test() {
        int failed = 0;
        int[][] test_arrs = new int[][]{
                new int[]{2, 3, 4, 5, -1, 0},

                new int[]{-2, 0, 50, 10},

                new int[]{-1, -1, -1, -1, 10},

                new int[]{20, 0, 5, -5, 6},

                new int[]{-8, 5, 2, 10},

                new int[]{8, -5, 2, 10},

                new int[]{8, 5, -5, 2, 10},

                new int[]{-8, 5, -10, -2},

                new int[]{-8, -8, 1, 10},

                new int[]{0, 3, -5, -2, 8, -7, -6, -2, -3, -9},

                new int[]{2, 5, -4, -5, 10, 5, 2, 4, -10, -10, -10},

                new int[]{2, 2, 0, -10, -10, 0, -200, 10, 5},

                new int[]{2, 2, 0, -10, -10, 0, -2, 10, 5, -10, -10},

                new int[]{3, 12, 15, 23, 33, -35, 30, -40, -30, -30, -30, 26, 28},

                new int[]{5, -8, 0, 0, 2, -12, -2, -7, 6, -14, -8, 1, -2, -1, -7, 5, 13, 16, 25, 31, 37, 45, -55},

                new int[]{9, 0, 8, -1, -2, -2, 6}
        };

        long[] targets = new long[]{
                120,
                500,
                10,
                20,
                100,
                20,
                40,
                400,
                640,
                60480,
                8000000,
                100,
                5000,
                15492708000000L,
                9721590278400000L,
                24
        };

        for (int i = 0; i < test_arrs.length; i++) {
            int[] test_arr = test_arrs[i];
            long product = maxProduct_Geeks4Geeks(test_arr, 0);
            if (targets[i] != product) {
                System.out.println("test failed");
                System.out.println("array: "+Arrays.toString(test_arr));
                System.out.println("expected: "+targets[i]+", found: "+product);
                failed++;
            }
        }

        if (failed > 0) {
            System.out.println(failed + " out of " + test_arrs.length + " tests failed");
        } else {
            System.out.println("Hurray! All tests passed!");
        }
    }

    public void testFailedCase() {
        int[] arr = new int[]{5, -8, 0, 0, 2, -12, -2, -7, 6, -14, -8, 1, -2, -1, -7, 5, 13, 16, 25, 31, 37, 45, -55};
        maxProduct(arr, 0);
        System.out.println("array: "+Arrays.toString(arr));
    }


    }
