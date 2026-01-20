/*
 * @lc app=leetcode.cn id=56 lang=java
 *
 * [56] 合并区间
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {

        int n = intervals.length;
        if (n <= 1)
            return intervals;

        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int left = intervals[0][0], right = intervals[0][1];
        for (int i = 1; i < n; i++) {
            if (right >= intervals[i][0]) {
                right = Math.max(right, intervals[i][1]);
            } else {
                ans.add(new int[] { left, right });
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        ans.add(new int[] { left, right });

        return ans.toArray(new int[ans.size()][]);

    }
}
// @lc code=end
