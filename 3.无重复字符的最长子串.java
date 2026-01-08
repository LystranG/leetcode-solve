/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start

import java.util.Map;

class Solution {
    public int lengthOfLongestSubstring(String s) {

        int n = s.length();
        if (n <= 1)
            return n;
        Map<Character, Integer> map = new HashMap<>();

        int left = 0, right = 1;
        int ans = 1;
        map.put(s.charAt(0), 0);
        while (right < n) {
            Integer existed = map.get(s.charAt(right));
            if (existed != null) {
                while (left <= existed) {
                    map.remove(s.charAt(left++));
                }
            }
            map.put(s.charAt(right), right);
            right++;

            ans = Math.max(ans, right - left);
        }

        return ans;
    }
}
// @lc code=end
