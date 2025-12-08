/*
 * @lc app=leetcode.cn id=452 lang=java
 *
 * [452] 用最少数量的箭引爆气球
 */

// @lc code=start
class Solution {
    public int findMinArrowShots(int[][] points) {
        
        int n = points.length;
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));

        int ans = 1, bound = points[0][1];
        for (int i = 1;i < n;i++) {
            if (points[i][0] > bound) {
                ans++;
                bound = points[i][1];
            }
        } 
        
        return ans;
    }
}
// @lc code=end

