// https://leetcode.com/problems/score-after-flipping-matrix/

// Solution: Greedy — O(m*n) time, O(1) space
class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int r = 0; r < m; r++) {
            if (grid[r][0] == 0) {
                for (int c = 0; c < n; c++) {
                    grid[r][c] ^= 1;
                }
            }
        }
        int score = 0;
        for (int c = 0; c < n; c++) {
            int ones = 0;
            for (int r = 0; r < m; r++) {
                ones += grid[r][c];
            }
            score += Math.max(ones, m - ones) * (1 << (n - 1 - c));
        }
        return score;
    }
}
