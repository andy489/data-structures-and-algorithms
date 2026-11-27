// https://leetcode.com/problems/find-the-number-of-subsequences-with-equal-gcd/

class Solution {
    public int subsequencePairCount(int[] nums) {
        final int MOD = 1_000_000_007;
        int maxVal = 201;
        // dp[g1][g2] = number of ways where seq1 has running gcd g1, seq2 has g2
        // 0 means empty subsequence
        long[][] dp = new long[maxVal][maxVal];
        dp[0][0] = 1;

        for (int x : nums) {
            long[][] newDp = new long[maxVal][maxVal];
            for (int g1 = 0; g1 < maxVal; g1++) {
                for (int g2 = 0; g2 < maxVal; g2++) {
                    if (dp[g1][g2] == 0) {
                        continue;
                    }
                    long val = dp[g1][g2];
                    // Skip x
                    newDp[g1][g2] = (newDp[g1][g2] + val) % MOD;
                    // Add x to seq1
                    int ng1 = (g1 == 0) ? x : gcd(g1, x);
                    newDp[ng1][g2] = (newDp[ng1][g2] + val) % MOD;
                    // Add x to seq2
                    int ng2 = (g2 == 0) ? x : gcd(g2, x);
                    newDp[g1][ng2] = (newDp[g1][ng2] + val) % MOD;
                }
            }
            dp = newDp;
        }

        long ans = 0;
        for (int g = 1; g < maxVal; g++) {
            ans = (ans + dp[g][g]) % MOD;
        }
        return (int) ans;
    }

    private int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }
}
