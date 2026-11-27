// https://leetcode.com/problems/minimum-white-tiles-after-covering-with-carpets/
class Solution {
    public int minimumWhiteTiles(String floor, int numCarpets, int carpetLen) {
        int n = floor.length();
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + (floor.charAt(i) == '1' ? 1 : 0);
        }
        // dp[i][j] = min white tiles visible in first i tiles using j carpets
        int[][] dp = new int[n + 1][numCarpets + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }
        for (int j = 0; j <= numCarpets; j++) {
            dp[0][j] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= numCarpets; j++) {
                // Don't use carpet at position i
                dp[i][j] = dp[i - 1][j] + (floor.charAt(i - 1) == '1' ? 1 : 0);
                // Use carpet ending at position i (covering i-carpetLen to i-1, 0-indexed)
                if (j > 0) {
                    int start = Math.max(0, i - carpetLen);
                    dp[i][j] = Math.min(dp[i][j], dp[start][j - 1]);
                }
            }
        }
        return dp[n][numCarpets];
    }
}
