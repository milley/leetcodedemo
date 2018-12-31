package com.milley.AddTwoNumbers;

import org.junit.Test;

public class SolutionTest {
    @Test
    public void addTwoNumbersTest() {
        Solution solution = new Solution();

        ListNode l1 = new ListNode(2);
        ListNode l2 = new ListNode(4);
        l1.next = l2;
        ListNode l3 = new ListNode(3);
        l2.next = l3;

        ListNode r1 = new ListNode(5);
        ListNode r2 = new ListNode(6);
        r1.next = r2;
        ListNode r3 = new ListNode(4);
        r2.next = r3;

        ListNode sumList = solution.addTwoNumbers(l1, r1);
        while (sumList != null) {
            System.out.println(sumList.val);
            sumList = sumList.next;
        }
    }


}
