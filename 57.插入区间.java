/*
 * @lc app=leetcode.cn id=57 lang=java
 *
 * [57] 插入区间
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Test {
    public static void main(String[] args) {
        int[][] inter = new int[][]{ {1, 3}, {6, 9}};
        System.out.println(new Solution().insert(inter, new int[]{2, 5}));
    }
}

class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        
        int n = intervals.length;
        
        if (n == 0) return new int[][]{newInterval};
        
        List<int[]> ans = new ArrayList<>();
        
        int[] merge = new int[2];
        int index = 0;
        while (index < n && intervals[index][1] < newInterval[0]) {
            ans.add(intervals[index++]);
        }
        if (index == n) {
            ans.add(newInterval);
        } else {
            merge[0] = Math.min(intervals[index][0], newInterval[0]);
            while (index < n && intervals[index][1] < newInterval[1]) {
                index++;
            }
            
            if (index == n || intervals[index][0] > newInterval[1]) {
                merge[1] = newInterval[1];
            } else {
                merge[1] = intervals[index][1];
                index++;
            }
            ans.add(merge);
            
            for (;index < n;index++) {
                ans.add(intervals[index]);
            }
        }
        
        
        return ans.toArray(new int[ans.size()][2]);
        
    }
    
    
}
// @lc code=end

