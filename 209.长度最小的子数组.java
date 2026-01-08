/*
 * @lc app=leetcode.cn id=209 lang=java
 *
 * [209] 长度最小的子数组
 */

// @lc code=start
class Solution {
    public int minSubArrayLen(int target, int[] nums) {

        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        int sum = 0, left = 0, right = 0;
        while (right < n) {
            sum += nums[right++];
            while (sum >= target) {
                ans = Math.min(ans, right - left);
                sum -= nums[left++];
            }
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

}
// @lc code=end
