package com.harisewak.dsa.challenges.problems;

public class AlternatePositiveNegativeIntegers {

    /*
    Ramble:

        array of +ve and -ve integers
    arrange them in alternate order
    If more +ve or -ve, put them at the end

    Input:  arr[] = {-5, -2, 5, 2, 4, 7, 1, 8, 0, -8}
    output: arr[] = {-5, 5, -2, 2, -8, 4, 7, 1, 8, 0}

    1st element should be positive
    2nd element should be negative

    For indices
    even = +ve
    odd = -ve

    Pseudocode:

    for arr 0 to n:
            if (i % 2 == 0):
                if (arr[i] > 0):
                    continue
                else:
                    find positive value, if not found exit

            else:
                if (arr[i] < 0):
                    continue
                else:
                    find negative value, if not found exit
    */

    int[] rearrange(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                if (arr[i] > 0) {
                    continue;
                } else {
                    int positiveIndex = findPositiveIndex(arr, i);
                    if (positiveIndex == -1) {
                        break;
                    } else {
                        swap(positiveIndex, i, arr);
                    }
                }
            } else {
                if (arr[i] < 0) {
                    continue;
                } else {
                    int negativeIndex = findNegativeIndex(arr, i);
                    if (negativeIndex == 1) {
                        break;
                    } else {
                        swap(negativeIndex, i, arr);
                    }
                }
            }
        }

        return arr;
    }

    void swap(int from, int to, int[] arr) {
        int temp = arr[to];
        arr[to] = arr[from];
        arr[from] = temp;
    }

    int findPositiveIndex(int[] arr, int current) {
        int result = -1;
        for (int i = current+1; i < arr.length; i++) {
            if (arr[i] > 0) {
                result = i;
                break;
            }
        }

        return result;
    }

    int findNegativeIndex(int[] arr, int current) {
        int result = -1;
        for (int i = current+1; i < arr.length; i++) {
            if (arr[i] < 0) {
                result = i;
                break;
            }
        }

        return result;
    }

}
