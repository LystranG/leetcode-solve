/*
 * @lc app=leetcode.cn id=200 lang=java
 *
 * [200] 岛屿数量
 */

// @lc code=start
class Solution {
    public int numIslands(char[][] grid) {

        int m = grid.length, n = grid[0].length;

        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j, m, n);
                    cnt++;
                }
            }
        }

        return cnt;

    }

    private void dfs(char[][] grid, int row, int col, int m, int n) {
        if (row < 0 || row >= m || col < 0 || col >= n)
            return;
        if (grid[row][col] != '1')
            return;

        grid[row][col] = 'x';
        dfs(grid, row - 1, col, m, n);
        dfs(grid, row, col - 1, m, n);
        dfs(grid, row, col + 1, m, n);
        dfs(grid, row + 1, col, m, n);
    }
}
// @lc code=end
