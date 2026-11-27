// https://leetcode.com/problems/form-largest-integer-with-digits-that-add-up-to-target/

// Solution: DP (Unbounded Knapsack + Digit Count) — O(9*target) time, O(target) space
class Solution {
    public String largestNumber(int[] cost, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        for (int t = 1; t <= target; t++)
            for (int d = 0; d < 9; d++)
                if (cost[d] <= t && dp[t - cost[d]] != Integer.MIN_VALUE)
                    dp[t] = Math.max(dp[t], dp[t - cost[d]] + 1);
        if (dp[target] < 0) return "0";
        StringBuilder sb = new StringBuilder();
        int rem = target;
        while (rem > 0) {
            for (int d = 8; d >= 0; d--) {
                if (cost[d] <= rem && dp[rem - cost[d]] == dp[rem] - 1) {
                    sb.append(d + 1);
                    rem -= cost[d];
                    break;
                }
            }
        }
        return sb.toString();
    }
}
