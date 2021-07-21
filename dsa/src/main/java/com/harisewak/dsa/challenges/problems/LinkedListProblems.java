package com.harisewak.dsa.challenges.problems;

import java.util.HashSet;
import java.util.Set;

public class LinkedListProblems {


     //Definition for singly-linked list.
     class ListNode {
         int val;
         ListNode next;
         ListNode(int x) {
             val = x;
             next = null;
         }
     }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) return null;

        ListNode travA = headA;
        ListNode travB = headB;
        Set memory = new HashSet<ListNode>();

        while (travA != null) {

            memory.add(travA);

            travA = travA.next;
        }

        while (travB != null) {

            if (memory.contains(travB)) {
                return travB;
            }

            travB = travB.next;
        }

        return null;
    }


        public boolean hasCycle(ListNode head) {

            ListNode trav = head;

            Set memory = new HashSet<ListNode>();

            while (trav != null) {

                if (memory.contains(trav)) {
                    return true;
                }

                memory.add(trav);
                trav = trav.next;
            }

            return false;
        }

    public boolean hasCycle_LeetCode(ListNode head) {

         if (head == null) return false;

        ListNode slow = head;
        ListNode fast = head.next;


        while (slow != fast) {

            if (fast == null || fast.next == null) {
                return false;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        return true;
    }

}
