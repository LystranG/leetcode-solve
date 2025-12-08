/*
 * @lc app=leetcode.cn id=80 lang=java
 *
 * [80] 删除有序数组中的重复项 II
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {

        int n = nums.length;
        int i = 2, j = 2;
        
        while (j < n) {
            if (nums[j] != nums[i - 2]) {
                nums[i] = nums[j];
                i++;
            }
            j++;
        }

        return i;
    }
}
// @lc code=end

