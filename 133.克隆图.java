/*
 * @lc app=leetcode.cn id=133 lang=java
 *
 * [133] 克隆图
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
    
        if (node == null) return null;
        
        Node ans = new Node(node.val);
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        
        Map<Integer, Node> map = new HashMap<>();
        map.put(node.val, ans);

        while (!queue.isEmpty()) {
            Node n = queue.poll();
            Node n1 = map.get(n.val);
            for (Node neighbor : n.neighbors) {

                Node newNode = map.get(neighbor.val);
                if (newNode == null) {
                    newNode = new Node(neighbor.val);
                    map.put(neighbor.val, newNode);
                    queue.offer(neighbor);
                }
                n1.neighbors.add(newNode);
            }

        }
        
        return ans;
    }
}
// @lc code=end

