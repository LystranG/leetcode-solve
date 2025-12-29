/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {

        int n = height.length;
        int left = 0, right = n - 1;
        int ans = calculateVolume(height, 0, n - 1);

        while (left < right) {
            if (height[left] >= height[right]) {
                right--;
            } else
                left++;
            ans = Math.max(ans, calculateVolume(height, left, right));
        }

        return ans;
    }

    private int calculateVolume(int[] height, int left, int right) {
        return (right - left) * Math.min(height[left], height[right]);
    }
}
// @lc code=end
