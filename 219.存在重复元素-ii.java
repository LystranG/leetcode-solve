/*
 * @lc app=leetcode.cn id=219 lang=java
 *
 * [219] 存在重复元素 II
 */

// @lc code=start

import java.util.Set;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        int n = nums.length;
        
        Set<Integer> set = new HashSet<>((int)( n / 0.75 ));
        int left = 0, right = Math.min(k, n - 1);
        for (int i = 0;i <= right;i++) {
            int cur = nums[i];
            if (set.contains(cur)) return true;
            set.add(cur);
        }
        
        while (right < n - 1) {
            set.remove(nums[left]);
            int cur = nums[++right];
            if (set.contains(cur)) {
                return true;
            }
            set.add(cur);
            left++;
        }

        return false;
    }
}// @lc code=end

