# 818. Race Car — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/race-car/

---

## Solution: Dynamic Programming — O(t log t) time, O(t) space

**Idea:** dp[t] = min instructions to reach t. For each t, either: take k A's overshooting then reverse, or take k-1 A's then reverse and use dp for the remainder.

**Algorithm:**
1. dp[0] = 0, dp[1] = 1.
2. For each t from 2 to target:
   - If t == 2^k - 1: dp[t] = k (k accelerations)
   - Otherwise: try going past target (2^k - 1 > t) with k A's then reverse (dp[2^k-1-t] + k+1)
   - Try stopping before target: k-1 A's, reverse, j A's, reverse (dp[t-(2^(k-1)-1-2^j+1)] + k-1+j+2)

**Complexity:**

| | |
|---|---|
| Time | O(t log t) — log t sub-states per t |
| Space | O(t) — dp array |
