# 463. Island Perimeter — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/island-perimeter/

---

## Solution: Count Shared Edges — O(m·n) time, O(1) space

**Idea:** Each land cell contributes 4 to the perimeter. Each shared edge between two land cells subtracts 2. Count land cells and shared edges.

**Algorithm:**
1. For each cell `grid[i][j] == 1`: add 4 to perimeter.
2. If the cell to the right is also land, subtract 2.
3. If the cell below is also land, subtract 2.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) — single pass |
| Space | O(1) |
