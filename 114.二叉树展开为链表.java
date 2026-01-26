/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
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
    // public void flatten(TreeNode root) {
    //
    // if (root == null) return;
    //
    // convert(root);
    //
    // }
    //
    // private TreeNode convert(TreeNode node) {
    //
    // if (node == null) return null;
    // if (node.left == null && node.right == null) return node;
    //
    // TreeNode leftLast = convert(node.left);
    // TreeNode rightLast = convert(node.right);
    //
    // if (leftLast == null) {
    // return rightLast;
    // } else if (rightLast == null){
    // node.right = node.left;
    // node.left = null;
    // return leftLast;
    // } else {
    // leftLast.right = node.right;
    // node.right = node.left;
    // node.left = null;
    // return rightLast;
    // }
    //
    // }

    public void flatten(TreeNode root) {

        if (root == null)
            ;

        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode node = cur.left;
                while (node.right != null) {
                    node = node.right;
                }
                node.right = cur.right;
                cur.right = null;

                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }

    }
}
// @lc code=end
