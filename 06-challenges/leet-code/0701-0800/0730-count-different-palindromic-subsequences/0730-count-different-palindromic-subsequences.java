// https://leetcode.com/problems/count-different-palindromic-subsequences/

// Solution: Interval DP — O(n²) time, O(n²) space
class Solution {
    private static final int MOD = 1_000_000_007;

    public int countPalindromicSubsequences(String s) {
        int n = s.length();
        long[][] dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;
                for (char c : new char[]{'a', 'b', 'c', 'd'}) {
                    int l = i, r = j;
                    while (l <= j && s.charAt(l) != c) {
                        l++;
                    }
                    while (r >= i && s.charAt(r) != c) {
                        r--;
                    }
                    if (l > r) {
                        continue;
                    }
                    if (l == r) {
                        dp[i][j] += 1;
                    } else if (l + 1 == r) {
                        dp[i][j] += 2;
                    } else {
                        dp[i][j] += dp[l + 1][r - 1] + 2;
                    }
                }
                dp[i][j] %= MOD;
            }
        }
        return (int) dp[0][n - 1];
    }
}
