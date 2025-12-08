/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start
class Solution {
    
    public void solve(char[][] board) {
        
        int m = board.length, n = board[0].length;
        
        for (int i = 0;i < m;i++) {
            if (i == 0 || i == m - 1) {
                for (int j = 0;j < n;j++) {
                    dfsSurveyEdge(board, m, n, i, j);
                }
            } else {
                dfsSurveyEdge(board, m, n, i, 0);
                dfsSurveyEdge(board, m, n, i, n - 1);
            }
        }
        
        for (int i = 0;i < m;i++) {
            for (int j = 0;j < n;j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }
    
    private void dfsSurveyEdge(char[][] board, int m, int n, int row, int col) {

        if (row < 0 || row >= m || col < 0 || col >= n ) return;

        if (board[row][col] == 'O') {
            board[row][col] = 'A';
            dfsSurveyEdge(board, m, n, row - 1, col);
            dfsSurveyEdge(board, m, n, row + 1, col);
            dfsSurveyEdge(board, m, n, row, col - 1);
            dfsSurveyEdge(board, m, n, row, col + 1);
        }
    }
    
}
// @lc code=end

