/*
 * @lc app=leetcode.cn id=12 lang=java
 *
 * [12] 整数转罗马数字
 */

// @lc code=start
class Solution {

    private static final char[] roman = new char[]{'D', 'C', 'L', 'X', 'V', 'I'};
    private static final int[] numGrade = new int[]{500, 100, 50, 10, 5, 1};

    public String intToRoman(int num) {
       
        StringBuilder sb = new StringBuilder();

        int cur = num / 1000;
        for (int i = 0;i < cur;i++) {
            sb.append('M');
        }
        num %= 1000;
        for (int i = 0;i < numGrade.length;i++) {
            cur = num / numGrade[i];
            num %= numGrade[i];
            if (cur == 1) {
                if (i < numGrade.length - 1 && num %)
            }

        }
    }
}
// @lc code=end

