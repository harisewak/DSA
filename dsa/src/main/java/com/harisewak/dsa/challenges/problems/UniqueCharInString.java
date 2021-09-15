package com.harisewak.dsa.challenges.problems;

import java.util.HashMap;

public class UniqueCharInString {

    /*
    * Convert into char array
    Create hashmap to store element and their count
    Iterate through array and update count of each element in hashmap
    run through the array again this time using hashmap as reference
    if element is present only once, return its index else keep going
    return -1 at the end of the function
    * */
    public int findUniqueChar(String string) {

        char[] chars = string.toCharArray();
        HashMap<Character, Integer> table = new HashMap<>();

        for (char aChar : chars) {
            if (!table.containsKey(aChar)) {
                table.put(aChar, 1);
            } else {
                Integer count = table.get(aChar);
                table.put(aChar, count + 1);
            }
        }

        for (int i = 0; i < chars.length; i++) {
            char curChar = chars[i];
            if (table.get(curChar) == 1) {
                return i;
            }
        }

        return -1;
    }

    public int findUniqueChar2(String s) {

        int[] count = new int[26];
        int n = s.length();
        // build char count bucket : <charIndex, count>
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            System.out.println("i: "+i);
            System.out.println("s.charAt(i) int: "+ (int) s.charAt(i));
            System.out.println("s.charAt(i)char: "+ s.charAt(i));
            System.out.println("a: "+ (int) 'a');
            System.out.println("index: "+ index);
            int curCount = count[index];
            int updatedCount = curCount + 1;
            count[index] = updatedCount;
        }

        for (int i = 0; i < count.length; i++) {
            System.out.println("count: "+count[i]+" at i: "+i);
        }

        // find the index
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            if (count[index] == 1) {
                return i;
            }

        }
        return -1;
    }

}
