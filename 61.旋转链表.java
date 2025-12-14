/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;
        
        int len = 1;
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
            len++;
        }
        k %= len;

        if (k == 0) return head;
        ListNode p2 = head;
        for (int i = 0;i < len - k - 1;i++) {
            p2 = p2.next;
        }

        ListNode ans = p2.next;
        p2.next = null;
        p.next = head;

        return ans;
    }
}
// @lc code=end

