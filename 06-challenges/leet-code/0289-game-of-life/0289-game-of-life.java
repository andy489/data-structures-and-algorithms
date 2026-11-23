// https://leetcode.com/problems/game-of-life/

// Solution: In-Place with Encoded States — O(m·n) time, O(1) space
class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 1, -1, 0, 1};
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int live = 0;
                for (int d = 0; d < 8; d++) {
                    int nr = r + dx[d], nc = c + dy[d];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && Math.abs(board[nr][nc]) == 1) {
                        live++;
                    }
                }
                if (board[r][c] == 1 && (live < 2 || live > 3)) {
                    board[r][c] = -1;
                } else if (board[r][c] == 0 && live == 3) {
                    board[r][c] = 2;
                }
            }
        }
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (board[r][c] == -1) {
                    board[r][c] = 0;
                } else if (board[r][c] == 2) {
                    board[r][c] = 1;
                }
            }
        }
    }
}
