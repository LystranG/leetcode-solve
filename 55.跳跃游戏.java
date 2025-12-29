/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int cur = n - 1;
        for (int i = n - 2; i >= 0; i--) {
            if (cur - i <= nums[i]) {
                cur = i;
            }
        }
        return cur == 0;
    }
}
// @lc code=end
