package com.harisewak.dsa.challenges.problems;

public class ReverseInteger {


    /*
    * Get hold of last digit by dividing the given number by 10
    Determine places and multiply last digit with it
    Continue until value is less than 10
    * */
    public int reverse(int x) {
        if (x < 10) {
            return x;
        }
        int lastDigit = x % 10;
        int remainingNum = x / 10;
//        System.out.println("last digit: "+lastDigit);
        int multiplier = determinePlaces(x, 0);
//        System.out.println("multiplier: "+multiplier);
        int reverseNum = lastDigit * powerOf10(multiplier);
//        System.out.println("reverseNum: "+reverseNum);
        if (remainingNum > 10) {
            reverseNum += reverse(remainingNum);
//            System.out.println("reverseNum: "+reverseNum);
        } else {
            reverseNum += remainingNum;
//            System.out.println("reverseNum: "+reverseNum);
        }

        return reverseNum;
    }

    private int powerOf10(int multiplier) {
        int result = 1;
        int ten = 10;
        for (int i = 0; i < multiplier; i++) {
            result *= ten;
        }
        return result;
    }

    private int determinePlaces(int num, int multiplier) {
//        System.out.println("num: "+num+", multiplier: "+multiplier);
        if (num > 10) {
            multiplier = determinePlaces(num/10, multiplier+1);
        }
        return multiplier;
    }

}
