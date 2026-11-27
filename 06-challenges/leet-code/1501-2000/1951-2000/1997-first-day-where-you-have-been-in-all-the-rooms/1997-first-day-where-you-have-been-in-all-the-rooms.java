// https://leetcode.com/problems/first-day-where-you-have-been-in-all-the-rooms/
class Solution {
    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length;
        long MOD = 1_000_000_007;
        long[] dp = new long[n];
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = (2 * dp[i - 1] - dp[nextVisit[i - 1]] + 2 + MOD) % MOD;
        }
        return (int) dp[n - 1];
    }
}
