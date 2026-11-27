// https://leetcode.com/problems/valid-tic-tac-toe-state/

// Solution: Case Analysis — O(1) time, O(1) space
class Solution {
    public boolean validTicTacToe(String[] board) {
        int xCount = 0, oCount = 0;
        for (String row : board) {
            for (char c : row.toCharArray()) {
                if (c == 'X') {
                    xCount++;
                } else if (c == 'O') {
                    oCount++;
                }
            }
        }
        if (oCount > xCount || xCount > oCount + 1) {
            return false;
        }
        boolean xWins = wins(board, 'X');
        boolean oWins = wins(board, 'O');
        if (xWins && oWins) {
            return false;
        }
        if (xWins && xCount != oCount + 1) {
            return false;
        }
        if (oWins && xCount != oCount) {
            return false;
        }
        return true;
    }

    private boolean wins(String[] board, char c) {
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == c && board[i].charAt(1) == c && board[i].charAt(2) == c) {
                return true;
            }
            if (board[0].charAt(i) == c && board[1].charAt(i) == c && board[2].charAt(i) == c) {
                return true;
            }
        }
        return (board[0].charAt(0) == c && board[1].charAt(1) == c && board[2].charAt(2) == c) ||
               (board[0].charAt(2) == c && board[1].charAt(1) == c && board[2].charAt(0) == c);
    }
}
