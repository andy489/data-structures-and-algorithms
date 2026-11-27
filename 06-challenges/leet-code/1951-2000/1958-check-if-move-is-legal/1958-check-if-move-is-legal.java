// https://leetcode.com/problems/check-if-move-is-legal/
class Solution {
    public boolean checkMove(char[][] board, int rMove, int cMove, char color) {
        board[rMove][cMove] = color;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0},{1,1},{1,-1},{-1,1},{-1,-1}};
        for (int[] dir : dirs) {
            if (isGoodLine(board, rMove, cMove, color, dir[0], dir[1])) {
                return true;
            }
        }
        return false;
    }

    private boolean isGoodLine(char[][] board, int r, int c, char color, int dr, int dc) {
        char opposite = (color == 'W') ? 'B' : 'W';
        int count = 0;
        r += dr;
        c += dc;
        while (r >= 0 && r < 8 && c >= 0 && c < 8) {
            if (board[r][c] == opposite) {
                count++;
            } else if (board[r][c] == color) {
                return count >= 1;
            } else {
                return false;
            }
            r += dr;
            c += dc;
        }
        return false;
    }
}
