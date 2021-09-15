package com.harisewak.dsa.challenges.problems;

import java.util.Arrays;

public class PlusOne {

    /*
    * Iterate through the array appending each element to a string
    convert it into integer
    increment it
    convert the new value back to string
    split into into characters
    convert each character into a decimal digit
    store them in an array
    return the array
    * */
    public int[] plusOne(int[] arr) {
        System.out.println("given array: "+ Arrays.toString(arr));
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println();
        StringBuilder builder = new StringBuilder();
        for (int i : arr) {
            builder.append(i);
        }
        int value = Integer.parseInt(builder.toString());
        int updateValue = value + 1;
        String updatedString = String.valueOf(updateValue);
        String[] split = updatedString.split("");

        int[] updatedArr;
        if (split.length > arr.length) {
            updatedArr = new int[split.length];
        } else {
            updatedArr = arr;
        }

//        System.out.println("split array: "+ Arrays.toString(split));

        for (int i = 0; i < split.length; i++) {
            updatedArr[i] = Integer.parseInt(split[i]);
        }
//        System.out.println("updated array: "+ Arrays.toString(updatedArr));
        return arr;
    }

}
