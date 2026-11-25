// https://leetcode.com/problems/available-captures-for-rook/

// Solution: 4-Direction Scan — O(1) time, O(1) space
class Solution {
    public int numRookCaptures(char[][] board) {
        int rx = 0, ry = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 'R') { rx = i; ry = j; }
            }
        }
        int captures = 0;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        for (int[] d : dirs) {
            int r = rx, c = ry;
            while (r >= 0 && r < 8 && c >= 0 && c < 8) {
                if (board[r][c] == 'B') { break; }
                if (board[r][c] == 'p') { captures++; break; }
                r += d[0]; c += d[1];
            }
        }
        return captures;
    }
}
