# 1659. Maximize Grid Happiness — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximize-grid-happiness/

---

## Solution: DP with Bitmask Row State — O(m * n * 3^n * introvertsCount * extrovertsCount) time

**Idea:** Process the grid row by row. The state for each row is the placement of the previous row (each cell: 0=empty, 1=introvert, 2=extrovert). Use memoized recursion with the current cell position, remaining introverts/extroverts, and the previous row's bitmask.

**Algorithm:**
1. For each cell in row order, try placing 0 (empty), 1 (introvert), or 2 (extrovert).
2. Compute happiness delta based on left and top neighbors.
3. Memoize by `(pos, introvertsLeft, extrovertsLeft, prevRowMask)`.
4. Return the maximum happiness sum.

**Complexity:**

| | |
|---|---|
| Time | O(m * n * 3^n * in * ex) where in,ex ≤ 6 |
| Space | O(n * 3^n * in * ex) — memoization table |
