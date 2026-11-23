# 518. Coin Change II — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/coin-change-ii/

---

## Solution: 2D DP (unbounded knapsack) — O(n × amount) time, O(n × amount) space

**Idea:** `dp[i][j]` = number of ways to make amount `j` using first `i` coins. Either skip coin i (`dp[i-1][j]`) or use it (`dp[i][j - coins[i-1]]`).

**Complexity:**

| | |
|---|---|
| Time | O(n × amount) |
| Space | O(n × amount) — reducible to O(amount) with 1D rolling array |

---

## Solution 2: 1D DP — O(n × amount) time, O(amount) space

**Idea:** `dp[j]` = number of ways to make amount `j`. For each coin, update `dp[j] += dp[j - coin]` left-to-right (unbounded: each coin can be used multiple times).

**Complexity:**

| | |
|---|---|
| Time | O(n × amount) |
| Space | O(amount) |
