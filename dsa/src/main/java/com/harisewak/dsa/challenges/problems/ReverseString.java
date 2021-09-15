package com.harisewak.dsa.challenges.problems;

public class ReverseString {

    /*
    * Create another array of same size
    Iterate the original array in reverse and fill the new one
    return the new array
    * */
    public char[] reverse(char[] arr) {
        char[] reverseArr = new char[arr.length];
        int ri = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            reverseArr[ri++] = arr[i];
        }
        return reverseArr;
    }

    /*
    * Use two pointers, one start other at end
    swap values at both pointers
    do this until startPointer >= endPointer
    * */
    public void reverse2(char[] arr) {
        int startPointer = 0;
        int endPointer = arr.length - 1;

        while (startPointer < endPointer) {
            System.out.println("swapping "+arr[startPointer]
            +" with "+arr[endPointer]);
            char temp = arr[startPointer];
            arr[startPointer] = arr[endPointer];
            arr[endPointer] = temp;
            startPointer++;
            endPointer--;
        }
    }

}
