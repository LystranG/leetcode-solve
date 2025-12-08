/*
 * @lc app=leetcode.cn id=289 lang=java
 *
 * [289] 生命游戏
 */

// @lc code=start
class Solution {
    public void gameOfLife(int[][] board) {
        
        int m  = board.length, n = board[0].length;
        // 0->1 2, 1->0 3
        
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {

                int around = compute(i, j, board, m, n);
                if (board[i][j] == 1) {
                    if (around <= 1 || around > 3) {
                        board[i][j] = 3;
                    } 
                } else if (board[i][j] == 0) {
                    if (around == 3) board[i][j] = 2;
                }

            }
        }
        
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                } else if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }

    }
    
    private int compute(int i, int j, int[][] board, int m, int n) {

        int cnt = 0;
        for (int a = Math.max(0, i - 1); a <= Math.min(m - 1, i + 1);a++) {
            for (int b = Math.max(0, j - 1); b <= Math.min(n - 1, j + 1);b++) {
                if (board[a][b] == 1 || board[a][b] == 3) cnt++;                
            }
        }
        
        return cnt - (board[i][j] == 1 || board[i][j] == 3 ? 1 : 0);
    }
}
// @lc code=end

