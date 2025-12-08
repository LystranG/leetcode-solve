/*
 * @lc app=leetcode.cn id=392 lang=java
 *
 * [392] 判断子序列
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    // public boolean isSubsequence(String s, String t) {
    //     int n1 = s.length(), n2 = t.length();
       
    //     if (n1 == 0) return true;
        
    //     int i = 0; 
    //     for (int j = 0;j < n2;j++) {
    //         if (t.charAt(j) == s.charAt(i)) {
    //             i++;
    //         }
    //         if (i >= n1) {
    //             return true;
    //         }
    //     }

    //     return false;
    // }

    public boolean isSubsequence(String s, String t) {
        int n1 = s.length(), n2 = t.length();

        if (n1 == 0) return true;

        int[][] dp = new int[n2 + 1][26];

        Arrays.fill(dp[n2], n2);

        for (int i = n2 - 1;i >= 0;i--) {
            int cur = t.charAt(i) - 'a';
            dp[i][cur] = i;
            for (int j = 0;j < 26;j++) {
                if (j == cur) continue;
                dp[i][j] = dp[i + 1][j];
            }
        }
       
        int pre = 0;
        for (int i = 0;i < n1;i++) {
            int next = dp[pre][s.charAt(i) - 'a'];
            if (next >= n2) return false;
            pre = next + 1;
        }

        return true;
    }
}
// @lc code=end

