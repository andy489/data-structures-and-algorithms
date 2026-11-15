// https://leetcode.com/problems/divisor-game/

// Solution: Math — O(1) time, O(1) space
class Solution {
    public boolean divisorGame(int n) {
        return n % 2 == 0;
    }
}

// Solution 2: Dynamic Programming — O(n²) time, O(n) space
class Solution2 {
    public boolean divisorGame(int n) {
        boolean[] dp = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            for (int x = 1; x < i; x++) {
                if (i % x == 0 && !dp[i - x]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
