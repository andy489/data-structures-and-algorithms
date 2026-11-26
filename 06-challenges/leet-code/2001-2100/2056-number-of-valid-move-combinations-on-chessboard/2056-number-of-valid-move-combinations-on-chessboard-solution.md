# 2056. Number of Valid Move Combinations on Chessboard — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/number-of-valid-move-combinations-on-chessboard/

---

## Solution: Backtracking with Simulation — O(8^(2n)) time, O(n) space

**Idea:** Try all possible target positions for each piece, simulate the paths, check no collision.

**Algorithm:**
1. For each piece, enumerate all valid stop positions.
2. Backtrack over assignments.
3. For each assignment, simulate timestep-by-timestep movement.
4. Check no two pieces occupy the same cell at the same time.

**Complexity:**

| | |
|---|---|
| Time | O(8^(2n)) |
| Space | O(n) |
