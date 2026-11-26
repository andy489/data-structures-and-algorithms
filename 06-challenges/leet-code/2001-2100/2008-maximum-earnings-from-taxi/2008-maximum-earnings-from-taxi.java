// https://leetcode.com/problems/maximum-earnings-from-taxi/

// Solution: DP with Prefix Max — O(m log m + n) time, O(n) space
class Solution {
    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, (a, b) -> a[1] - b[1]);
        long[] dp = new long[n + 1];
        int j = 0;
        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1];
            while (j < rides.length && rides[j][1] == i) {
                int start = rides[j][0], end = rides[j][1], tip = rides[j][2];
                dp[i] = Math.max(dp[i], dp[start] + tip + end - start);
                j++;
            }
        }
        return dp[n];
    }
}
