package com.harisewak.dsa.challenges.problems;

public class RainWaterProblem {


    /*
     * Calculate area of a trough -
     * Take their min
     * Subtract it with elements in between
     * And add those values
     * */
    int calcArea(int[] arr) {
        int result = 0;

        int lb = arr[0];
        int ub = arr[arr.length - 1];
        int baseline = Math.min(lb, ub);

        for (int i = 1; i < arr.length - 1; i++) {
            result += baseline - arr[i];
        }

        return result;
    }

    public static void main(String[] args) {
        RainWaterProblem obj = new RainWaterProblem();
        int[] arr = new int[]{4, 0, 1, 2, 4};
        int result = obj.calcArea(arr);
        System.out.println("result: "+result);
    }

}
