# 2008. Maximum Earnings From Taxi — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-earnings-from-taxi/

---

## Solution: DP with Binary Search — O(m log m) time, O(m + n) space

**Idea:** Sort rides by end point. For each ride, dp[end] = max(dp[end], dp[start] + profit). Use prefix max DP.

**Algorithm:**
1. Sort rides by end.
2. Maintain prefix max dp array: dp[i] = max earnings ending at point i.
3. For each ride, dp[end] = max(dp[end], dp[start] + tip + end - start).
4. Propagate dp prefix max forward.

**Complexity:**

| | |
|---|---|
| Time | O(m log m) |
| Space | O(m + n) |
