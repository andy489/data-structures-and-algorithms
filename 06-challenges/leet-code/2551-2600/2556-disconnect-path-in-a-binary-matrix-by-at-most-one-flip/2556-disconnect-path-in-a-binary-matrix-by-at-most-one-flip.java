// https://leetcode.com/problems/disconnect-path-in-a-binary-matrix-by-at-most-one-flip/

// Solution: Two DFS Passes — O(m*n) time, O(m*n) space
class Solution {
    public boolean isPossibleToCutPath(int[][] grid) {
        if (!dfs(grid, 0, 0)) {
            return true;
        }
        grid[0][0] = 1;
        int m = grid.length, n = grid[0].length;
        grid[m - 1][n - 1] = 1;
        return !dfs(grid, 0, 0);
    }

    private boolean dfs(int[][] grid, int r, int c) {
        int m = grid.length, n = grid[0].length;
        if (r == m - 1 && c == n - 1) {
            return true;
        }
        if (r >= m || c >= n || grid[r][c] == 0) {
            return false;
        }
        grid[r][c] = 0;
        return dfs(grid, r + 1, c) || dfs(grid, r, c + 1);
    }
}
