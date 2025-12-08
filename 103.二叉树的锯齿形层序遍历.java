/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        
        boolean flag = true;
        while (!queue.isEmpty()) {
            
            List<Integer> level = new ArrayList<>();
            int size = queue.size();
            if (flag) {
                for (int i = 0;i < size;i++) {
                    TreeNode node = queue.poll();
                    level.add(node.val);
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
            } else {
                for (int i = 0;i < size;i++) {
                    TreeNode node = queue.pollLast();
                    level.add(node.val);
                    if (node.right != null) queue.offerFirst(node.right);
                    if (node.left != null) queue.offerFirst(node.left);
                }
            }
            
            ans.add(level);
            flag = !flag;
        }
        
        return ans;
    }
}
// @lc code=end

