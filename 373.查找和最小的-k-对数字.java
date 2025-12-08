/*
 * @lc app=leetcode.cn id=373 lang=java
 *
 * [373] 查找和最小的 K 对数字
 */

// @lc code=start

import java.util.Arrays;
import java.util.Queue;

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        int n1 = nums1.length, n2 = nums2.length;
        
        List<List<Integer>> ans = new ArrayList<>();
        
        Queue<int[]> q = new PriorityQueue<>(k, (a, b) ->
            nums1[a[0]] + nums2[a[1]] - nums1[b[0]] - nums2[b[1]]);
        
        for (int i = 0;i < Math.min(n1, k); i++) {
            q.offer(new int[]{i, 0});           
        }
        
        while (k-- > 0 && !q.isEmpty()) {
            int[] idx = q.poll();
            ans.add(Arrays.asList(nums1[idx[0]], nums2[idx[1]]));

            if (idx[1] < n2 - 1) {
                q.offer(new int[]{idx[0], idx[1] + 1 });
            }
        }
        
        return ans;
    
    }
}
// @lc code=end

