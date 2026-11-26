// https://leetcode.com/problems/number-of-closed-islands/

// Solution: DFS Flood Fill — O(m*n) time, O(m*n) space
// Solution: DFS Flood Fill — O(m*n) time, O(m*n) space
class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        for (int i = 0; i < m; i++) { dfs(grid, i, 0, m, n); dfs(grid, i, n-1, m, n); }
        for (int j = 0; j < n; j++) { dfs(grid, 0, j, m, n); dfs(grid, m-1, j, m, n); }
        int count = 0;
        for (int i = 0; i < m; i++) for (int j = 0; j < n; j++) if (grid[i][j] == 0) { dfs(grid, i, j, m, n); count++; }
        return count;
    }
    private void dfs(int[][] g, int i, int j, int m, int n) {
        if (i < 0 || i >= m || j < 0 || j >= n || g[i][j] != 0) return;
        g[i][j] = 1;
        dfs(g, i+1, j, m, n); dfs(g, i-1, j, m, n); dfs(g, i, j+1, m, n); dfs(g, i, j-1, m, n);
    }
}
