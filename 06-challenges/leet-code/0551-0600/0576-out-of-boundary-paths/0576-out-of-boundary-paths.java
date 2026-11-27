class Solution {
    private static final int MOD = 1_000_000_007;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][] dp = new int[m][n];
        dp[startRow][startColumn] = 1;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        long ans = 0;
        for (int move = 0; move < maxMove; move++) {
            int[][] next = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (dp[i][j] == 0) {
                        continue;
                    }
                    for (int[] d : dirs) {
                        int ni = i + d[0], nj = j + d[1];
                        if (ni < 0 || ni >= m || nj < 0 || nj >= n) {
                            ans = (ans + dp[i][j]) % MOD;
                        } else {
                            next[ni][nj] = (int) ((next[ni][nj] + dp[i][j]) % MOD);
                        }
                    }
                }
            }
            dp = next;
        }
        return (int) ans;
    }
}
