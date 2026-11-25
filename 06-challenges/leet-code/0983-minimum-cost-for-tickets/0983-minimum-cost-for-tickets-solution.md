# 983. Minimum Cost For Tickets — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-cost-for-tickets/

---

## Solution: DP — O(W) time, O(W) space

**Idea:** `dp[i]` = min cost to travel all days up to day i. On non-travel days, dp[i] = dp[i-1].

**Complexity:**

| | |
|---|---|
| Time | O(W) — W = 365 |
| Space | O(W) |
