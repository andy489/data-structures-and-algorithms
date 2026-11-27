# 746. Min Cost Climbing Stairs — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/min-cost-climbing-stairs/

---

## Solution: Dynamic Programming — O(n) time, O(1) space

**Idea:** `dp[i]` = min cost to reach step `i`. Transition: `dp[i] = cost[i] + min(dp[i-1], dp[i-2])`. The top is step `n`, so return `min(dp[n-1], dp[n-2])`.

**Algorithm:**
1. Keep two variables `prev2`, `prev1` initialized to `cost[0]`, `cost[1]`.
2. For `i` from 2 to `n-1`: `cur = cost[i] + min(prev1, prev2)`.
3. Return `min(prev1, prev2)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(1) |
