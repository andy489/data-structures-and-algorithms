// https://leetcode.com/problems/regions-cut-by-slashes/

// Solution: Scale Up Grid + BFS — O(n²) time, O(n²) space
class Solution {
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int[][] g = new int[n * 3][n * 3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                char c = grid[i].charAt(j);
                if (c == '/') {
                    g[i * 3][j * 3 + 2] = 1;
                    g[i * 3 + 1][j * 3 + 1] = 1;
                    g[i * 3 + 2][j * 3] = 1;
                } else if (c == '\\') {
                    g[i * 3][j * 3] = 1;
                    g[i * 3 + 1][j * 3 + 1] = 1;
                    g[i * 3 + 2][j * 3 + 2] = 1;
                }
            }
        }
        int regions = 0;
        for (int i = 0; i < n * 3; i++) {
            for (int j = 0; j < n * 3; j++) {
                if (g[i][j] == 0) {
                    dfs(g, i, j, n * 3);
                    regions++;
                }
            }
        }
        return regions;
    }

    private void dfs(int[][] g, int r, int c, int size) {
        if (r < 0 || r >= size || c < 0 || c >= size || g[r][c] != 0) { return; }
        g[r][c] = 1;
        dfs(g, r + 1, c, size);
        dfs(g, r - 1, c, size);
        dfs(g, r, c + 1, size);
        dfs(g, r, c - 1, size);
    }
}
