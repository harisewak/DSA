package com.harisewak.dsa.challenges.problems;

public class RotateArray {

    /*
    while times <= k
         save first element as temp
         move the rest of the elements ahead by 1 position
         save temp into last position
    return arr
    * */

    public int[] rotate(int[] arr, int steps) {
        int times = 1;

        while (times <= steps) {
            moveLastElementToStart(arr);
            times++;
        }

        return arr;
    }

    private int[] moveFirstElementBack(int[] arr) {
        int temp = arr[0];

        for (int i = 0; i < arr.length - 1; i++) {
            arr[i] = arr[i+1];
        }
        arr[arr.length - 1] = temp;

        return arr;
    }

    private int[] moveLastElementToStart(int[] arr) {
        int last = arr.length - 1;
        int temp = arr[last];

        for (int i = last; i >= 1; i--) {
            arr[i] = arr[i-1];
        }
        arr[0] = temp;

        return arr;
    }

}
