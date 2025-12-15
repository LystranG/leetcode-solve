/*
 * @lc app=leetcode.cn id=173 lang=java
 *
 * [173] 二叉搜索树迭代器
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
class BSTIterator {
    private TreeNode cur;
    private Deque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        cur = root;
        stack = new LinkedList<TreeNode>();
    }

    public int next() {
        while (cur != null) {
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int ret = cur.val;
        cur = cur.right;
        return ret;
    }

    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }
}

// class BSTIterator {
//
// private final Deque<TreeNode> stack = new ArrayDeque<>();
//
// public BSTIterator(TreeNode root) {
//
// TreeNode p = root;
// stack.push(root);
// while (p.left != null) {
// p = p.left;
// stack.push(p);
// }
// }
//
// public int next() {
// TreeNode cur = stack.peek();
// if (cur.left != null) {
// stack.push(cur.left);
// }
//
// return cur.val;
// }
//
// public boolean hasNext() {
// return !stack.isEmpty();
// }
// }

// class BSTIterator {
//
// private final Deque<TreeNode> stack = new ArrayDeque<>();
//
// public BSTIterator(TreeNode root) {
//
// TreeNode p = root;
// stack.push(root);
// while (p.left != null) {
// p = p.left;
// stack.push(p);
// }
// }
//
// public int next() {
// TreeNode cur = stack.pop();
// if (cur.right != null) {
// TreeNode node = cur.right;
// stack.push(node);
// while (node.left != null) {
// stack.push(node.left);
// node = node.left;
// }
// }
// return cur.val;
// }
//
// public boolean hasNext() {
// return !stack.isEmpty();
// }
// }

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end
