// https://leetcode.com/problems/count-all-possible-routes/

// Solution: Top-Down DP with Memoization — O(n^2 * fuel) time, O(n * fuel) space
class Solution {
    static final int MOD = 1_000_000_007;
    int[] locations;
    int finish;
    int[][] memo;

    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        this.locations = locations;
        this.finish = finish;
        int n = locations.length;
        memo = new int[n][fuel + 1];
        for (int[] row : memo) {
            java.util.Arrays.fill(row, -1);
        }
        return dp(start, fuel);
    }

    private int dp(int cur, int fuel) {
        if (fuel < 0) {
            return 0;
        }
        if (memo[cur][fuel] != -1) {
            return memo[cur][fuel];
        }
        int res = (cur == finish) ? 1 : 0;
        for (int next = 0; next < locations.length; next++) {
            if (next != cur) {
                int cost = Math.abs(locations[next] - locations[cur]);
                if (fuel >= cost) {
                    res = (int) ((res + dp(next, fuel - cost)) % MOD);
                }
            }
        }
        memo[cur][fuel] = res;
        return res;
    }
}
