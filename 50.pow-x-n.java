/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    private double quickMul(double x, long N) {
        double ans = 1.0;
        double m = x;
        while (N > 0) {
            if (N % 2 == 1) {
                ans *= m;
            }
            m *= m;
            N /= 2;
        }

        return ans;
    }

}
// @lc code=end
