/*
 * @lc app=leetcode.cn id=162 lang=java
 *
 * [162] 寻找峰值
 */

// @lc code=start
class Solution {
    public int findPeakElement(int[] nums) {
        
        int n = nums.length;
        int left = 0, right = n - 1;
        
        while (left <= right) {

            int mid = (left + right) / 2;

            int cur = nums[mid];
            boolean isLeftSmaller = mid == 0 || nums[mid - 1] < cur;
            boolean isRightSmaller = mid == n - 1 || nums[mid + 1] < cur;
            
            if (isLeftSmaller && isRightSmaller) {
                return mid;
            } else if (isLeftSmaller) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1;
    }

}
// @lc code=end

