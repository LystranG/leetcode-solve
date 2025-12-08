/*
 * @lc app=leetcode.cn id=918 lang=java
 *
 * [918] 环形子数组的最大和
 */

// @lc code=start
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        
        int n = nums.length;

        int sum = nums[0], maxSum = sum, maxCur = sum, minSum = sum, minCur = sum;
        for (int i = 1;i < n;i++) {

            sum += nums[i];
            maxCur = Math.max(nums[i], maxCur + nums[i]);
            minCur = Math.min(nums[i], minCur + nums[i]);
            maxSum = Math.max(maxCur, maxSum);
            minSum = Math.min(minCur, minSum);
        }
        
        if (maxSum < 0) return maxSum;
        return Math.max(maxSum, sum - minSum);
    }
}
// @lc code=end

