// https://leetcode.com/problems/dungeon-game/

// Solution 1: DP from bottom-right — O(m*n) time, O(m*n) space
class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[][] dp = new int[m + 1][n + 1];
        for (int[] row : dp) java.util.Arrays.fill(row, Integer.MAX_VALUE);
        dp[m][n - 1] = dp[m - 1][n] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int need = Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = Math.max(1, need - dungeon[i][j]);
            }
        }
        return dp[0][0];
    }
}

// Solution 2: O(n) space rolling array
class Solution2 {
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        int[] dp = new int[n + 1];
        java.util.Arrays.fill(dp, Integer.MAX_VALUE);
        dp[n - 1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            int[] next = new int[n + 1];
            java.util.Arrays.fill(next, Integer.MAX_VALUE);
            next[n - 1] = 1;
            for (int j = n - 1; j >= 0; j--) {
                int need = Math.min(dp[j], next[j + 1] == Integer.MAX_VALUE ? Integer.MAX_VALUE : next[j + 1]);
                next[j] = Math.max(1, need - dungeon[i][j]);
            }
            dp = next;
        }
        return dp[0];
    }
}
