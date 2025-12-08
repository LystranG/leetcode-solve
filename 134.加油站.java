/*
 * @lc app=leetcode.cn id=134 lang=java
 *
 * [134] 加油站
 */

// @lc code=start
class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        
        int n = gas.length;

        int start = 0, cur = 0, preMin = 0;
        for (int i = 0;i < n;i++) {
            cur += ( gas[i] - cost[i] );
            if (cur < 0) {
                preMin -= cur;
                cur = 0;
                start = i + 1;
            }
        }
        
        if (start < n && cur - preMin >= 0) {
            return start;
        } else return -1;
    }
}
// @lc code=end

