# 1706. Where Will the Ball Fall — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/where-will-the-ball-fall/

---

## Solution: Simulation — O(m * n) time, O(n) space

**Idea:** Simulate each ball independently. For each row, determine the next column based on the current board direction. A ball gets stuck if:
- It's at the right wall and the board redirects right (`grid[r][c] == 1`).
- It's at the left wall and the board redirects left (`grid[r][c] == -1`).
- Two adjacent boards form a "V": `grid[r][c] == 1` and `grid[r][c+1] == -1`, or `grid[r][c] == -1` and `grid[r][c-1] == 1`.

**Algorithm:**
1. For each ball starting at column `j`, simulate row by row.
2. At each row, compute next column; if stuck, record -1.
3. After all rows, record the final column.

**Complexity:**

| | |
|---|---|
| Time | O(m * n) — simulate each of n balls through m rows |
| Space | O(n) — output array |
