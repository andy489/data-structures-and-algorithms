// https://leetcode.com/problems/allocate-mailboxes/

// Solution: DP + Optimal Mailbox Placement — O(n^3) time, O(n^2) space
class Solution {
    public int minDistance(int[] houses, int k) {
        Arrays.sort(houses);
        int n = houses.length;
        int[][] cost = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = i; j < n; j++) {
                int mid = (i+j)/2;
                for (int x = i; x <= j; x++) cost[i][j] += Math.abs(houses[x] - houses[mid]);
            }
        int[][] dp = new int[k+1][n+1];
        for (int[] row : dp) Arrays.fill(row, Integer.MAX_VALUE / 2);
        dp[0][0] = 0;
        for (int i = 1; i <= k; i++)
            for (int j = 1; j <= n; j++)
                for (int p = i-1; p < j; p++)
                    dp[i][j] = Math.min(dp[i][j], dp[i-1][p] + cost[p][j-1]);
        return dp[k][n];
    }
}
