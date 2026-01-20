/*
 * @lc app=leetcode.cn id=138 lang=java
 *
 * [138] 随机链表的复制
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    // public Node copyRandomList(Node head) {
    //
    // if (head == null) return null;
    //
    // Node pivot = new Node(0);
    // Node p1 = pivot, p2 = head;
    //
    // Map<Node, Node> map = new HashMap<>();
    // while (p2 != null) {
    // Node node = new Node(p2.val);
    // map.put(p2, node);
    // p1.next = node;
    // p1 = node;
    //
    // p2 = p2.next;
    // }
    //
    // p1 = pivot.next;
    // p2 = head;
    // while (p2 != null) {
    // p1.random = map.get(p2.random);
    // p1 = p1.next;
    // p2 = p2.next;
    // }
    //
    // return pivot.next;
    //
    // }

    public Node copyRandomList(Node head) {

        if (head == null)
            return null;

        Node p1 = head;
        while (p1 != null) {

            Node node = new Node(p1.val);
            node.next = p1.next;
            p1.next = node;
            p1 = node.next;

        }

        p1 = head;
        while (p1 != null) {

            if (p1.random != null) {
                p1.next.random = p1.random.next;
            }

            p1 = p1.next.next;
        }

        p1 = head;
        Node pivot = new Node(0), p2 = pivot;
        while (p1 != null) {
            p2.next = p1.next;
            p2 = p2.next;

            p1.next = (p1.next == null ? null : p1.next.next);
            p1 = p1.next;
        }

        return pivot.next;

    }
}

// @lc code=end
