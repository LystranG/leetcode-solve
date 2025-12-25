/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {

        if (head == null)
            return null;

        ListNode pivot = new ListNode();
        ListNode pivot2 = new ListNode();
        pivot.next = head;

        ListNode p = pivot, p2 = pivot2;
        while (p.next != null) {
            if (p.next.val < x) {
                ListNode next = p.next;
                p.next = next.next;
                p2.next = next;
                p2 = next;
            } else {
                p = p.next;
            }
        }
        p2.next = pivot.next;

        return pivot2.next;
    }
}
// @lc code=end
