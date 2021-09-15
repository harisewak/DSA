package com.harisewak.dsa.challenges.problems;

import com.harisewak.dsa.challenges.Print;

public class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        // go through the array
        // if next element is greater than current element, keep going
        // if they are equal, push the next element to the end
        // if the next element is less, exit and return

        int curElementIndex = 0;
        int nextElementIndex = 1;
        int k = 1;

        while (nextElementIndex < nums.length) {

            int curElement = nums[curElementIndex];
            int nextElement = nums[nextElementIndex];

            if (nextElement > curElement) {
               curElementIndex++;
               nextElementIndex++;
            } else if (nextElement == curElement) {
                // push next element to the end
                pushToTheEnd(nums, nextElementIndex);
            } else {
                break;
            }

            k++;

        }

        return k;
    }

    private void pushToTheEnd(int[] arr, int itemIndex) {
        int temp = arr[itemIndex];
        for (int i = itemIndex; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[arr.length - 1] = temp;
    }

}
