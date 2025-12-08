/*
 * @lc app=leetcode.cn id=290 lang=java
 *
 * [290] 单词规律
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean wordPattern(String pattern, String s) {
        
        int n = pattern.length();
        String[] strs = s.split(" ");

        if (strs.length != n) return false;

        String[] map = new String[26];
        Map<String, Integer> reverseMap = new HashMap<>();

        for (int i = 0;i < n;i++) {
            int c = pattern.charAt(i) - 'a';
            String cur = map[c];

            if (cur == null) {
                map[c] = strs[i];
                Integer pre = reverseMap.put(strs[i], c);
                if (pre != null && pre != c) {
                    return false;
                }
            } else if (!cur.equals(strs[i])) {
                return false;
            }
        }
        return true;
    }
    
    
}
// @lc code=end

