package com.harisewak.dsa.challenges.problems;

public class FindMaxOnesIn2DArray {
    // package whatever; // don't place package name!
// Installed Libraries: JSON-Simple, JUNit 4, Apache Commons Lang3
/*

Given a boolean 2D array of n x m dimensions where each row is sorted.
Find the 0-based index of the first row that has the maximum number of 1's.

Example 1:
Input:
N = 4 , M = 4
Arr[][] = {{0, 1, 1, 1},
           {0, 0, 1, 1},
           {1, 1, 1, 1},
           {0, 0, 0, 0}}
Output: 2
Explanation: Row 2 contains 4 1's (0-based
indexing).

Example 2:
Input:
N = 2, M = 2
Arr[][] = {{0, 0}, {1, 1}}
Output: 1
Explanation: Row 1 contains 2 1's (0-based
indexing).

Your Task:
You don't need to read input or print anything.
Your task is to complete the function rowWithMax1s() which
takes the array of booleans arr[][], n and m as input parameters
and returns the 0-based index of the first row that
has the most number of 1s. If no such row exists, return -1.
*/


        // count number of 1s in each row
        // return index of row which has max 1's
        static int rowWithMax1s(int arr[][], int n, int m) {
            int curCount = 0;
            int maxCount = 0;

            // outer loop represents columns
            for (int i = 0; i < n; i++) {
                curCount = calcOneCount(arr[i]);
                if (curCount > maxCount) {
                    maxCount = curCount;
                }
            }

     return 0;

    }

    static int calcOneCount(int[] arr) {
        return 0;
    }
}



















