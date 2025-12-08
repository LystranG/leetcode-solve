/*
 * @lc app=leetcode.cn id=36 lang=java
 *
 * [36] 有效的数独
 */

// @lc code=start
class Solution {
    public boolean isValidSudoku(char[][] board) {
        
        char[] rows = new char[9];
        char[] cols = new char[9];
        char[] boxes = new char[9];

        for (int i = 0;i <= 8;i++) {

            for (int j = 0;j <= 8;j++) {
                char cur = board[i][j];
                if (cur == '.') continue;
             
                int mask = 1 << (cur - '1');
                if (( rows[i] & mask ) == mask) return false;
                rows[i] |= mask;
                
                if (( cols[j] & mask ) == mask) return false;
                cols[j] |= mask;
                
                int boxIndex = i / 3 * 3 + j / 3;
                if (( boxes[boxIndex] & mask ) == mask) return false;
                boxes[boxIndex] |= mask;
            }

        }
        
        return true;

    }
}
// @lc code=end

