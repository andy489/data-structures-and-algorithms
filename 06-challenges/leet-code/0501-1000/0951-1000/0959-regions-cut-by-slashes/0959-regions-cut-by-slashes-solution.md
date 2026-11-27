# 959. Regions Cut By Slashes — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/regions-cut-by-slashes/

---

## Solution: Scale Up Grid + BFS — O(n²) time, O(n²) space

**Idea:** Scale each cell to 3x3 to represent slashes as walls, then count connected components.

**Algorithm:**
1. Create a `3n x 3n` grid, filling slash/backslash cells.
2. Count connected components via BFS/DFS.

**Complexity:**

| | |
|---|---|
| Time | O(n²) |
| Space | O(n²) |
