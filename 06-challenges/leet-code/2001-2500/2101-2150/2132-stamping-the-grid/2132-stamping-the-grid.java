// https://leetcode.com/problems/stamping-the-grid/
class Solution {
    public boolean possibleToStamp(int[][] grid, int stampHeight, int stampWidth) {
        int m = grid.length, n = grid[0].length;
        // Build prefix sum of grid
        int[][] ps = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                ps[i][j] = grid[i-1][j-1] + ps[i-1][j] + ps[i][j-1] - ps[i-1][j-1];
            }
        }
        // Mark valid stamp placements
        int[][] stamps = new int[m + 1][n + 1];
        for (int i = 1; i + stampHeight - 1 <= m; i++) {
            for (int j = 1; j + stampWidth - 1 <= n; j++) {
                int r2 = i + stampHeight - 1, c2 = j + stampWidth - 1;
                int sum = ps[r2][c2] - ps[i-1][c2] - ps[r2][j-1] + ps[i-1][j-1];
                if (sum == 0) {
                    stamps[i][j]++;
                }
            }
        }
        // Build prefix sum of stamp placements
        int[][] sps = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                sps[i][j] = stamps[i][j] + sps[i-1][j] + sps[i][j-1] - sps[i-1][j-1];
            }
        }
        // Check every empty cell is covered
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (grid[i-1][j-1] == 0) {
                    int r1 = Math.max(1, i - stampHeight + 1);
                    int c1 = Math.max(1, j - stampWidth + 1);
                    int r2 = i, c2 = j;
                    int covered = sps[r2][c2] - sps[r1-1][c2] - sps[r2][c1-1] + sps[r1-1][c1-1];
                    if (covered == 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
