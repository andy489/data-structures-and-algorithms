// https://leetcode.com/problems/super-egg-drop/

// Solution: DP (Inverse) — O(k*n) time, O(k) space
class Solution {
    public int superEggDrop(int k, int n) {
        int[] dp = new int[k + 1];
        int t = 0;
        while (dp[k] < n) {
            t++;
            for (int j = k; j >= 1; j--) {
                dp[j] = dp[j - 1] + dp[j] + 1;
            }
        }
        return t;
    }
}
