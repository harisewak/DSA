package com.harisewak.dsa.challenges.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> result = new ArrayList<>();

        for (int i = 0; i < strs.length - 1; i++) {
            if (strs[i].equals("-")) continue;
            String curStr = strs[i];

            List<String> curList = new ArrayList<>();
            curList.add(curStr);

            for (int j = i+1; j < strs.length; j++) {

                if (strs[j].equals("-")) continue;
                String nextStr = strs[j];
                if (isAnagram(curStr, nextStr)) {
                    strs[j] = "-";
                    strs[i] = "-";
                    curList.add(nextStr);
                }

            }

            result.add(curList);
        }

        int lastIndex = strs.length - 1;

        if (!strs[lastIndex].equals("-")) {
            List<String> curList = new ArrayList<>();
            curList.add(strs[lastIndex]);
            result.add(curList);
        }

        return result;
    }

    private boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character,Integer> charCountMap = new HashMap<>();

        // filling characters with count for s
        for (int i = 0; i < s.length(); i++) {

            if (!charCountMap.containsKey(s.charAt(i))) {
                charCountMap.put(s.charAt(i), 1);
            } else {
                int count = charCountMap.get(s.charAt(i));
                charCountMap.put(s.charAt(i), count+1);
            }

        }


        // compare with t and reduce character count
        for (int i = 0; i < t.length(); i++) {
            if (!charCountMap.containsKey(t.charAt(i))) {
                return false;
            } else {
                int count = charCountMap.get(t.charAt(i));
                if (count == 0) return false;
                charCountMap.put(t.charAt(i), count-1);
            }

        }

        return true;
    }
}
