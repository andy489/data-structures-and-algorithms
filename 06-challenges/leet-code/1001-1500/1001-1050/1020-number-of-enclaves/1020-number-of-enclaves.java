// https://leetcode.com/problems/number-of-enclaves/

// Solution: BFS/DFS from Border — O(m·n) time, O(m·n) space
class Solution {
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            flood(grid, i, 0, m, n);
            flood(grid, i, n - 1, m, n);
        }
        for (int j = 0; j < n; j++) {
            flood(grid, 0, j, m, n);
            flood(grid, m - 1, j, m, n);
        }
        int count = 0;
        for (int[] row : grid) {
            for (int cell : row) {
                count += cell;
            }
        }
        return count;
    }

    private void flood(int[][] grid, int r, int c, int m, int n) {
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] != 1) {
            return;
        }
        grid[r][c] = 0;
        flood(grid, r + 1, c, m, n);
        flood(grid, r - 1, c, m, n);
        flood(grid, r, c + 1, m, n);
        flood(grid, r, c - 1, m, n);
    }
}
