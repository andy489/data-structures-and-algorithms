// https://leetcode.com/problems/distinct-subsequences-ii/

// Solution: DP with Last Char Tracking — O(n) time, O(26) space
class Solution {
    public int distinctSubseqII(String s) {
        int MOD = 1_000_000_007;
        long[] dp = new long[26];
        for (char c : s.toCharArray()) {
            long total = 0;
            for (long x : dp) {
                total = (total + x) % MOD;
            }
            dp[c - 'a'] = (total + 1) % MOD;
        }
        long ans = 0;
        for (long x : dp) {
            ans = (ans + x) % MOD;
        }
        return (int) ans;
    }
}
