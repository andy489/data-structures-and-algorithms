// https://leetcode.com/problems/number-of-ways-to-separate-numbers/

// Solution: DP with LCP — O(n^2) time, O(n^2) space
class Solution {
    public int numberOfCombinations(String num) {
        final int MOD = 1_000_000_007;
        int n = num.length();
        if (num.charAt(0) == '0') {
            return 0;
        }

        // lcp[i][j] = length of longest common prefix of num[i..] and num[j..]
        int[][] lcp = new int[n + 1][n + 1];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (num.charAt(i) == num.charAt(j)) {
                    lcp[i][j] = lcp[i + 1][j + 1] + 1;
                } else {
                    lcp[i][j] = 0;
                }
            }
        }

        // dp[i][j] = number of valid splits of num[0..i] where last number starts at j
        // prefix[i][j] = sum of dp[i][0..j]
        int[][] dp = new int[n][n];
        int[][] prefix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (num.charAt(j) == '0') {
                    dp[i][j] = 0;
                } else {
                    int len = i - j + 1;
                    if (j == 0) {
                        dp[i][j] = 1;
                    } else {
                        // prev number ends at j-1, so we look for prev starts
                        // prev number starts at k, length = j - k, current length = len
                        // need j - k <= len, i.e. k >= j - len
                        int lo = Math.max(0, j - len);
                        // sum of dp[j-1][lo..j-1]
                        // but need to verify >=: use lcp
                        // Actually use prefix sums on dp[j-1][lo..j-1]
                        // but verify that if lengths equal, prev number <= cur number
                        int rangeSum = prefix[j - 1][j - 1] - (lo > 0 ? prefix[j - 1][lo - 1] : 0);

                        // For equal-length case at k = j - len: check if prev >= cur
                        // prev starts at k = j - len, prev length = j - k = len
                        if (lo == j - len) {
                            int k = j - len;
                            if (k >= 0 && num.charAt(k) != '0') {
                                int commonLen = lcp[k][j];
                                if (commonLen < len) {
                                    // compare charAt(k + commonLen) vs charAt(j + commonLen)
                                    if (num.charAt(k + commonLen) > num.charAt(j + commonLen)) {
                                        // prev > cur, so this split with k is invalid
                                        rangeSum = (rangeSum - dp[j - 1][k] + MOD) % MOD;
                                    }
                                }
                                // if commonLen >= len, they are equal, which is valid
                            }
                        }
                        dp[i][j] = rangeSum % MOD;
                    }
                }
                prefix[i][j] = (j > 0 ? prefix[i][j - 1] : 0) + dp[i][j];
                prefix[i][j] %= MOD;
            }
        }

        return prefix[n - 1][n - 1];
    }
}
