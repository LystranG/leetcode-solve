/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {

        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[2][n];
        int row = 0, ans = 0;

        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == '1') {
                dp[0][i] = 1;
                ans = 1;
            }
        }
        for (int i = 1; i < m; i++) {
            row = 1 - row;
            dp[row][0] = matrix[i][0] - '0';
            ans = Math.max(ans, dp[row][0]);
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == '1') {
                    int x = dp[row][j - 1];
                    int y = dp[1 - row][j];
                    int cor = dp[1 - row][j - 1];
                    dp[row][j] = Math.min(x, Math.min(y, cor)) + 1;
                    ans = Math.max(ans, dp[row][j]);
                } else
                    dp[row][j] = 0;
            }
        }

        return ans * ans;
    }
}
// @lc code=end
