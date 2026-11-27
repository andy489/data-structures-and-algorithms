# 498. Diagonal Traverse — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/diagonal-traverse/

---

## Solution: Direction Simulation — O(m·n) time, O(1) space

**Idea:** Traverse diagonals one at a time. Each diagonal d has elements where row+col=d. Even diagonals go up-right, odd go down-left. Handle boundary bounces.

**Algorithm:**
1. Walk with (row, col) and direction flag goingUp.
2. When goingUp: move row-1, col+1. If out of bounds, bounce.
3. When goingDown: move row+1, col-1. If out of bounds, bounce.
4. Use boundary conditions to adjust position when hitting walls.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) — visit each cell once |
| Space | O(1) extra (excluding output array) |
