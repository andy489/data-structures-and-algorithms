// https://leetcode.com/problems/restore-the-array/

// Solution: DP — O(n * log k) time, O(n) space
class Solution {
    public int numberOfArrays(String s, int k) {
        int n = s.length();
        long MOD = 1_000_000_007;
        long[] dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            long num = 0;
            for (int j = i - 1; j >= 0; j--) {
                num = (s.charAt(j) - '0') * (long) Math.pow(10, i - 1 - j) + num;
                if (num > k) break;
                if (s.charAt(j) != '0') dp[i] = (dp[i] + dp[j]) % MOD;
            }
        }
        return (int) dp[n];
    }
}
