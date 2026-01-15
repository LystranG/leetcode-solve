/*
 * @lc app=leetcode.cn id=238 lang=java
 *
 * [238] 除自身以外数组的乘积
 */

// @lc code=start
class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] ans = new int[n];

        int prefix = 1;
        for (int i = 0; i < n - 1; i++) {
            prefix *= nums[i];
            ans[i] = prefix;
        }

        int suffix = 1;
        for (int i = n - 1; i > 0; i--) {
            ans[i] = ans[i - 1] * suffix;
            suffix *= nums[i];
        }
        ans[0] = suffix;

        return ans;

    }
}
// @lc code=end
