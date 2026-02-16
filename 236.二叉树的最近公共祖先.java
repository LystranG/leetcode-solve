/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == p || root == q) {
            return root;
        }

        TreeNode left = root.left == null ? null : lowestCommonAncestor(root.left, p, q);
        if (left != null && left != p && left != q)
            return left;

        TreeNode right = root.right == null ? null : lowestCommonAncestor(root.right, p, q);

        if ((left != null) && (right == p || right == q)) {
            return root;
        }

        if (left != null) {
            return left;
        } else
            return right;
    }

}
// @lc code=end
