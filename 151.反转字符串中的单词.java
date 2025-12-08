/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 反转字符串中的单词
 */

// @lc code=start
class Solution {
   public String reverseWords(String s) {
      int n = s.length();

      int l = n - 1, r = n - 1;
      StringBuilder sb = new StringBuilder();
      while (l >= 0) {
         while (l >= 0 && s.charAt(l) == ' ') {
            l--;
         }
         if (l < 0)
            break;
         r = l;

         while (l >= 1 && s.charAt(l - 1) != ' ')
            l--;
         sb.append(' ');
         sb.append(s.substring(l, r + 1));
         l--;
      }

      return sb.toString().trim();
   }
}
// @lc code=end
