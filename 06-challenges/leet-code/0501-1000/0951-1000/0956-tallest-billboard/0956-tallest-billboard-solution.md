# 956. Tallest Billboard — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/tallest-billboard/

---

## Solution: DP on Difference — O(n*S) time, O(S) space

**Idea:** `dp[diff]` = max height of the taller side when the difference between two sides is `diff`.

**Algorithm:**
1. Initialize `dp[0] = 0`, all others `-infinity`.
2. For each rod, consider adding it to the taller side, shorter side, or neither.
3. Answer is `dp[0]`.

**Complexity:**

| | |
|---|---|
| Time | O(n*S) — n rods, S = sum of rods |
| Space | O(S) — dp array |
