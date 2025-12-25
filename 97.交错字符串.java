/*
 * @lc app=leetcode.cn id=97 lang=java
 *
 * [97] 交错字符串
 */

// @lc code=start
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        int m = s1.length(), n = s2.length(), len = s3.length();
        if (m + n != len)
            return false;

        boolean[] dp = new boolean[n + 1];

        dp[0] = true;
        // for (int i = 1;i <= n;i++) {
        // dp[0][i] = s1.charAt(i - 1) == s3.charAt(i - 1);
        // if (!dp[0][i]) break;
        // }
        int row = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                int p = i + j - 1;
                if (i > 0) {
                    dp[j] = dp[j] && s3.charAt(p) == s1.charAt(i - 1);
                }
                if (j > 0) {
                    dp[j] = dp[j] || (dp[j - 1] && s3.charAt(p) == s2.charAt(j - 1));
                }

                // if (!dp[row][j]) continue;
            }
            row = 1 - row;
        }

        return dp[n];
    }
}
// @lc code=end
