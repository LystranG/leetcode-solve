/*
 * @lc app=leetcode.cn id=202 lang=java
 *
 * [202] 快乐数
 */

// @lc code=start


class Solution {
    public boolean isHappy(int n) {
        
        int slow = n, fast = getNext(n);
        while (slow != fast) {
            if (fast == 1) return true;
            slow = getNext(slow);
            fast = getNext(getNext(fast));
        }
        
        return fast == 1;

    }
    
    private int getNext(int n) {
        
        int sum = 0;
        while (n != 0) {
            int c = n % 10;
            sum += c * c;
            n /= 10;
        }

        return sum;
    }


}
// @lc code=end

