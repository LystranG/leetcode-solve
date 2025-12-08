/*
 * @lc app=leetcode.cn id=222 lang=java
 *
 * [222] 完全二叉树的节点个数
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
    public int countNodes(TreeNode root) {
        if (root == null)
            return 0;

        int deep = 0;
        TreeNode node = root.left;
        while (node != null) {
            deep++;
            node = node.left;
        }

        if (deep == 0)
            return 1;

        int left = 1 << deep, right = (1 << (deep + 1)) - 1;
        while (left <= right) {

            int mid = (left + right) / 2;
            if (exists(root, mid, deep)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return right;
    }

    private boolean exists(TreeNode root, int index, int deep) {
        int mask = 1 << (deep - 1); // 最高位的下一位掩码（控制路径方向）
        TreeNode node = root;
        while (node != null && mask > 0) {
            if ((index & mask) == 0) {
                node = node.left; // 该位为0，走左子树
            } else {
                node = node.right; // 该位为1，走右子树
            }
            mask >>= 1; // 掩码右移，判断下一位
        }
        return node != null;
    }


}
// @lc code=end
