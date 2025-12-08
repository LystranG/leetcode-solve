/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根节点到叶节点数字之和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumNumbers(TreeNode root) {
        
        if (root == null) return 0;
        
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int parent) {

        int cur = parent * 10 + root.val;
        int left = root.left == null ? 0 : dfs(root.left, cur);
        int right = root.right == null ? 0 : dfs(root.right, cur );

        if (left == 0 && right == 0) {
            return cur;
        } else {

            return left + right;
        }
    }
}
// @lc code=end

