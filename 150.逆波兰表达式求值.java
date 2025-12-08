/*
 * @lc app=leetcode.cn id=150 lang=java
 *
 * [150] 逆波兰表达式求值
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int evalRPN(String[] tokens) {

        int flag = 0, first, second;
        for (String s : tokens) {
            if (flag == 2) {

            }
        }

        // Deque<Integer> num = new ArrayDeque<>();
        //
        // for (String s : tokens) {
        // int cur;
        // if ("+".equals(s)) {
        // cur = num.pop() + num.pop();
        // } else if ("-".equals(s)) {
        // int i = num.pop();
        // cur = num.pop() - i;
        // } else if ("*".equals(s)) {
        // cur = num.pop() * num.pop();
        // } else if ("/".equals(s)) {
        // int i1 = num.pop();
        // cur = num.pop() / i1;
        // } else {
        // num.push(Integer.parseInt(s));
        // continue;
        // }
        // num.push(cur);
        // }
        //
        // return num.peek();
    }
}
// @lc code=end
