// https://leetcode.com/problems/jump-game-v/

// Solution: DP Memoization — O(n*d) time, O(n) space
class Solution {
    int[] memo;
    public int maxJumps(int[] arr, int d) {
        int n = arr.length;
        memo = new int[n];
        int ans = 0;
        for (int i = 0; i < n; i++) ans = Math.max(ans, dp(arr, i, d));
        return ans;
    }
    private int dp(int[] arr, int i, int d) {
        if (memo[i] != 0) return memo[i];
        int n = arr.length, res = 1;
        for (int dir : new int[]{1, -1}) {
            for (int k = 1; k <= d; k++) {
                int j = i + dir * k;
                if (j < 0 || j >= n || arr[j] >= arr[i]) break;
                res = Math.max(res, 1 + dp(arr, j, d));
            }
        }
        return memo[i] = res;
    }
}
