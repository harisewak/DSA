package com.harisewak.dsa.challenges.problems;

public class WeSkillQuestions {



    public static int sumOfDuplicateAndMissing(int[] nums) {
        int result = -1;
        int missing = -1;
        int duplicated = -1;
        Set<Integer> set =  new HashSet<Integer>();

        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                duplicated = nums[i];
                System.out.println("duplicated: "+duplicated);
            }
        }

        for (int j = 1; j <= nums.length; j++) {
            if (!set.contains(j)) {
                missing = j;
                System.out.println("missing: "+missing);
                break;
            }
        }

        result = duplicated + missing;

        return result;
    }


    public static int palindromeErrorCount(String someText) {
        int result = 0;
        if (someText.length() < 2) return result;
        int start = 0;
        int end = someText.length()-1;
        while (start < end) {
            if (someText.charAt(start) != someText.charAt(end)) {
                result += 2;
            }
            start++;
            end--;
        }
        return result;
    }

    public static boolean canReachEnd(int[] steps) {
        int maxReach = steps[0];
        int theEnd = steps.length-1;
        if (maxReach >= theEnd) return true;

        int curIndex = maxReach;
        while (maxReach < theEnd) {
            int curReach = steps[curIndex];
            if (curReach == 0) return false;
            maxReach += curReach;
            if (maxReach >= theEnd) return true;
            curIndex += curReach;
        }

        return true;
    }
}
