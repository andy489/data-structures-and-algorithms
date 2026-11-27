// https://leetcode.com/problems/minimum-total-space-wasted-with-k-resizing-operations/
class Solution {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        int n = nums.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        int[][] dp = new int[n + 1][k + 2];
        int INF = Integer.MAX_VALUE / 2;
        for (int[] row : dp) {
            java.util.Arrays.fill(row, INF);
        }
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k + 1; j++) {
                int maxVal = 0;
                for (int l = i; l >= 1; l--) {
                    maxVal = Math.max(maxVal, nums[l - 1]);
                    int sum = prefix[i] - prefix[l - 1];
                    int waste = maxVal * (i - l + 1) - sum;
                    if (dp[l - 1][j - 1] != INF) {
                        dp[i][j] = Math.min(dp[i][j], dp[l - 1][j - 1] + waste);
                    }
                }
            }
        }

        int ans = INF;
        for (int j = 1; j <= k + 1; j++) {
            ans = Math.min(ans, dp[n][j]);
        }
        return ans;
    }
}
