/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 */

// @lc code=start
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

    private Integer pre = null;

    public boolean isValidBST(TreeNode root) {

        if (root == null)
            return true;

        if (root.left != null && !isValidBST(root.left)) {
            return false;
        }

        if (pre != null && pre >= root.val) {
            return false;
        }
        pre = root.val;

        if (root.right != null && !isValidBST(root.right)) {
            return false;
        }
        return true;
    }

}

// @lc code=end
