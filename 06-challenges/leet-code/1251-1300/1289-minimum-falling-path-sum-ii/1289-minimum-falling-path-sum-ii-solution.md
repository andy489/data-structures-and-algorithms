# 1289. Minimum Falling Path Sum II — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-falling-path-sum-ii/

---

## Solution: Dynamic Programming — O(n²) time, O(n) space

**Idea:** Track the two smallest values from the previous row. For each cell, add the smallest previous value that's not in the same column.

**Algorithm:**
1. For each row, compute new dp using min1 and min2 (and their columns) from previous row.
2. For column j: dp[j] = grid[j] + (min1 if min1_col != j else min2).

**Complexity:**

| | |
|---|---|
| Time | O(n²) |
| Space | O(n) |
