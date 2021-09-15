package com.harisewak.dsa.algorithms;

public class ConvertDecimalToBinary {

    /*
     * Convert decimal to binary
     * Divide N by 2 and store remainder at index 0
     * New value is the result of previous division (N/2)
     * Do this until (N/2) is <= 0
     * */
    public void decimalToBinary(int num) {
        int[] result = new int[8];
        int interim = num / 2;
        int remainder = num % 2;
        int index = 0;
        result[index] = remainder;

        while (interim > 0) {
            remainder = interim % 2;
            interim = interim / 2;
            result[++index] = remainder;
        }

        System.out.println("Decimal: " + num + ", binary: ");

        for (int i = result.length - 1; i >= 0; i--) {
            System.out.print(result[i]);
        }

        System.out.println();
    }

}
