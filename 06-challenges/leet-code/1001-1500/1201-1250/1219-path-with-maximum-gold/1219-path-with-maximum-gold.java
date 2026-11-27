// https://leetcode.com/problems/path-with-maximum-gold/

// Solution: DFS Backtracking — O(m*n*4^k) where k≤25 time, O(m*n) space
// Solution: DFS Backtracking — O(m*n*4^k) time, O(m*n) space
class Solution {
    public int getMaximumGold(int[][] grid) {
        int res = 0, m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) res = Math.max(res, dfs(grid, i, j, m, n));
            }
        }
        return res;
    }
    private int dfs(int[][] grid, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0) return 0;
        int gold = grid[i][j];
        grid[i][j] = 0;
        int best = gold + Math.max(Math.max(dfs(grid, i+1, j, m, n), dfs(grid, i-1, j, m, n)),
                                   Math.max(dfs(grid, i, j+1, m, n), dfs(grid, i, j-1, m, n)));
        grid[i][j] = gold;
        return best;
    }
}
