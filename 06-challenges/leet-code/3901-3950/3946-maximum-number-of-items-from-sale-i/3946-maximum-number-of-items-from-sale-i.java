// https://leetcode.com/problems/maximum-number-of-items-from-sale-i/

// Solution: 0/1 Knapsack + greedy extra copies — O(n² + n·budget) time, O(n + budget) space
class Solution {
    public int maxItems(int[][] items, int budget) {
        int n = items.length;
        int minPrice = Integer.MAX_VALUE;
        for (int[] item : items) {
            minPrice = Math.min(minPrice, item[1]);
        }

        // free[i] = number of other items j where factor[i] divides factor[j]
        int[] free = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && items[j][0] % items[i][0] == 0) {
                    free[i]++;
                }
            }
        }

        // 0/1 knapsack: trigger subset of items, each costs price[i], gains 1 + free[i]
        int[] dp = new int[budget + 1];
        for (int i = 0; i < n; i++) {
            int cost = items[i][1];
            int gain = 1 + free[i];
            for (int b = budget; b >= cost; b--) {
                dp[b] = Math.max(dp[b], dp[b - cost] + gain);
            }
        }

        // For each spending level b on triggered items, remaining budget buys extra cheap copies
        int ans = 0;
        for (int b = 0; b <= budget; b++) {
            int extra = (budget - b) / minPrice;
            ans = Math.max(ans, dp[b] + extra);
        }
        return ans;
    }
}
