/*
 * @lc app=leetcode.cn id=230 lang=java
 *
 * [230] 二叉搜索树中第 K 小的元素
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    private int cnt;
    private int ans = -1;

    public int kthSmallest(TreeNode root, int k) {

        cnt = k;
        inOrder(root);

        return ans;
    }

    private void inOrder(TreeNode root) {

        if (root == null)
            return;

        inOrder(root.left);
        if (ans != -1)
            return;

        cnt--;
        if (cnt == 0) {
            ans = root.val;
            return;
        }

        inOrder(root.right);

    }
}
// @lc code=end
