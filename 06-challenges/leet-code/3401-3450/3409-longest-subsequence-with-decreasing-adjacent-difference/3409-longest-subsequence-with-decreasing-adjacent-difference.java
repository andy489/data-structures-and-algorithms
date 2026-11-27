// https://leetcode.com/problems/longest-subsequence-with-decreasing-adjacent-difference/
class Solution {
    public int longestSubsequence(int[] nums) {
        int maxVal = 301;
        // dp[v][d] = max length of subsequence ending with value v and last diff <= d
        // We store suffix max: suffMax[v][d] = max over d' >= d of dp[v][d']
        int[][] suffMax = new int[maxVal][maxVal];
        int ans = 1;

        for (int num : nums) {
            int[] curBest = new int[maxVal];
            for (int v = 0; v < maxVal; v++) {
                int diff = Math.abs(num - v);
                if (diff < maxVal && suffMax[v][diff] > 0) {
                    int candidate = suffMax[v][diff] + 1;
                    if (candidate > curBest[diff]) {
                        curBest[diff] = candidate;
                    }
                }
            }
            // Update suffMax[num]: first set dp[num][d] = max(dp[num][d], curBest[d] or 1)
            // then rebuild suffix max
            for (int d = 0; d < maxVal; d++) {
                int val = curBest[d] > 0 ? curBest[d] : 1;
                if (val > suffMax[num][d]) {
                    suffMax[num][d] = val;
                }
            }
            // Rebuild suffix max for num (from right)
            for (int d = maxVal - 2; d >= 0; d--) {
                if (suffMax[num][d + 1] > suffMax[num][d]) {
                    suffMax[num][d] = suffMax[num][d + 1];
                }
                ans = Math.max(ans, suffMax[num][d]);
            }
            ans = Math.max(ans, suffMax[num][maxVal - 1]);
        }
        return ans;
    }
}
