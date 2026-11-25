// https://leetcode.com/problems/race-car/

// Solution: Dynamic Programming — O(t log t) time, O(t) space
class Solution {
    public int racecar(int target) {
        int[] dp = new int[target + 1];
        for (int t = 1; t <= target; t++) {
            int k = 32 - Integer.numberOfLeadingZeros(t);
            if (t == (1 << k) - 1) {
                dp[t] = k;
                continue;
            }
            dp[t] = dp[(1 << k) - 1 - t] + k + 1;
            for (int j = 0; j < k - 1; j++) {
                int back = (1 << j) - 1;
                dp[t] = Math.min(dp[t], dp[t - (1 << (k - 1)) + 1 + back] + k - 1 + j + 2);
            }
        }
        return dp[target];
    }
}
