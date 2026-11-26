// https://leetcode.com/problems/cherry-pickup-ii/

// Solution: 3D DP — O(rows * cols^2) time, O(rows * cols^2) space
class Solution {
    public int cherryPickup(int[][] grid) {
        int R = grid.length, C = grid[0].length;
        int[][][] dp = new int[R][C][C];
        for (int[][] row : dp) for (int[] arr : row) Arrays.fill(arr, -1);
        dp[0][0][C-1] = grid[0][0] + (C > 1 ? grid[0][C-1] : 0);
        for (int r = 0; r < R-1; r++)
            for (int c1 = 0; c1 < C; c1++)
                for (int c2 = 0; c2 < C; c2++) {
                    if (dp[r][c1][c2] < 0) continue;
                    for (int d1 = -1; d1 <= 1; d1++)
                        for (int d2 = -1; d2 <= 1; d2++) {
                            int nc1 = c1+d1, nc2 = c2+d2;
                            if (nc1<0||nc1>=C||nc2<0||nc2>=C) continue;
                            int cherries = grid[r+1][nc1] + (nc1 != nc2 ? grid[r+1][nc2] : 0);
                            dp[r+1][nc1][nc2] = Math.max(dp[r+1][nc1][nc2], dp[r][c1][c2] + cherries);
                        }
                }
        int ans = 0;
        for (int[] row : dp[R-1]) for (int v : row) ans = Math.max(ans, v);
        return ans;
    }
}
