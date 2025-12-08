/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String simplifyPath(String path) {

        StringBuilder sb = new StringBuilder();
        String[] split = path.split("/");
        
        Deque<String> stack = new ArrayDeque<>();
        for (String s : split) {
            if (s.isEmpty() || ".".equals(s)) continue;
            if ("..".equals(s)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                } 
            } else {
                stack.push(s);
            }
        }
        
        while (!stack.isEmpty()) {
            sb.append('/');
            sb.append(stack.pollLast());
        }
        
        return sb.isEmpty() ? "/" : sb.toString();
    }
}
// @lc code=end

