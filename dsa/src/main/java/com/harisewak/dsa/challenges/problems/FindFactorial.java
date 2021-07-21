package com.harisewak.dsa.challenges.problems;

/*
Details:

find factorial of a number
constraints:
time complexity - O(n)
space complexity - O(1)

Input : 5
Output : 120

Pseudocode:

result = 1
for 1 to n:
    result = result * i
return result
 */

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FindFactorial {

    /*
    Initialize a list
    Run a for loop from 1 to n
    factorial = factorial * i
    perform modulo on factorial and store result in list until it returns 0
    return list
    * */
    public static ArrayList<Integer> factorial(int N){

        ArrayList<Integer> result = new ArrayList<>();

        BigInteger factorial = new BigInteger("1");

        for (int i = 1; i <= N; i++) {
            factorial = factorial.multiply(new BigInteger(String.valueOf(i)));
        }

        System.out.println("factorial: "+factorial);

        /*
        Initialize list
        split into chars
        transfrom each char to integer
        add integers to the list
        * */

        char[] chars = factorial.toString().toCharArray();

        for (char aChar : chars) {
            result.add(Integer.valueOf(String.valueOf(aChar)));
        }

        return result;
    }

}
