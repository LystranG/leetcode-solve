/*
 * @lc app=leetcode.cn id=189 lang=java
 *
 * [189] 轮转数组
 */

// @lc code=start
class Solution {
    public void rotate(int[] nums, int k) {

        int n = nums.length;
        k %= n;
        reverse(nums, n, 0, n - 1);
        reverse(nums, n, 0, k - 1);
        reverse(nums, n, k, n - 1);

    }

    private void reverse(int[] nums, int n, int left, int right) {
        while (left < right) {
            int tmp = nums[left];
            nums[left] = nums[right];
            nums[right] = tmp;
            left++;
            right--;
        }
    }
}
// @lc code=end
