// https://leetcode.com/problems/minimum-cost-to-divide-array-into-subarrays/

// Solution: DP with Suffix Cost Reformulation — O(n^2) time, O(n) space
class Solution {
    public long minimumCost(int[] nums, int[] cost, int k) {
        int n = nums.length;

        // prefNums[i] = nums[0] + ... + nums[i-1]
        long[] prefNums = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefNums[i + 1] = prefNums[i] + nums[i];
        }

        // suffCost[i] = cost[i] + ... + cost[n-1]
        long[] suffCost = new long[n + 1];
        for (int i = n - 1; i >= 0; i--) {
            suffCost[i] = suffCost[i + 1] + cost[i];
        }

        // dp[r] = min cost to partition nums[0..r-1]
        // Using identity: sum_q(q * segCost_q) = sum_q suffCost[l_q] for complete partitions,
        // the transition becomes:
        // dp[r] = -prefNums[r]*suffCost[r] + min_l{ dp[l] + (prefNums[r]+k)*suffCost[l] }
        long[] dp = new long[n + 1];
        long INF = Long.MAX_VALUE / 2;
        for (int i = 1; i <= n; i++) {
            dp[i] = INF;
        }

        for (int r = 1; r <= n; r++) {
            long minVal = INF;
            for (int l = 0; l < r; l++) {
                if (dp[l] < INF) {
                    long candidate = dp[l] + (prefNums[r] + k) * suffCost[l];
                    if (candidate < minVal) {
                        minVal = candidate;
                    }
                }
            }
            dp[r] = minVal - prefNums[r] * suffCost[r];
        }

        return dp[n];
    }
}
