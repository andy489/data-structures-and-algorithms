// https://leetcode.com/problems/largest-plus-sign/

// Solution: DP 4-Direction Scan — O(n²) time, O(n²) space
class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] dp = new int[n][n];
        Set<Integer> mineSet = new HashSet<>();
        for (int[] m : mines) {
            mineSet.add(m[0] * n + m[1]);
        }
        int ans = 0;
        for (int r = 0; r < n; r++) {
            int count = 0;
            for (int c = 0; c < n; c++) {
                count = mineSet.contains(r * n + c) ? 0 : count + 1;
                dp[r][c] = count;
            }
            count = 0;
            for (int c = n - 1; c >= 0; c--) {
                count = mineSet.contains(r * n + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }
        }
        for (int c = 0; c < n; c++) {
            int count = 0;
            for (int r = 0; r < n; r++) {
                count = mineSet.contains(r * n + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }
            count = 0;
            for (int r = n - 1; r >= 0; r--) {
                count = mineSet.contains(r * n + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
                ans = Math.max(ans, dp[r][c]);
            }
        }
        return ans;
    }
}
