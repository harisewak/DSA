package com.harisewak.dsa.challenges.problems;

import com.harisewak.dsa.algorithms.Sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
// 1 -2 8 7 -2

    public int getPairsCount_Geeks4Geeks(int[] arr, int n, int sum) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        // Store counts of all elements in map hm
        for (int i = 0; i < n; i++) {

            // initializing value to 0, if key not found
            boolean containsKey = hm.containsKey(arr[i]);
//            System.out.println("containsKey: "+containsKey);
            if (!containsKey) {
                hm.put(arr[i], 0);
//                System.out.println("hm key: "+arr[i]+", initial value: "+0);
            }

            int value = hm.get(arr[i]) + 1;
            hm.put(arr[i], value);
            System.out.println("hm key: " + arr[i] + ", updated value: " + value);
        }
        int complementary_numbers = 0;
        System.out.println("complementary_numbers at start: " + complementary_numbers);

        // iterate through each element and increment the
        // count (Notice that every pair is counted twice)
        for (int i = 0; i < n; i++) {
            if (hm.get(sum - arr[i]) != null) {
                complementary_numbers += hm.get(sum - arr[i]);
                System.out.println("complementary_numbers: " + complementary_numbers);
            }

            // if (arr[i], arr[i]) pair satisfies the
            // condition, then we need to ensure that the
            // count is decreased by one such that the
            // (arr[i], arr[i]) pair is not considered
            if (sum - arr[i] == arr[i]) {
                complementary_numbers--;
                System.out.println("when sum - arr[i] == arr[i], complementary_numbers: " + complementary_numbers);
            }
        }

        // return the half of complementary_numbers
        return complementary_numbers / 2;
    }

    public int maxProfit(int[] prices) {

        // min always comes before maximum
        // max difference should be recorded

        int min = prices[0];
        int max = -1;
        int max_diff = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
                max = -1;
                continue;
            }
            if (prices[i] > max) {
                max = prices[i];
            }

            int diff = max - min;

            if (diff > max_diff) {
                max_diff = diff;
            }
        }

        return max_diff;
    }

    public int mergeAndCount(int[] arr, int l,
                             int m, int r) {

        // Left subarray
        int[] left = Arrays.copyOfRange(arr, l, m + 1);

        // Right subarray
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l, swaps = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }
        while (i < left.length)
            arr[k++] = left[i++];
        while (j < right.length)
            arr[k++] = right[j++];
        return swaps;
    }

    // Merge sort function
    private int mergeSortAndCount(int[] arr, int l,
                                  int r) {

        // Keeps track of the inversion count at a
        // particular node of the recursion tree
        int count = 0;

        if (l < r) {
            int m = (l + r) / 2;

            // Total inversion count = left subarray count
            // + right subarray count + merge count

            // Left subarray count
            count += mergeSortAndCount(arr, l, m);

            // Right subarray count
            count += mergeSortAndCount(arr, m + 1, r);

            // Merge count
            count += mergeAndCount(arr, l, m, r);
        }

        return count;
    }

    public long inversionCount(long arr[], long N) {
        int inversionCount = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    inversionCount++;
                }
            }
        }

        return inversionCount;
    }

    public int[][] merge(int[][] intervals) {
//        System.out.println("intervals at start");
//        print2DArray(intervals);

//        int negativeValues = 0;
        int mergeCounter = 0;
        int mergeIndex = -1;

        for (int i = 0; i < intervals.length; i++) {

            if (intervals[i][0] == -1 && intervals[i][1] == -1) {
//                negativeValues++;
                continue;
            }

            if (mergeIndex != -1) {
                i = mergeIndex;
                mergeIndex = -1;
            }

            for (int j = i + 1; j < intervals.length; j++) {

                if (intervals[j][0] == -1 && intervals[j][1] == -1) {
                    continue;
                }

                int[] mergeResult = mergeRange(intervals[i], intervals[j]);

                if (mergeResult[0] != -1 && mergeResult[1] != -1) {
                    intervals[i] = mergeResult;
                    intervals[j] = new int[]{-1, -1};
                    mergeIndex = i;
                    mergeCounter++;
                }

            }

//            System.out.println("intervals at i = "+i);
//            print2DArray(intervals);
        }

//        int[][] mergedIntervals = new int[intervals.length-negativeValues][2];
        int[][] mergedIntervals = new int[intervals.length - mergeCounter][2];
        mergeCounter = 0;

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] != -1 && intervals[i][1] != -1) {
//                System.out.println("mergeCounter: "+mergeCounter+", i: "+i);
                mergedIntervals[mergeCounter] = intervals[i];
                mergeCounter++;
            }
        }

        return mergedIntervals;
    }

    private void print2DArray(int[][] intervals) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < intervals.length; i++) {
            builder.append("[");
            builder.append(intervals[i][0]);
            builder.append(", ");
            builder.append(intervals[i][1]);
            builder.append("] ");
        }
        String result = builder.toString().trim();
        System.out.println(result);
    }

    private int[] mergeRange(int[] a1, int[] a2) {
        int finalStart = -1;
        int finalEnd = -1;
        int a1Start = a1[0];
        int a1End = a1[1];
        int a2Start = a2[0];
        int a2End = a2[1];

        boolean overlap = false;

        // a1Start falls in between a2Start & a2End
        if (a1Start >= a2Start && a1Start <= a2End) {
            overlap = true;
        }

        // a2Start falls in between a1Start & a1End
        if (a2Start >= a1Start && a2Start <= a1End) {
            overlap = true;
        }

        if (overlap) {
            // set lower start value as finalStart
            if (a1Start < a2Start) {
                finalStart = a1Start;
            } else {
                finalStart = a2Start;
            }
            // set higher end value as finalEnd
            if (a1End > a2End) {
                finalEnd = a1End;
            } else {
                finalEnd = a2End;
            }
        }

        return new int[]{finalStart, finalEnd};
    }

    int maxSubarraySum_Kadane(int arr[], int n) {
        int max = Integer.MIN_VALUE;
        int maxSoFar = 0;

        for (int i = 0; i < arr.length; i++) {
            maxSoFar += arr[i];

            if (maxSoFar < 0) {
                maxSoFar = 0;
            }

            if (maxSoFar > max) {
                max = maxSoFar;
            }
        }

        return max;
    }

    public void merge(int arr1[], int arr2[], int n, int m) {
        int i1 = 0;
        while (i1 < arr1.length) {
            if (arr1[i1] > arr2[0]) {
                int temp = arr1[i1];
                arr1[i1] = arr2[0];
                // before attempting arr2[0] = temp; find correct position of temp i.e. check i2 + 1, i2 + 2, i + 3.. i2 last and place temp in correct position
                int j = 1;
                while (j < arr2.length) {
                    if (temp > arr2[j]) {
                        arr2[j - 1] = arr2[j];
                    } else {
                        arr2[j - 1] = temp;
                        break;
                    }
                    j++;
                }

                // when last element of arr1 is greater than last element of arr2
                if (j == arr2.length) {
                    arr2[j - 1] = temp;
                }
            }
            i1++;
        }
    }

    public int findDuplicate(int[] nums) {
        Set<Integer> table = new HashSet<>();
        for (int num : nums) {
            if (table.contains(num)) {
                return num;
            }
            table.add(num);
        }

        return -1;
    }

    static int minJumps_Geeks4Geeks(int arr[]) {
        if (arr.length <= 1)
            return 0;

        // Return -1 if not possible to jump
        if (arr[0] == 0)
            return -1;

        // initialization
        int maxReach = arr[0];
        int step = arr[0];
        int jump = 1;

        // Start traversing array
        for (int i = 1; i < arr.length; i++) {
            // Check if we have reached
// the end of the array
            if (i == arr.length - 1)
                return jump;

            // updating maxReach
            maxReach = Math.max(maxReach, i + arr[i]);

            // we use a step to get to the current index
            step--;

            // If no further steps left
            if (step == 0) {
                // we must have used a jump
                jump++;

                // Check if the current
// index/position or lesser index
                // is the maximum reach point
// from the previous indexes
                if (i >= maxReach)
                    return -1;

                // re-initialize the steps to the amount
                // of steps to reach maxReach from position i.
                step = maxReach - i;
            }
        }

        return -1;
    }

    static int minJumps(int[] arr) {
        int jumpCount = 0;
        int pointer = 0;
        int jumps = arr[pointer];

        while (pointer < arr.length) {
            if (jumps >= arr.length) {
                return jumpCount;
            } else {
                jumpCount++;
                int zeros = findZeros(arr, pointer, pointer + jumps);
                System.out.println("zeros: " + zeros);
                pointer += jumps + zeros;
                if (pointer < arr.length) {
                    jumps = arr[pointer];
                }
            }
            System.out.println("jumpCount: " + jumpCount + ", pointer: " + pointer + ", jumps: " + jumps);
        }

        return jumpCount;
    }

    int getMinDiff_Geeks4Geeks(int[] arr, int n, int k) {
        int[] allPossibleValues = new int[arr.length * 2];
        int apIndex = 0;
        for (int i = 0; i < arr.length; i++) {
            int sum = arr[i] + k;
            int diff = arr[i] - k;
            allPossibleValues[apIndex] = sum;
            apIndex++;
            if (diff >= 0) {
                allPossibleValues[apIndex] = diff;
                apIndex++;
            }
        }

        System.out.println("apIndex: " + apIndex);
        System.out.println("allPossibleValues length: " + allPossibleValues.length);
        printArray(allPossibleValues);
        int[] sortedArr = Sort.mergeSort(allPossibleValues, 0, apIndex - 1);
        System.out.println("sortedArr: ");
        printArray(sortedArr);
        return 0;
    }

    int getMinDiff(int[] arr, int n, int k) {
        int[][] possibilities = generatePossibilities(arr, k);
        int[] differences = countDifferences(possibilities);
        int minDiff = minDifference(differences);
        return minDiff;
    }

    int[] countDifferences(int[][] possibilities) {
        int[] differences = new int[possibilities.length];

        for (int index = 0; index < possibilities.length; index++) {
            int[] possibility = possibilities[index];

            if (possibility == null) {
                continue;
            }

            int min = possibility[0];
            int max = possibility[0];

            for (int j = 0; j < possibility.length; j++) {
                if (possibility[j] < min) {
                    min = possibility[j];
                } else if (possibility[j] > max) {
                    max = possibility[j];
                }
            }

            int diff = max - min;

            differences[index] = diff;
        }

        return differences;
    }


    int[][] generatePossibilities(
           int[] arr,
            int k
    ) {
        int[][] possibilities = new int[arrSize(arr.length)][];
        for (int i = 0; i < possibilities.length; i++) {
            int[] temp = new int[arr.length];
            boolean isNegative = false;
            for (int j = 0; j < arr.length; j++) {
                temp[j] = determineValue(possibilities.length, i, j, arr[j], k);
                if (temp[j] < 0) {
                    isNegative = true;
                }
            }

            if (!isNegative) {
                possibilities[i] = temp;
            }

            System.out.println("possibility: "+Arrays.toString(possibilities[i]));

        }
        return possibilities;
    }

    int arrSize(int size) {
        int result = 1;
        for (int i = 0; i < size; i++) {
            result *= 2;
        }
        return result;
    }

    int determineValue(int total, int index, int position, int value, int k) {
        int result = -1;
        int alternateBetween = alternateCount(total, position);
        int quotient = (index + 1) / alternateBetween;
        int remainder = (index + 1) % alternateBetween;

        if (quotient % 2 == 0 && remainder == 0) {
            //    quotient is even & remainder is 0 = low
            result = value - k;
        } else if (quotient % 2 == 0 && remainder > 0) {
            //    quotient is even & remainder > 0 = high
            result = value + k;
        } else if (quotient % 2 != 0 && remainder == 0) {
            //    quotient is odd & remainder is 0 = high
            result = value + k;
        } else if (quotient % 2 != 0 && remainder > 0) {
            //    quotient is odd & remainder > 0 = low
            result = value - k;
        }

        return result;
    }

    int alternateCount(int total, int position) {
        int result = 1;

        for (int i = 0; i < (position + 1); i++) {
            result *= 2;
        }

        return total / result;
    }

    int minDifference(int[] differences) {
        int result = Integer.MAX_VALUE;

        for (int i = 0; i < differences.length; i++) {
            if (differences[i] != 0 && differences[i] < result) {
                result = differences[i];
            }
        }

        return result;
    }


    static int maxSubArraySum_Efficient(int a[], int size) {
        int max = Integer.MIN_VALUE;
        int max_until_now = 0;
        for (int i = 0; i < a.length; i++) {
            max_until_now += a[i];
            if (max < max_until_now) {
                max = max_until_now;
            }
            if (max_until_now < 0) {
                max_until_now = 0;
            }
        }
        return max;
    }

    static int maxSubArraySum_Geeks4Geeks(int a[], int size) {
        int max_so_far = Integer.MIN_VALUE,
                max_ending_here = 0, start = 0,
                end = 0, s = 0;

        for (int i = 0; i < size; i++) // i = 4
        {
            max_ending_here += a[i]; // 13

            if (max_so_far < max_ending_here) // false
            {
                max_so_far = max_ending_here; // 15
                start = s;
                end = i;
            }

            if (max_ending_here < 0) // false
            {
                max_ending_here = 0; //
                s = i + 1;
            }
        }
        return max_so_far;
    }

    int maxSubarraySum(int arr[], int n) {

        int max = -1;
        for (int i = 0; i < arr.length; i++) { // i = 0
            if (max < arr[i]) max = arr[i];
            for (int j = i + 1; j < arr.length; j++) { // j = 4
                int sum = 0; // sum = 0
                for (int k = i; k <= j; k++) { // k = 0
                    sum += arr[k]; // 10
                    if (max < sum) max = sum;
                }
            }
        }

        return max;
    }

    public void rotate(long arr[], long n) {
        int last = (int) arr[(int) (n - 1)];
        for (int i = (int) (n - 1); i > 0; i--) {
            arr[i] = arr[i - 1];
        }
        arr[0] = last;
    }

    public int doUnion(int a[], int n, int b[], int m) {
        int[] unionArr = new int[n + m];
        int unionIndex = -1;
        Map<Integer, Boolean> table = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (!table.containsKey(a[i])) {
                unionArr[++unionIndex] = a[i];
                table.put(a[i], true);
            }
        }

        for (int i = 0; i < m; i++) {
            if (!table.containsKey(b[i])) {
                unionArr[++unionIndex] = b[i];
                table.put(b[i], true);
            }
        }

        return table.size();
    }

    public void sortNegativeAndPositiveNumbersByGeeks4Geeks(int[] arr) { // arr = -11, -1, -5, 6, 7, -2, 8
        {
            int j = 0, temp; // j = 3
            for (int i = 0; i < arr.length; i++) { // i = 5
                if (arr[i] < 0) { // true
                    if (i != j) { // true
                        temp = arr[i]; // -2
                        arr[i] = arr[j]; // 6
                        arr[j] = temp; // 6
                    }
                    j++; // 3
                }
                // -11, -1, -5, -2, 7, 6, 8
            }
            printArray(arr);
        }
    }

    public void sortNegativeAndPositiveNumbers(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            if (arr[start] < 0) {
                start++;
            } else {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                end--;
            }
        }

        printArray(arr);
    }

    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> comp = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (comp.get(nums[i]) >= 0) {
                return new int[]{comp.get(nums[i]), i};
            }
            comp.put(target - nums[i], i);
        }
        return new int[]{-1, -1};
    }

    /*
* Iterate through nums
Run another loop inside it
add elements at i and j and check if sum is equal to target
return i and j if they do
* */
    public static int[] twoSumOg(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    /*
     * Store all elements in hashmap with indices as keys and elements as values
     * Check if current element's compliment (target - curElement) is present in hashmap
     * if true, return curElement's index and compliment's key
     * */
    public static int[] twoSumTwo(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hashMap.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {

            int compliment = target - nums[i];

            if (hashMap.containsKey(compliment)) {
                Integer compElIndex = hashMap.get(compliment);
                // ignoring same index
                if (i == compElIndex) {
                    continue;
                }

                return new int[]{i, compElIndex};
            }
        }

        return new int[]{-1, -1};
    }

    ;

    public static void sort012(int a[], int n) {
        // code here
        int[] newArr = new int[n]; // 0,0,1,2
        int filledIndex = -1; // 4
        for (int i = 0; i < n; i++) {
            if (a[i] == 0) {
                newArr[++filledIndex] = a[i]; // newArr[1], 0
            }
        }
        for (int i = 0; i < n; i++) {
            if (a[i] == 1) {
                newArr[++filledIndex] = a[i]; // newArr[2], 1
            }
        }
        for (int i = 0; i < n; i++) { // i = 3
            if (a[i] == 2) { // true
                newArr[++filledIndex] = a[i]; // newArr[4], 2
            }
        }

        a = newArr;
        for (int i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
    }

    static void sort012Efficient(int a[], int arr_size) {
        int lo = 0;
        int hi = arr_size - 1;
        int mid = 0, temp = 0;
        while (mid <= hi) {
            System.out.println("lo: " + lo + ", hi: " + hi + ", mid: " + mid);

            int swappedIndex1 = 0;
            int swappedIndex2 = 0;
            switch (a[mid]) {
                case 0: {
                    temp = a[lo];
                    a[lo] = a[mid];
                    swappedIndex1 = lo;
                    a[mid] = temp;
                    swappedIndex2 = mid;
                    lo++;
                    mid++;
                    break;
                }
                case 1:
                    mid++;
                    break;
                case 2: {
                    temp = a[mid];
                    a[mid] = a[hi];
                    swappedIndex1 = mid;
                    a[hi] = temp;
                    swappedIndex2 = hi;
                    hi--;
                    break;
                }
            }
            printArray(a, swappedIndex1, swappedIndex2);
        }
    }

    static void printArray(int[] arr) {
        int i;
        for (i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }

    /* Utility function to print array arr[] */
    static void printArray(int arr[], int arr_size) {
        int i;
        for (i = 0; i < arr_size; i++)
            System.out.print(arr[i] + " ");
        System.out.println("");
    }

    static void printArray(int arr[], int swi1, int swi2) {
        for (int i = 0; i < arr.length; i++)
            if (i == swi1 || i == swi2) {
                System.out.print("'" + arr[i] + "'" + " ");
            } else {
                System.out.print(arr[i] + " ");
            }
        System.out.println("");
    }

    static int findZeros(int[] arr, int start, int end) {
        int result = 0;
        for (int i = start; i <= end && i < arr.length; i++) {
            if (arr[i] == 0) {
                result++;
            }
        }
        return result;
    }
}
