/*
 * @lc app=leetcode.cn id=120 lang=java
 *
 * [120] 三角形最小路径和
 */

// @lc code=start

import java.util.List;

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        int n = triangle.size();
        
        if (n == 1) return triangle.get(0).get(0);
        int[][] dp = new int[2][n];
        dp[0][0] = triangle.get(0).get(0);
        
        int ans = Integer.MAX_VALUE;
        for (int i = 1;i < n;i++) {
            int row = i & 1;
            dp[row][0] = dp[1 - row][0] + triangle.get(i).get(0);
            dp[row][i] = dp[1 - row][i - 1] + triangle.get(i).get(i);
            if (i == n - 1) ans = Math.min(dp[row][0], dp[row][i]);
            for (int j = 1;j < i;j++) {
                dp[row][j] = Math.min(dp[1 - row][j - 1], dp[1 - row][j]) + triangle.get(i).get(j);
                if (i == n - 1) {
                    ans = Math.min(ans, dp[row][j]);
                }
            }
        }
        
        return ans;
        
    }
}
// @lc code=end

