// https://leetcode.com/problems/minimum-cost-to-connect-two-groups-of-points/

// Solution: DP with Bitmask — O(m * 2^n * n) time, O(m * 2^n) space
class Solution {
    public int connectTwoGroups(List<List<Integer>> cost) {
        int m = cost.size(), n = cost.get(0).size();
        int full = (1 << n) - 1;
        // minCostForRight[j] = minimum cost to cover right node j from any left node
        int[] minCostForRight = new int[n];
        Arrays.fill(minCostForRight, Integer.MAX_VALUE);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                minCostForRight[j] = Math.min(minCostForRight[j], cost.get(i).get(j));
            }
        }
        // dp[mask] = min cost after processing all left nodes, with mask of covered right nodes
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE / 2);
        dp[0] = 0;
        for (int i = 0; i < m; i++) {
            int[] ndp = new int[1 << n];
            Arrays.fill(ndp, Integer.MAX_VALUE / 2);
            for (int mask = 0; mask <= full; mask++) {
                if (dp[mask] == Integer.MAX_VALUE / 2) continue;
                for (int j = 0; j < n; j++) {
                    int nmask = mask | (1 << j);
                    ndp[nmask] = Math.min(ndp[nmask], dp[mask] + cost.get(i).get(j));
                }
            }
            dp = ndp;
        }
        int result = Integer.MAX_VALUE;
        for (int mask = 0; mask <= full; mask++) {
            if (dp[mask] == Integer.MAX_VALUE / 2) continue;
            int extra = 0;
            for (int j = 0; j < n; j++) {
                if ((mask & (1 << j)) == 0) {
                    extra += minCostForRight[j];
                }
            }
            result = Math.min(result, dp[mask] + extra);
        }
        return result;
    }
}
