// https://leetcode.com/problems/knight-dialer/

// Solution: DP — O(n) time, O(1) space
class Solution {
    public int knightDialer(int n) {
        int MOD = 1_000_000_007;
        int[][] moves = {
            {4, 6}, {6, 8}, {7, 9}, {4, 8}, {0, 3, 9},
            {}, {0, 1, 7}, {2, 6}, {1, 3}, {2, 4}
        };
        long[] dp = new long[10];
        java.util.Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            long[] ndp = new long[10];
            for (int d = 0; d < 10; d++) {
                for (int next : moves[d]) {
                    ndp[next] = (ndp[next] + dp[d]) % MOD;
                }
            }
            dp = ndp;
        }
        long sum = 0;
        for (long x : dp) {
            sum = (sum + x) % MOD;
        }
        return (int) sum;
    }
}
