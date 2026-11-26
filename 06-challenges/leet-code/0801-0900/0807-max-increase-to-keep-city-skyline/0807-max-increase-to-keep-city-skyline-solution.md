# 807. Max Increase to Keep City Skyline — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/max-increase-to-keep-city-skyline/

---

## Solution: Row/Column Maxima — O(n²) time, O(n) space

**Idea:** Each building can be raised to min(rowMax[i], colMax[j]) without changing any skyline. Sum up the differences.

**Algorithm:**
1. Compute rowMax[i] = max of row i, colMax[j] = max of column j.
2. For each cell, add min(rowMax[i], colMax[j]) - grid[i][j] to total.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — two passes over grid |
| Space | O(n) — row and column max arrays |
