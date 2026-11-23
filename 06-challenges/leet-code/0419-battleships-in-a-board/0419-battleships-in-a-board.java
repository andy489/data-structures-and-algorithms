// https://leetcode.com/problems/battleships-in-a-board/

// Solution: One-Pass O(1) Space — O(m*n) time, O(1) space
class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[0].length; c++) {
                if (board[r][c] == 'X') {
                    boolean hasPrecedingAbove = r > 0 && board[r - 1][c] == 'X';
                    boolean hasPrecedingLeft = c > 0 && board[r][c - 1] == 'X';
                    if (!hasPrecedingAbove && !hasPrecedingLeft) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
}
