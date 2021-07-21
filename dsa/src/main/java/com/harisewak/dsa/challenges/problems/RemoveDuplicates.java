package com.harisewak.dsa.challenges.problems;

import com.harisewak.dsa.challenges.Print;

public class RemoveDuplicates {

    public int[] removeDuplicates(int[] nums) {
        int compareIndex = 0;
        int withIndex = 1;
        int pushTo = withIndex+1;

        while (withIndex < nums.length) {

            int compare = nums[compareIndex];
            int with = nums[withIndex];

            if (compare == with) {
                // elements have been pushed till the end, no more elements left
                if (pushTo > nums.length - 1) {
                    return nums;
                }
                pushBehind(nums,withIndex, pushTo);
                pushTo++;
            } else {

                if (pushTo <= nums.length - 1) {
                    if (compareIndex != withIndex + 1) {
                        int temp = nums[withIndex + 1];
                        nums[withIndex+1] = nums[pushTo];
                        nums[pushTo] = temp;
                    }
                }

                compareIndex++;
                withIndex = pushTo;
                pushTo++;
            }

            Print.ln("compareIndex withIndex pushTo", compareIndex, withIndex, pushTo);

        }

        return nums;
    }

    private void pushBehind(int[] nums, int withIndex, int pushTo) {
        int temp = nums[pushTo];
        nums[pushTo] = nums[withIndex];
        nums[withIndex] = temp;
    }

}
