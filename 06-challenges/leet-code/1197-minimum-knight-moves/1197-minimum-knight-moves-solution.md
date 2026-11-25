# 1197. Minimum Knight Moves — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-knight-moves/

---

## Solution: BFS — O(|x|*|y|) time, O(|x|*|y|) space

**Idea:** BFS from (0,0) to (x,y). Use symmetry: convert to first quadrant.

**Algorithm:**
1. Use abs(x), abs(y) due to 8-way symmetry.
2. BFS on grid. Each node expands to 8 knight moves.
3. Return distance when target is reached.

**Complexity:**

| | |
|---|---|
| Time | O(|x|*|y|) |
| Space | O(|x|*|y|) |
