/*
 * @lc app=leetcode.cn id=427 lang=java
 *
 * [427] 建立四叉树
 */

// @lc code=start
/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {

    public Node construct(int[][] grid) {
        
        int n = grid.length;
        
        return constructNode(grid, n, 0, 0, n);
    }

    private Node constructNode(int[][] grid, int n, int row, int col, int size) {

        if (size == 1) {
           return new Node(grid[row][col] == 1, true);
        }
        
        int target = grid[row][col];
        boolean same = true;
        loop: for (int i = row;i < row + size;i++) {
            for (int j = col;j < col + size;j++) {
                if (grid[i][j] != target) {
                    same = false;
                    break loop;
                }
            }
        }
        if (same) {
            return new Node(target == 1, true);
        }
        
        size >>= 1;
        Node leftTop = constructNode(grid, n, row, col, size);
        Node rightTop = constructNode(grid, n, row, col + size, size);
        Node leftBottom = constructNode(grid, n, row + size, col, size);
        Node rightBottom = constructNode(grid, n, row + size, col + size, size);

        return new Node(false, false, leftTop, rightTop, leftBottom, rightBottom);
    }
    
}
// @lc code=end

