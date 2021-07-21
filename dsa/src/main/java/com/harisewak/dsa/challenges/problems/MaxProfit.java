package com.harisewak.dsa.challenges.problems;

import com.harisewak.dsa.challenges.Print;

import java.util.Arrays;

public class MaxProfit {

    int[][] test_arrs = new int[][]{
            new int[]{2, 6, 10, 5, 75, 65, 80},
            new int[]{5, 6, 10, 75, 65, 80},
            new int[]{10, 5, 22, 2, 65, 80},
            new int[]{5, 1, 15, 20, 4, 3, 50, 4, 2, 20, 1, 5, 10, 30, 2, 5, 6, 70, 5, 4, 10},
            new int[]{10, 22, 5, 75, 65, 80},
            new int[]{2, 30, 15, 10, 8, 25, 80},
            new int[]{100, 30, 15, 10, 8, 25, 80},
            new int[]{90, 80, 70, 60, 50},
            new int[]{2, 10, 22, 40, 60},
            new int[]{2, 30, 10, 22}
    };

    int[] targets = new int[]{
            88,
            85,
            95,
            118,
            87,
            100,
            72,
            0,
            58,
            40
    };

    /*
    function max_profit_in_one_txn (arr):

    if (arr.length < 2) return 0

    low = arr[0]
    high = -1
    max_profit = 0

    for arr 1 to n:
        if (arr[i] < low)
            low = arr[i]
            high = -1
        else if (arr[i] > high)
            high = arr[i]
            profit = high - low
            if (profit > max_profit) max_profit = profit

    if (low == -1 || high == -1) return 0

    return max_profit
    * */

    public int[] max_profit_in_one_txn(int[] arr, int start, int end) {

        Print.ln("start end", start, end);

        if (end - start < 1) return new int[]{0, -1, -1};

        int low = arr[start];
        int low_index = start;
        int high = -1;
        int high_index = -1;
        int max_profit = 0;

        //Print.ln("low high max_profit", low, high, max_profit);

        for (int i = start + 1; i <= end; i++) {

            if (arr[i] < low) {
                low = arr[i];
                low_index = i;
                high = -1;
                high_index = -1;
            } else if (arr[i] > high) {
                high = arr[i];
                high_index = i;
                int profit = high - low;
                if (profit > max_profit) max_profit = profit;
            }

        }

        if (low == -1 || high == -1) return new int[]{0, -1, -1};

        Print.ln("low high max_profit", low, high, max_profit);

        return new int[]{max_profit, low_index, high_index};
    }

    /*
    function max_profit_in_two_transactions(arr):

    max_profit = 0

    profit_one, low_index, high_index = max_profit_in_one_txn(arr, 0, n)

    max_profit += profit_one

    if (low_index > 1) start = 0, end = low_index - 1
        profit_two_before = max_profit_in_one_txn(arr, start, end)

    if (high_index < n - 2) start = high_index + 1, end = n - 1
        profit_two_after = max_profit_in_one_txn(arr, start, end)

    profit_two = profit_two_before OR profit_two_after (whichever is greater)

    max_profit += profit_two

    return max_profit
    * */

    public int max_profit_in_two_transactions(int[] arr) {

        int max_profit = 0;
        int n = arr.length;

        int[] result_profit_one = max_profit_in_one_txn(arr, 0, n - 1);

        int profit_one = result_profit_one[0];
        int low_index = result_profit_one[1];
        int high_index = result_profit_one[2];

        max_profit += profit_one;

        int start;
        int end;

        int profit_two_before = 0;

        if (low_index > 1) {
            start = 0;
            end = low_index - 1;
            profit_two_before = max_profit_in_one_txn(arr, start, end)[0];
        }

        int profit_two_after = 0;

        if (high_index < n - 2) {
            start = high_index + 1;
            end = n - 1;
            profit_two_after = max_profit_in_one_txn(arr, start, end)[0];
        }

        int profit_two;

        if (profit_two_before > profit_two_after) {
            profit_two = profit_two_before;
        } else {
            profit_two = profit_two_after;
        }

        max_profit += profit_two;

        return max_profit;

    }

    public int max_profit(int[] arr) {

        int max_profit = 0;

        int profit1 = max_profit_in_one_txn(arr, 0, arr.length - 1)[0];

        int profit2 = max_profit_in_two_transactions(arr);

        if (profit1 > profit2) {
            max_profit = profit1;
        } else {
            max_profit = profit2;
        }
        Print.ln("profit1 profit2 max_profit", profit1, profit2, max_profit);

        return max_profit;
    }

