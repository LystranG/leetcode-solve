/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start

import java.util.ArrayList;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> results = new ArrayList<>();

        Map<String, List<String>> wordMap = new HashMap<>();

        for (String str : strs) {
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String sorted = new String(cs);
            wordMap.compute(sorted, (key, value) -> {
                List<String> list = value == null ? new ArrayList<>() : value;
                list.add(str);
                return list;
            });
        }

        for (List<String> result : wordMap.values()) {
            results.add(result);
        }

        return results;
    }
}
// @lc code=end
