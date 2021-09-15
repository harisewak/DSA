package com.harisewak.dsa.challenges.problems;

public class MoveZeroesToTheEnd {

    /*
   Iterate through nums
    If you encounter zero, search for a non-zero element
    if search returns -1, exit
    else swap zero with non-zero element
    do this till the end
    * */

    public void moveZeroesToTheEnd(int[] nums) {
        int curIndex = 0;

        while (curIndex < nums.length) {
            if (nums[curIndex] == 0) {
                // search for a non-zero element
                int nonZeroElIndex = findNonZeroElIndex(nums, curIndex + 1);
                if (nonZeroElIndex == -1) return;
                swap(nums, curIndex, nonZeroElIndex);
            }
            curIndex++;
        }

    }

    /*
    * First move all non-zeroes to the front
    Now fill all remaining indices with zero
    * */
    public void moveZeroesToTheEndTwo(int[] nums) {
        int lastNonZeroElAt = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[lastNonZeroElAt++] = nums[i];
            }
        }

        for (int i = lastNonZeroElAt; i < nums.length; i++) {
            nums[i] = 0;
        }

    }

    private void swap(int[] nums, int curIndex, int nonZeroElIndex) {
        int temp = nums[curIndex];
        nums[curIndex] = nums[nonZeroElIndex];
        nums[nonZeroElIndex] = temp;
    }

    private int findNonZeroElIndex(int[] nums, int nextIndex) {

        for (int i = nextIndex; i < nums.length; i++) {
            if (nums[i] != 0) {
                return i;
            }
        }

        return -1;
    }


}




