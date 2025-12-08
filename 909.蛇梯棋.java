/*
 * @lc app=leetcode.cn id=909 lang=java
 *
 * [909] 蛇梯棋
 */

// @lc code=start

import java.util.Deque;

class Solution {
    public int snakesAndLadders(int[][] board) {
        
        int n = board.length, target = n * n;
        int[] dp = new int[target + 1];
        Deque<Integer> queue = new ArrayDeque<>();
        queue.offer(1);
        while (!queue.isEmpty()) {
            int cur = queue.poll();    
            int next = Math.min(target, cur + 6), nextPos = cur;
            
            for (int i = cur + 1;i <= next;i++) {
                int val = computeIndex(board, i, n);
                if (val != -1) {
                    if ( ( dp[val] == 0 || dp[val] > dp[cur] + 1 ) && val != 1 && val != i) {
                        dp[val] = dp[cur] + 1;
                        queue.offer(val);
                    }
                } else {
                    nextPos = i;   
                    if (dp[i] != 0) {
                        dp[i] = Math.min(dp[i], dp[cur] + 1);
                    } else dp[i] = dp[cur] + 1;
                }
            }
                
            if (nextPos == target) return dp[target];
            if (nextPos != cur)
                queue.offer(nextPos);
        }   
        
        return -1;
    }
    
    private int computeIndex(int[][] board,int num, int n) {

        int row = n - ((num - 1) / n) - 1;
        int col = (num - 1) % n;
        col = ( row & 1 ) == (n & 1) ? n - col - 1 : col;

        return board[row][col];
    }
}
// @lc code=end

