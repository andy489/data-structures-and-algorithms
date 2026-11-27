// https://leetcode.com/problems/minimum-incompatibility/

// Solution: Bitmask DP — O(3^n) time, O(2^n) space
class Solution {
    public int minimumIncompatibility(int[] nums, int k) {
        int n = nums.length;
        int groupSize = n / k;
        int full = (1 << n) - 1;
        int[] cost = new int[1 << n];
        Arrays.fill(cost, -1);
        // Precompute cost for each mask of size groupSize with distinct elements
        for (int mask = 1; mask <= full; mask++) {
            if (Integer.bitCount(mask) != groupSize) {
                continue;
            }
            int mn = 20, mx = 0;
            boolean valid = true;
            int[] freq = new int[n + 1];
            for (int i = 0; i < n; i++) {
                if ((mask >> i & 1) == 1) {
                    if (++freq[nums[i]] > 1) {
                        valid = false;
                        break;
                    }
                    mn = Math.min(mn, nums[i]);
                    mx = Math.max(mx, nums[i]);
                }
            }
            if (valid) {
                cost[mask] = mx - mn;
            }
        }
        int[] dp = new int[1 << n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int mask = 0; mask <= full; mask++) {
            if (dp[mask] == Integer.MAX_VALUE) {
                continue;
            }
            // Find lowest unset bit to fix group
            int sub = full ^ mask;
            for (int s = sub; s > 0; s = (s - 1) & sub) {
                if (cost[s] != -1 && dp[mask] != Integer.MAX_VALUE) {
                    dp[mask | s] = Math.min(dp[mask | s], dp[mask] + cost[s]);
                }
            }
        }
        return dp[full] == Integer.MAX_VALUE ? -1 : dp[full];
    }
}
