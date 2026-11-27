// https://leetcode.com/problems/sudoku-solver/

// Solution: Backtracking with bitmask constraint sets — O(1) time, O(1) space
class Solution {
    private int[] rows = new int[9], cols = new int[9], boxes = new int[9];

    public void solveSudoku(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                if (board[r][c] != '.') {
                    int bit = 1 << (board[r][c] - '0');
                    rows[r] |= bit;
                    cols[c] |= bit;
                    boxes[(r / 3) * 3 + (c / 3)] |= bit;
                }
            }
        }
        solve(board, 0);
    }

    private boolean solve(char[][] board, int pos) {
        if (pos == 81) {
            return true;
        }
        int r = pos / 9, c = pos % 9;
        if (board[r][c] != '.') {
            return solve(board, pos + 1);
        }
        int box = (r / 3) * 3 + (c / 3);
        for (int d = 1; d <= 9; d++) {
            int bit = 1 << d;
            if ((rows[r] & bit) != 0 || (cols[c] & bit) != 0 || (boxes[box] & bit) != 0) {
                continue;
            }
            board[r][c] = (char) ('0' + d);
            rows[r] |= bit;
            cols[c] |= bit;
            boxes[box] |= bit;
            if (solve(board, pos + 1)) {
                return true;
            }
            board[r][c] = '.';
            rows[r] ^= bit;
            cols[c] ^= bit;
            boxes[box] ^= bit;
        }
        return false;
    }
}

// Solution2: Backtracking without bitmasks — O(1) time, O(1) space
class Solution2 {
    public void solveSudoku(char[][] board) {
        solve(board, 0);
    }

    private boolean solve(char[][] board, int pos) {
        if (pos == 81) {
            return true;
        }
        int r = pos / 9, c = pos % 9;
        if (board[r][c] != '.') {
            return solve(board, pos + 1);
        }
        for (char d = '1'; d <= '9'; d++) {
            if (!isValid(board, r, c, d)) {
                continue;
            }
            board[r][c] = d;
            if (solve(board, pos + 1)) {
                return true;
            }
            board[r][c] = '.';
        }
        return false;
    }

    private boolean isValid(char[][] board, int r, int c, char d) {
        for (int i = 0; i < 9; i++) {
            if (board[r][i] == d || board[i][c] == d) {
                return false;
            }
            int br = (r / 3) * 3 + i / 3;
            int bc = (c / 3) * 3 + i % 3;
            if (board[br][bc] == d) {
                return false;
            }
        }
        return true;
    }
}
