/*
 * @lc app=leetcode.cn id=128 lang=java
 *
 * [128] 最长连续序列
 */

// @lc code=start

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {

        int n = nums.length;
        if (n == 0)
            return 0;

        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }

        int ans = 1;
        for (int num : set) {
            if (!set.contains(num - 1)) {

                int len = 1, tmp = num;
                while (set.contains(tmp++ + 1)) {
                    len++;
                }

                ans = Math.max(ans, len);
            }
        }

        return ans;
    }
}
// @lc code=end
