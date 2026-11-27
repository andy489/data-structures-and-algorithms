// https://leetcode.com/problems/maximum-points-tourist-can-earn/

class Solution {
    public int maxScore(int n, int k, int[][] stayScore, int[][] travelScore) {
        int[] dp = new int[n];
        for (int c = 0; c < n; c++) {
            dp[c] = stayScore[0][c];
        }
        for (int day = 1; day < k; day++) {
            int[] newDp = new int[n];
            for (int dest = 0; dest < n; dest++) {
                newDp[dest] = dp[dest] + stayScore[day][dest];
                for (int prev = 0; prev < n; prev++) {
                    if (prev != dest) {
                        newDp[dest] = Math.max(newDp[dest], dp[prev] + travelScore[prev][dest]);
                    }
                }
            }
            dp = newDp;
        }
        int ans = 0;
        for (int c = 0; c < n; c++) {
            ans = Math.max(ans, dp[c]);
        }
        return ans;
    }
}
