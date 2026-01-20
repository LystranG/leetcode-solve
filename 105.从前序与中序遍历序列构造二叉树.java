/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

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

    private Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        int n = preorder.length;

        for (int i = 0; i < n; i++) {
            map.put(inorder[i], i);
        }

        return subTree(preorder, inorder, 0, n - 1, 0, n - 1);

    }

    private TreeNode subTree(int[] preorder, int[] inorder, int pLeft, int pRight, int iLeft, int iRight) {

        if (pLeft > pRight || iLeft > iRight)
            return null;

        TreeNode root = new TreeNode(preorder[pLeft]);

        int index = map.get(root.val);
        int len = index - iLeft;

        root.left = subTree(preorder, inorder, pLeft + 1, pLeft + len, index - len, index - 1);
        root.right = subTree(preorder, inorder, pLeft + len + 1, pRight, index + 1, iRight);

        return root;
    }
}

// @lc code=end
