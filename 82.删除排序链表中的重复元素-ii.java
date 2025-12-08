/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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
    public ListNode deleteDuplicates(ListNode head) {
        
        if (head == null) return null;
        ListNode pivot = new ListNode(0);
        pivot.next = head;
        
        ListNode pre = pivot, p = pre.next;
        while (p != null) {
            int cur = p.val;
            if (p.next != null && p.next.val == cur) {
                while (p != null && p.val == cur) p = p.next;
                if (p == null) pre.next = p;
            } else {
                pre.next = p;
                pre = p;
                p = p.next;
            }
        }
        
        return pivot.next;
    }

}
// @lc code=end

