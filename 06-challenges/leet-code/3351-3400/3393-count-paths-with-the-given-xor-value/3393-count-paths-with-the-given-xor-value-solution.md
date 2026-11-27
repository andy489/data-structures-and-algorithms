# 3393. Count Paths With the Given XOR Value — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-paths-with-the-given-xor-value/

---

## Solution: 2D Dynamic Programming — O(m·n·16) time, O(m·n·16) space

**Idea:** Use 3D DP where `dp[i][j][v]` = number of paths from `(0,0)` to `(i,j)` whose XOR equals `v`. Since all cell values are `< 16` and `k < 16`, the XOR of any path remains in `[0, 15]`, so the third dimension is bounded by 16.

**Algorithm:**
1. Initialise `dp[0][0][grid[0][0]] = 1`.
2. Fill first row: `dp[0][j][dp[0][j-1] XOR grid[0][j]]`.
3. Fill first column similarly.
4. For each remaining cell `(i, j)`, for each XOR value `v` from 0 to 15:
   - `dp[i][j][v XOR grid[i][j]] += dp[i-1][j][v] + dp[i][j-1][v]`
5. Return `dp[m-1][n-1][k] % MOD`.

**Complexity:**

| | |
|---|---|
| Time | O(m·n·16) — constant-bounded XOR dimension |
| Space | O(m·n·16) |
