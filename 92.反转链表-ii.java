/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        
        if (head.next == null || left == right) return head;

        ListNode pivot = new ListNode(0);
        pivot.next = head;
        
        ListNode node = head, start = pivot;
        for (int i = 1;i < left;i++) {
            start = node;
            node = node.next;           
        }

        ListNode begin = node;
        ListNode pre = node, next = null;
        node = node.next;
        for (int i = left;i < right;i++) {

            next = node.next;
            node.next = pre;
            pre = node;
            node = next;

        }
        
        start.next = pre;
        begin.next = next;

        return pivot.next;
    }
}
// @lc code=end

