# 2218. Maximum Value of K Coins From Piles — Solution

**Approach:** Dynamic Programming (Knapsack)

Use DP where `dp[j]` = maximum value taking exactly `j` coins considering piles processed so far. For each pile, iterate `j` from `k` down to 0 and try taking 1..min(pileSize, k-j) coins from that pile (using prefix sums).

**Time Complexity:** O(n * k) where n = number of piles.

**Space Complexity:** O(k) for the DP array.
