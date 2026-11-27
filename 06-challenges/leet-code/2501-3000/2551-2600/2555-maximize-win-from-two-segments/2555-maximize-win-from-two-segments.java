// https://leetcode.com/problems/maximize-win-from-two-segments/

// Solution: Sliding Window + DP — O(n) time, O(n) space
class Solution {
    public int maximizeWin(int[] prizePositions, int k) {
        int n = prizePositions.length;
        int[] dp = new int[n + 1]; // dp[i] = max prizes from one segment using positions 0..i-1
        int ans = 0;
        for (int l = 0, r = 0; r < n; r++) {
            while (prizePositions[r] - prizePositions[l] > k) {
                l++;
            }
            int windowSize = r - l + 1;
            dp[r + 1] = Math.max(dp[r], windowSize);
            ans = Math.max(ans, dp[l] + windowSize);
        }
        return ans;
    }
}
