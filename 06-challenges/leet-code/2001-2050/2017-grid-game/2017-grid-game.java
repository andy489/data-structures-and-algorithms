// https://leetcode.com/problems/grid-game/

// Solution: Prefix Sums — O(n) time, O(n) space
class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] top = new long[n + 1], bot = new long[n + 1];
        for (int i = 0; i < n; i++) {
            top[i + 1] = top[i] + grid[0][i];
            bot[i + 1] = bot[i] + grid[1][i];
        }
        long res = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            long r2 = Math.max(top[n] - top[i + 1], bot[i]);
            res = Math.min(res, r2);
        }
        return res;
    }
}
