# 3946. Maximum Number of Items From Sale I — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-number-of-items-from-sale-i/

---

## Solution: Enumerate Purchased Subsets + Free Copy Precomputation — O(n² + n·budget) time, O(n²) space

**Idea:** Precompute for each item how many free copies it generates when bought (count of items whose factor is divisible by its factor). Then enumerate over all possible "which item types to buy" using the cheapest price per item type, greedily spending budget to maximize total copies.

The key insight: buying at least one copy of item `i` triggers free copies. Additional copies of item `i` add to the count without triggering more free copies. So for each item type we either buy 0 (not triggered) or ≥1 (triggered, then as many extra as budget allows).

**Algorithm:**
1. Precompute `free[i]` = number of items `j` (j≠i) where `factor_i` divides `factor_j`.
2. For each subset of "triggered" item types (items bought at least once), compute the minimum cost to trigger all of them (1 copy each at their price), the total free copies they generate, and then with remaining budget greedily buy the cheapest item as many times as possible.
3. Since n≤1000 and budget≤1500, we can iterate over all possible triggered subsets more cleverly: use DP over items with budget.

**Refined approach (DP):**
- State: `dp[b]` = max (purchased + free) copies achievable spending exactly `b` budget on a chosen set of triggered items (at least 1 copy each).
- For each subset, the free bonus is fixed once the triggered set is determined. This is still O(2^n) in general.

**Practical approach (enumerate cheapest price per item):**
Since we want to maximize total copies, and free copies from triggering item `i` are fixed at `free[i]`, we can model it as: pick a subset S of items to trigger (each costs `price_i`), allocate the remaining budget to extra copies of the cheapest item. Iterate over all 2^n subsets — too large for n=1000.

**Correct greedy/DP approach:**
- Note prices and factors are both ≤ 1500. Use a knapsack-style DP on budget: for each item either skip or trigger once (cost = price_i, gain = 1 + free[i]), then with remaining budget buy any extra copies of the globally cheapest item.
- After deciding the triggered set, every remaining coin buys extra copies at `minPrice`.

1. Find `minPrice` = minimum price across all items.
2. Run 0/1 knapsack: `dp[b]` = max items (purchased+free) reachable with budget `b`, where each item can be triggered once at cost `price_i` gaining `1 + free[i]`.
3. Answer = max over all b of `dp[b] + (budget - b) / minPrice`.

**Complexity:**

| | |
|---|---|
| Time | O(n² + n·budget) — free precomputation O(n²), knapsack O(n·budget) |
| Space | O(n + budget) |
