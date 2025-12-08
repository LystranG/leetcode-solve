/*
 * @lc app=leetcode.cn id=6 lang=java
 *
 * [6] Z 字形变换
 */

// @lc code=start
class Solution {
   public String convert(String s, int numRows) {
      if (numRows < 2)
         return s;

      List<StringBuilder> rows = new ArrayList<>();

      for (int i = 0; i < numRows; i++)
         rows.add(new StringBuilder());

      int i = 0, flag = -1;

      for (char c : s.toCharArray()) {

         rows.get(i).append(c);

         if (i == 0 || i == numRows - 1)
            flag = -flag;

         i += flag;

      }

      StringBuilder res = new StringBuilder();

      for (StringBuilder row : rows)
         res.append(row);

      return res.toString();

      // int n = s.length();
      // int gap = Math.max(0, numRows - 2), gapNum = numRows + gap;
      // int len = ( n / gapNum) * (gap + 1);
      // int tmp = n % gapNum;
      // if (tmp != 0) {
      // len += Math.max(1, tmp - numRows + 1);
      // }
      //
      // int cur = 0;
      // StringBuilder sb = new StringBuilder();
      //
      // loop:
      // for (int i = 0;i < numRows;i++) {
      // for (int j = 0;j < len;j++) {
      // if (cur >= n) break loop;
      // if ()
      //
      // int sub = j % (gap + 1);
      // int pos = (j / (gap + 1) * gapNum) + i;
      //
      // }
      // }

   }
}
// @lc code=end
