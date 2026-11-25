# 861. Score After Flipping Matrix — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/score-after-flipping-matrix/

---

## Solution: Greedy — O(m*n) time, O(1) space

**Idea:** Greedily, first flip rows so the leading bit is 1 (maximizes MSB). Then for each column, flip it if more than half the values are 0 (to maximize 1s).

**Algorithm:**
1. Flip any row where grid[r][0] == 0.
2. For each column j (from 1), count ones. If ones < m - ones, flip column.
3. Compute final sum.

**Complexity:**

| | |
|---|---|
| Time | O(m * n) |
| Space | O(1) |
