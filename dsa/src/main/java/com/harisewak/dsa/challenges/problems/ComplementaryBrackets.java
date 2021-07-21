package com.harisewak.dsa.challenges.problems;

import com.harisewak.dsa.datastructures.implementation.DoublyLinkedList;
import com.harisewak.dsa.datastructures.implementation.Stack;

public class ComplementaryBrackets {

    /*
    function is_seq_valid(sequence):
    isEmpty ? return valid
    chop it into chars
    iterate through chars
    is open bracket ? add to stack
    is closed bracket ? pop and check if its complementary, return invalid if not
    iterate through all chars
    if stack is empty, return valid else return invalid
    * */

    public static boolean isSequenceValid(String sequence) {

        if (sequence.isEmpty()) return true;

        char[] chars = sequence.toCharArray();
        Stack stack = new Stack();

        for (int i = 0; i < chars.length; i++) {

            char aChar = chars[i];

            if (isOpenBracket(aChar)) {
                stack.push(new DoublyLinkedList.Node<Character>(aChar));
            } else {
                DoublyLinkedList.Node<Character> node = stack.pop();
                if (!isComplementaryBracket(aChar, node.getData())) return false;
            }
        }

        if (stack.isEmpty()) return true;
        else return false;
    }

    private static boolean isComplementaryBracket(Character aChar, Character anotherChar) {

        switch (aChar) {

            case ')':
                if (anotherChar == '(') return true;

            case ']':
                if (anotherChar == '[') return true;

            case '}':
                if (anotherChar == '{') return true;

            default:
                return false;
        }

    }

    private static boolean isOpenBracket(char aChar) {

        switch (aChar) {
            case '(':
            case '[':
            case '{':
                return true;
            default:
                return false;
        }

    }

}
