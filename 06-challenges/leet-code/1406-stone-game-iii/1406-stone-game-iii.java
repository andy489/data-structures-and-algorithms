// https://leetcode.com/problems/stone-game-iii/

// Solution: DP from Right — O(n) time, O(1) space
class Solution {
    public String stoneGameIII(int[] sv) {
        int n = sv.length;
        int[] dp = new int[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = Integer.MIN_VALUE;
            int sum = 0;
            for (int k = 1; k <= 3 && i + k <= n; k++) {
                sum += sv[i + k - 1];
                dp[i] = Math.max(dp[i], sum - dp[i + k]);
            }
        }
        int total = 0;
        for (int v : sv) total += v;
        int alice = dp[0], bob = total - dp[0];
        return alice > bob ? "Alice" : alice < bob ? "Bob" : "Tie";
    }
}
