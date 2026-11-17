// https://leetcode.com/problems/minimum-changes-to-make-k-semi-palindromes/

// Solution 1: DP with Precomputed Semi-palindrome Costs — O(n³) time, O(n²) space
class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];
        for (int[] row : cost) Arrays.fill(row, Integer.MAX_VALUE / 2);

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int len = j - i + 1;
                cost[i][j] = Integer.MAX_VALUE;
                for (int d = 1; d < len; d++) {
                    if (len % d != 0) continue;
                    int changes = 0;
                    for (int g = 0; g < d; g++) {
                        int lo = i + g, hi = j - (d - 1 - g);
                        while (lo < hi) {
                            if (s.charAt(lo) != s.charAt(hi)) changes++;
                            lo += d;
                            hi -= d;
                        }
                    }
                    cost[i][j] = Math.min(cost[i][j], changes);
                }
            }
        }

        int[][] dp = new int[n + 1][k + 1];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE / 2);
        dp[0][0] = 0;

        for (int p = 1; p <= k; p++) {
            for (int i = p; i <= n - (k - p); i++) {
                for (int j = p - 1; j < i; j++) {
                    if (dp[j][p - 1] < Integer.MAX_VALUE / 2) {
                        dp[i][p] = Math.min(dp[i][p], dp[j][p - 1] + cost[j][i - 1]);
                    }
                }
            }
        }

        return dp[n][k];
    }
}

// Solution 2: DP with Inline Cost Computation — O(n³) time, O(n²) space
class Solution2 {
    private char[] c;

    private int semiCost(int i, int j) {
        int len = j - i + 1, best = Integer.MAX_VALUE / 2;
        for (int d = 1; d < len; d++) {
            if (len % d != 0) continue;
            int changes = 0;
            for (int g = 0; g < d; g++) {
                int lo = i + g, hi = j - (d - 1 - g);
                while (lo < hi) {
                    if (c[lo] != c[hi]) changes++;
                    lo += d;
                    hi -= d;
                }
            }
            best = Math.min(best, changes);
        }
        return best;
    }

    public int minimumChanges(String s, int k) {
        c = s.toCharArray();
        int n = c.length;
        int[][] dp = new int[k + 1][n + 1];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE / 2);
        dp[0][0] = 0;

        for (int p = 1; p <= k; p++) {
            for (int i = p; i <= n - (k - p); i++) {
                for (int j = p - 1; j < i; j++) {
                    if (dp[p - 1][j] < Integer.MAX_VALUE / 2) {
                        dp[p][i] = Math.min(dp[p][i], dp[p - 1][j] + semiCost(j, i - 1));
                    }
                }
            }
        }

        return dp[k][n];
    }
}
