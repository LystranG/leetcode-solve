/*
 * @lc app=leetcode.cn id=106 lang=java
 *
 * [106] 从中序与后序遍历序列构造二叉树
 */

// @lc code=start

import java.util.Deque;

import javax.swing.tree.TreeNode;

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

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        
        int n = inorder.length;

        return computeSub(inorder.length, inorder, postorder, 0, n - 1, 0, n - 1);
    }
    
    private TreeNode computeSub(int n, int[] inorder, int[] postorder, int inLeft, int inRight, int postLeft, int postRight) {

        if (inLeft > inRight || postLeft > postRight) return null;
        TreeNode root = new TreeNode(postorder[postRight--]);

        int inMid = inRight;
        while (inorder[inMid] != root.val) {
           inMid--;
        }
        int leftSize = inMid - inLeft;
        int rightSize = inRight - inMid;
        
        root.left = computeSub(n, inorder, postorder, inLeft, inMid - 1, postLeft, postLeft + leftSize - 1);
        root.right = computeSub(n, inorder, postorder, inMid + 1, inRight, postRight - rightSize + 1, postRight);
        
        return root;
    }
}
// @lc code=end