    static int max_profit_Geeks4Geeks_Og(int price[], int n) {
        // Create profit array
        // and initialize it as 0
        int profit[] = new int[n];
        for (int i = 0; i < n; i++)
            profit[i] = 0;

        /* Get the maximum profit
           with only one transaction
           allowed. After this loop,
           profit[i] contains
           maximum profit from
           price[i..n-1] using at most
           one trans. */
        int max_price = price[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            // max_price has maximum
            // of price[i..n-1]
            if (price[i] > max_price)
                max_price = price[i];

            // we can get profit[i]
            // by taking maximum of:
            // a) previous maximum,
            // i.e., profit[i+1]
            // b) profit by buying
            // at price[i] and selling
            // at
            //    max_price
            profit[i] = Math.max(profit[i + 1],
                    max_price - price[i]);
            //Print.ln("profit i", profit[i], i);
        }

        //Print.ln("max_profit_1", profit[0]);

        /* Get the maximum profit
           with two transactions allowed
           After this loop, profit[n-1]
           contains the result
         */
        int min_price = price[0];
        for (int i = 1; i < n; i++) {
            // min_price is minimum
            // price in price[0..i]
            if (price[i] < min_price)
                min_price = price[i];

            // Maximum profit is maximum of:
            // a) previous maximum, i.e., profit[i-1]
            // b) (Buy, Sell) at (min_price, price[i]) and
            // add
            // profit of other trans.
            // stored in profit[i]
            Print.ln(
                    "i profit[i] price[i] min_price profit[i-1] profit[i]+(price[i]-min_price)",
                    i,
                    profit[i],
                    price[i],
                    min_price,
                    profit[i - 1],
                    profit[i] + (price[i] - min_price)
            );
            profit[i] = Math.max(
                    profit[i - 1],
                    profit[i] + (price[i] - min_price));
            //Print.ln("profit i", profit[i], i);
        }
        int result = profit[n - 1];
        //Print.ln("max_profit_2", result);
        return result;
    }

    public int max_profit_Geeks4Geeks(int price[]) {
        // Create profit array
        // and initialize it as 0
        int n = price.length;
        int profit[] = new int[n];
        for (int i = 0; i < n; i++)
            profit[i] = 0;

        int min_price = price[0];
        for (int i = 1; i < n; i++) {
            // min_price is minimum
            // price in price[0..i]
            if (price[i] < min_price)
                min_price = price[i];

            // Maximum profit is maximum of:
            // a) previous maximum, i.e., profit[i-1]
            // b) (Buy, Sell) at (min_price, price[i]) and
            // add
            // profit of other trans.
            // stored in profit[i]
            profit[i] = Math.max(
                    profit[i - 1],
                    (price[i] - min_price));

            Print.ln("profit[i]_of_two_txns i", profit[i], i);
        }

        /* Get the maximum profit
           with only one transaction
           allowed. After this loop,
           profit[i] contains
           maximum profit from
           price[i..n-1] using at most
           one trans. */

        int max_price = price[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            // min_price is minimum
            // price in price[0..i]
            if (price[i] > max_price)
                max_price = price[i];

            // Maximum profit is maximum of:
            // a) previous maximum, i.e., profit[i-1]
            // b) (Buy, Sell) at (max_price, price[i]) and
            // add
            // profit of other trans.
            // stored in profit[i]
            profit[i] = Math.max(
                    profit[i + 1],
                    profit[i] + (price[i] - max_price));

            Print.ln("profit[i]_of_two_txns i", profit[i], i);
        }

        /* Get the maximum profit
           with two transactions allowed
           After this loop, profit[n-1]
           contains the result
         */

        int result = profit[0];
        return result;
    }


    public void test() {
        int failed = 0;

        for (int i = 0; i < test_arrs.length; i++) {
            int[] test_arr = test_arrs[i];
            int profit = max_profit_Geeks4Geeks_Og(test_arr, test_arr.length);
            if (targets[i] != profit) {
                System.out.println("test failed");
                System.out.println("array: " + Arrays.toString(test_arr));
                System.out.println("expected: " + targets[i] + ", found: " + profit);
                failed++;
            }
        }

        if (failed > 0) {
            System.out.println(failed + " out of " + test_arrs.length + " tests failed");
        } else {
            System.out.println("Hurray! All " + test_arrs.length + " tests passed!");
        }
    }

    public void testFirstCase() {
        int result = max_profit_Geeks4Geeks_Og(test_arrs[0], test_arrs[0].length);
        System.out.println("array: " + Arrays.toString(test_arrs[0]));
        System.out.println("expected: " + targets[0] + ", found: " + result);
    }

    public void testThisCase(int index) {
        int result = max_profit_Geeks4Geeks_Og(test_arrs[index], test_arrs[index].length);
        System.out.println("array: " + Arrays.toString(test_arrs[index]));
        System.out.println("expected: " + targets[index] + ", found: " + result);
    }

}
