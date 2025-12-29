/*
 * @lc app=leetcode.cn id=15 lang=java
 *
 * [15] 三数之和
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            if (i > 0 && nums[i - 1] == nums[i])
                continue;

            int left = i + 1, right = n - 1, target = -nums[i];
            while (left < right) {
                int cal = nums[left] + nums[right];
                if (cal == target) {
                    ans.add(List.of(nums[i], nums[left], nums[right]));
                    left++;
                    right--;
                    while (left < right && nums[right] == nums[right + 1])
                        right--;
                    while (left < right && nums[left] == nums[left - 1])
                        left++;
                } else if (cal > target) {
                    right--;
                } else
                    left++;

            }

        }

        return ans;
    }
}
// @lc code=end
