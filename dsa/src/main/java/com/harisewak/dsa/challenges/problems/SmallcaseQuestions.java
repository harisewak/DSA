package com.harisewak.dsa.challenges.problems;

public class SmallcaseQuestions {

    public static void main(String[] args) {
        // return a substring which has any character k times
        // follow ordering
        String str = "aabbaabacabb"; //a = 6, b = 5, c = 1
        int k = 5;

        String result = returnSubString(str, k);

        System.out.println("result: "+result);
    }

    private static String returnSubString_Optimized(String str, int k) {

        // construct an array of 26 values and use alphabets a-z as keys to store their count in indices
        int[] charCount = new int[26];

        for (int i = 0; i < str.length(); i++) {
            char key = str.charAt(i);
            charCount[key-'a']++;
        }

        // construct a substring which the given char at least k times
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char key = str.charAt(i);

            if (charCount[key-'a'] >= k) {
                stringBuilder.append(str.charAt(i));
            }

        }

        return stringBuilder.toString();
    }

    private static String returnSubString(String str, int k) {

        // create a table with characters as keys and their count as values
        Map<Character, Integer> table = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char curChar = str.charAt(i);
            if (!table.containsKey(curChar)) {
                table.put(curChar, 1);
            } else {
                int count = table.get(curChar);
                table.put(curChar, count + 1);
            }
        }

        // construct a substring which the given char at least k times
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char key = str.charAt(i);

            if (table.get(key) >= k) {
                stringBuilder.append(str.charAt(i));
            }

        }

        return stringBuilder.toString();
    }
}
