# 741. Cherry Pickup — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/cherry-pickup/

---

## Solution: 3D DP (Two Simultaneous Paths) — O(n³) time, O(n³) space

**Idea:** Instead of going and coming back, simulate two people walking from `(0,0)` to `(n-1,n-1)` simultaneously. At step `t`, person 1 is at `(r1, t-r1)` and person 2 at `(r2, t-r2)`. Both share cherries at the same cell only once. DP state: `dp[t][r1][r2]` = max cherries.

**Algorithm:**
1. `dp[r1][r2]` at step t: both at column `c1 = t-r1`, `c2 = t-r2`.
2. Cherries = `grid[r1][c1] + (r1 != r2 ? grid[r2][c2] : 0)`.
3. Transition: each of 4 combinations of (down/right) for each person.
4. Return `max(0, dp[n-1][n-1])`.

**Complexity:**

| | |
|---|---|
| Time | O(n³) — 3D DP table |
| Space | O(n²) — rolling 2D slice |
