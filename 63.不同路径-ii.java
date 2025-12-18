/*
 * @lc app=leetcode.cn id=63 lang=java
 *
 * [63] 不同路径 II
 */

// @lc code=start
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1 || obstacleGrid[0][0] == 1)
            return 0;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 1)
                break;
            dp[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    continue;
                int up = obstacleGrid[i - 1][j] == 1 ? 0 : dp[j];
                int left = (j == 0 || obstacleGrid[i][j - 1] == 1) ? 0 : dp[j - 1];
                dp[j] = up + left;
            }
        }

        return dp[n - 1];

    }
}
// @lc code=end
