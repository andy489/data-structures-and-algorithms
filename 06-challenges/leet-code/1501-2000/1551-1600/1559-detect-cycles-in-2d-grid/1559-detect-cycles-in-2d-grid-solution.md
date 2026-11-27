# 1559. Detect Cycles in 2D Grid — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/detect-cycles-in-2d-grid/

---

## Solution: Union-Find — O(m * n * alpha) time, O(m * n) space

**Idea:** Use Union-Find. For each cell, try to union it with its right and bottom neighbors (same character only). If the two cells are already in the same component, we've found a cycle of length >= 4.

**Algorithm:**
1. Initialize a Union-Find over all `m * n` cells.
2. Iterate cells in row-major order; for each, try to union with right and down neighbors of the same character.
3. If find(a) == find(b) before union, a cycle exists.

**Complexity:**

| | |
|---|---|
| Time | O(m * n * alpha) — essentially O(m * n) with path compression and union by rank |
| Space | O(m * n) — parent and rank arrays |
