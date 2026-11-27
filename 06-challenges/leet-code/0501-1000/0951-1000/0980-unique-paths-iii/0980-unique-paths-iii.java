// https://leetcode.com/problems/unique-paths-iii/

// Solution: DFS Backtracking — O(4^(m*n)) time, O(m*n) space
class Solution {
    private int ans = 0, total = 0;
    private int[][] grid;
    private int m, n;

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        m = grid.length;
        n = grid[0].length;
        int sr = 0, sc = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != -1) { total++; }
                if (grid[i][j] == 1) { sr = i; sc = j; }
            }
        }
        dfs(sr, sc, 0);
        return ans;
    }

    private void dfs(int r, int c, int visited) {
        if (grid[r][c] == 2) {
            if (visited == total - 1) { ans++; }
            return;
        }
        int orig = grid[r][c];
        grid[r][c] = -1;
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        for (int[] d : dirs) {
            int nr = r + d[0], nc = c + d[1];
            if (nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] != -1) {
                dfs(nr, nc, visited + 1);
            }
        }
        grid[r][c] = orig;
    }
}
