/*
 * @lc app=leetcode.cn id=274 lang=java
 *
 * [274] H 指数
 */

// @lc code=start
class Solution {
    // public int hIndex(int[] citations) {
    //
    //     int n = citations.length;
    //
    //     Arrays.sort(citations);
    //
    //     int h = 0, i = n - 1;
    //     while (i >=0 && citations[i] > h) {
    //         h++;
    //         i--;
    //     }
    //
    //     return h;
    // }
    
    public int hIndex(int[] citations) {
        
        int n = citations.length;
      
        int[] counter = new int[n + 1];
        int cnt = 0;

        for (int i = 0;i < n;i++) {
            if (citations[i] >= n) {
                counter[n]++;
            } else {
                counter[citations[i]]++;
            }
        }
        
        for (int i = n;i >= 0;i--) {
            cnt += counter[i];
            if (cnt >= i) {
                return i;
            }
        }
        
        return 0;
    }
}
// @lc code=end

