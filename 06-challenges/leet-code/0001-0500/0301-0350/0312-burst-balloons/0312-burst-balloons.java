// https://leetcode.com/problems/burst-balloons/

// Solution: Interval DP — O(n³) time, O(n²) space
class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n + 2];
        arr[0] = arr[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }
        int m = n + 2;
        int[][] dp = new int[m][m];
        for (int len = 2; len < m; len++) {
            for (int l = 0; l < m - len; l++) {
                int r = l + len;
                for (int k = l + 1; k < r; k++) {
                    dp[l][r] = Math.max(dp[l][r], dp[l][k] + arr[l] * arr[k] * arr[r] + dp[k][r]);
                }
            }
        }
        return dp[0][m - 1];
    }
}
