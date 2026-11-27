// https://leetcode.com/problems/string-compression-ii/

// Solution: DP with Run-Length Encoding — O(n^2 * k) time, O(n^2 * k) space
class Solution {
    public int getLengthOfOptimalCompression(String s, int k) {
        int n = s.length();
        int[][] dp = new int[n + 1][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE / 2);
        }
        dp[0][0] = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                // delete s[i-1]
                if (j > 0) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1]);
                }
                // keep s[i-1], extend run from some previous position
                int same = 0, diff = 0;
                for (int l = i; l >= 1; l--) {
                    if (s.charAt(l - 1) == s.charAt(i - 1)) {
                        same++;
                    } else {
                        diff++;
                    }
                    if (j >= diff) {
                        dp[i][j] = Math.min(dp[i][j],
                            dp[l - 1][j - diff] + runLength(same));
                    }
                }
            }
        }
        return dp[n][k];
    }

    private int runLength(int count) {
        if (count == 1) {
            return 1;
        }
        if (count < 10) {
            return 2;
        }
        if (count < 100) {
            return 3;
        }
        return 4;
    }
}
