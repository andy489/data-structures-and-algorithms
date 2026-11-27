# 1034. Coloring A Border — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/coloring-a-border/

---

## Solution: BFS + Border Detection — O(m*n) time, O(m*n) space

**Idea:** BFS from (row, col) to find the connected component. A cell is a border cell if it's on the grid edge or has a 4-directional neighbor not in the component.

**Algorithm:**
1. BFS to collect all cells in the connected component.
2. For each cell, check if it's a border (edge of grid or neighbor with different original color).
3. Color border cells.

**Complexity:**

| | |
|---|---|
| Time | O(m*n) |
| Space | O(m*n) |
