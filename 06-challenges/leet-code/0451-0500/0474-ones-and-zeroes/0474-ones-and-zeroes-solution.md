# 474. Ones and Zeroes — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/ones-and-zeroes/

---

## Solution: 2D 0/1 Knapsack DP — O(L · m · n) time, O(m · n) space

**Idea:** Classic 0/1 knapsack with two capacities (m zeros, n ones). `dp[i][j]` = max items using at most i zeros and j ones. Traverse in reverse to avoid using an item twice.

**Algorithm:**
1. For each string, count its zeros and ones.
2. Update `dp[i][j] = max(dp[i][j], dp[i-zeros][j-ones] + 1)` from m,n down to zeros,ones.

**Complexity:**

| | |
|---|---|
| Time | O(L · m · n) — L strings, each O(m·n) DP update |
| Space | O(m · n) — 2D DP table |
