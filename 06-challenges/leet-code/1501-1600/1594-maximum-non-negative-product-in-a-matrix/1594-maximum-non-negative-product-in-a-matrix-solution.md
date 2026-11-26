# 1594. Maximum Non Negative Product in a Matrix — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/

---

## Solution: DP Track Min/Max — O(m*n) time, O(m*n) space

**Idea:** Since products of negatives can flip signs, track both the maximum and minimum product reachable at each cell. At each step, the new max/min comes from multiplying the current value with the previous max or min (depending on sign).

**Algorithm:**
1. Initialize `dpMax[0][0] = dpMin[0][0] = grid[0][0]`.
2. Fill first row and column by accumulating products.
3. For each `(i, j)`: consider all 4 candidates (from top or left, times max or min). Update `dpMax[i][j]` and `dpMin[i][j]`.
4. Return `dpMax[m-1][n-1] % MOD`, or -1 if negative.

**Complexity:**

| | |
|---|---|
| Time | O(m*n) — single DP pass |
| Space | O(m*n) — two DP tables |
