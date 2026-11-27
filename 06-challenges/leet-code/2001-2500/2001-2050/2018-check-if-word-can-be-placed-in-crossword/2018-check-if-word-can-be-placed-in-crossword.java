// https://leetcode.com/problems/check-if-word-can-be-placed-in-crossword/

// Solution: Scan for Valid Runs — O(m*n*L) time, O(1) space
class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        int m = board.length, n = board[0].length, L = word.length();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c <= n - L; c++) {
                if ((c == 0 || board[r][c - 1] == '#') && (c + L == n || board[r][c + L] == '#')) {
                    if (fits(board, word, r, c, 0, 1)) { return true; }
                }
            }
        }
        for (int c = 0; c < n; c++) {
            for (int r = 0; r <= m - L; r++) {
                if ((r == 0 || board[r - 1][c] == '#') && (r + L == m || board[r + L][c] == '#')) {
                    if (fits(board, word, r, c, 1, 0)) { return true; }
                }
            }
        }
        return false;
    }
    private boolean fits(char[][] b, String w, int r, int c, int dr, int dc) {
        for (int i = 0; i < w.length(); i++) {
            char cell = b[r + i * dr][c + i * dc];
            if (cell != ' ' && cell != w.charAt(i)) {
                // try reversed
                boolean rev = true;
                for (int j = 0; j < w.length(); j++) {
                    char cell2 = b[r + j * dr][c + j * dc];
                    if (cell2 != ' ' && cell2 != w.charAt(w.length() - 1 - j)) { rev = false; break; }
                }
                return rev;
            }
        }
        return true;
    }
}
