/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(n, k, 1, 0, new Integer[k], ans);
        
        return ans;
    }
    
    private void backtrack(int n, int k, int curNum, int len, Integer[] cur, List<List<Integer>> ans) {

        if (len == k) {
            Integer[] copy = new Integer[k];
            System.arraycopy(cur, 0, copy, 0, k);
            ans.add(Arrays.asList(copy));
            return;
        }
        
        for (int i = curNum;i <= n;i++) {
            cur[len] = i;
            backtrack(n, k, i + 1, len + 1, cur, ans);
        }

    }
}
// @lc code=end

