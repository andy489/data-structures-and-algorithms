// https://leetcode.com/problems/minimum-cost-to-cut-a-stick/

// Solution: Interval DP — O(m^3) time, O(m^2) space
class Solution {
    public int minCost(int n, int[] cuts) {
        Arrays.sort(cuts);
        int m = cuts.length;
        int[] c = new int[m + 2];
        c[0] = 0;
        c[m + 1] = n;
        for (int i = 1; i <= m; i++) {
            c[i] = cuts[i - 1];
        }
        int[][] dp = new int[m + 2][m + 2];
        for (int len = 2; len <= m + 1; len++) {
            for (int left = 0; left + len <= m + 1; left++) {
                int right = left + len;
                dp[left][right] = Integer.MAX_VALUE;
                for (int mid = left + 1; mid < right; mid++) {
                    dp[left][right] = Math.min(dp[left][right],
                        dp[left][mid] + dp[mid][right] + c[right] - c[left]);
                }
            }
        }
        return dp[0][m + 1];
    }
}
