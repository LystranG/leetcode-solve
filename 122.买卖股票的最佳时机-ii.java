/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

// @lc code=start
class Solyaiution {
    // public int maxProfit(int[] prices) {
    //
    //     int n = prices.length;
    //     int dp0 = 0, dp1 = -prices[0];
    //
    //     for (int i = 1;i < n;i++) {
    //         int tdp0 = dp0;
    //         dp0 = Math.max(dp0, dp1 + prices[i]);
    //         dp1 = Math.max(dp1, tdp0 - prices[i]);
    //     }
    //
    //     return Math.max(dp0, dp1);
    //
    // }
    
    public int maxProfit(int[] prices) {
        
        int n = prices.length;
        int ans = 0;
      
        for (int i = 1;i < n;i++) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }
        
        return ans;
    }   
}
// @lc code=end

