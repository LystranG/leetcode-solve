/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */

// @lc code=start

import java.util.Optional;

import com.sun.tools.javac.resources.legacy;

class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};

class Solution {

    private Node last = null, rowStart = null;

    public Node connect(Node root) {

        if (root == null)
            return null;

        Node start = root;
        while (start != null) {
            last = null;
            rowStart = null;
            for (Node p = start; p != null; p = p.next) {
                if (p.left != null) {
                    handle(p.left);
                }
                if (p.right != null) {
                    handle(p.right);
                }
            }

            start = rowStart;
        }

        return root;
    }

    private void handle(Node node) {
        if (last == null) {
            last = node;
        } else {
            last.next = node;
            last = node;
        }

        if (rowStart == null)
            rowStart = node;
    }

}
// class Solution {
// public Node connect(Node root) {
//
// if (root == null) return null;
//
// Queue<Node> queue = new ArrayDeque<>();
// queue.offer(root);
// while (!queue.isEmpty()) {
// int len = queue.size();
// Node pre = queue.poll();
// if (pre.left != null) queue.offer(pre.left);
// if (pre.right != null) queue.offer(pre.right);
// for (int i = 1;i < len;i++) {
// Node next = queue.poll();
// if (next.left != null) queue.offer(next.left);
// if (next.right != null) queue.offer(next.right);
// pre.next = next;
// pre = next;
// }
// }
//
// return root;
// }
// }
// @lc code=end
