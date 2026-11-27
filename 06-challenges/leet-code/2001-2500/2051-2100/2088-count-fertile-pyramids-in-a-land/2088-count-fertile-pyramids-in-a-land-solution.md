# 2088. Count Fertile Pyramids in a Land — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-fertile-pyramids-in-a-land/

---

## Solution: DP — O(m * n) time, O(m * n) space

**Idea:** dp[i][j] = max height of upright pyramid with apex at (i,j). dp[i][j] = min(dp[i+1][j-1], dp[i+1][j], dp[i+1][j+1]) + 1 if grid[i][j] == 1.

**Algorithm:**
1. For upright: process bottom-up.
2. For inverted: process top-down.
3. dp values > 1 contribute (dp-1) to count (each bigger pyramid contains all smaller ones).

**Complexity:**

| | |
|---|---|
| Time | O(m * n) |
| Space | O(m * n) |
