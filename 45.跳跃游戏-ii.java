/*
 * @lc app=leetcode.cn id=45 lang=java
 *
 * [45] 跳跃游戏 II
 */

// @lc code=start
class Solution {
    public int jump(int[] nums) {

        int n = nums.length;
        if (n == 1)
            return 0;

        int dis = 0, max = 0, ans = 0;
        for (int i = 0; i < n; i++) {
            if (i > dis) {
                dis = max;
                ans++;
            }
            max = Math.max(max, i + nums[i]);

            if (max >= n - 1) {
                ans++;
                break;
            }

        }

        return ans;

    }
}
// @lc code=end
