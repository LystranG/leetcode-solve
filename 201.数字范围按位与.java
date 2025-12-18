/*
 * @lc app=leetcode.cn id=201 lang=java
 *
 * [201] 数字范围按位与
 */

// @lc code=start

class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int len = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            len++;
        }

        return left << len;
    }
}

// class Solution {
// public int rangeBitwiseAnd(int left, int right) {
// while (left < right) {
// right &= right - 1;
// }
// return right;
// }
// }
// @lc code=end
