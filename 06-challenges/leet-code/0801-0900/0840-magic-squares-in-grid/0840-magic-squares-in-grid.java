// https://leetcode.com/problems/magic-squares-in-grid/

// Solution: Brute Force Check — O(rows·cols) time, O(1) space
class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int rows = grid.length, cols = grid[0].length, count = 0;
        for (int r = 0; r <= rows - 3; r++) {
            for (int c = 0; c <= cols - 3; c++) {
                if (isMagic(grid, r, c)) {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isMagic(int[][] g, int r, int c) {
        boolean[] seen = new boolean[10];
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                int v = g[i][j];
                if (v < 1 || v > 9 || seen[v]) {
                    return false;
                }
                seen[v] = true;
            }
        }
        for (int i = r; i < r + 3; i++) {
            if (g[i][c] + g[i][c+1] + g[i][c+2] != 15) {
                return false;
            }
        }
        for (int j = c; j < c + 3; j++) {
            if (g[r][j] + g[r+1][j] + g[r+2][j] != 15) {
                return false;
            }
        }
        if (g[r][c] + g[r+1][c+1] + g[r+2][c+2] != 15) {
            return false;
        }
        if (g[r][c+2] + g[r+1][c+1] + g[r+2][c] != 15) {
            return false;
        }
        return true;
    }
}
