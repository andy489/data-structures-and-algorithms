// https://leetcode.com/problems/valid-permutations-for-di-sequence/

// Solution: DP with Prefix Sums — O(n²) time, O(n) space
class Solution {
    public int numPermsDISequence(String s) {
        int MOD = 1_000_000_007;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            int[] ndp = new int[i + 2];
            if (s.charAt(i) == 'I') {
                int prefix = 0;
                for (int j = 0; j <= i; j++) {
                    prefix = (prefix + dp[j]) % MOD;
                    ndp[j + 1] = prefix;
                }
            } else {
                int suffix = 0;
                for (int j = i; j >= 0; j--) {
                    suffix = (suffix + dp[j]) % MOD;
                    ndp[j] = suffix;
                }
            }
            dp = ndp;
        }
        int ans = 0;
        for (int x : dp) {
            ans = (ans + x) % MOD;
        }
        return ans;
    }
}
