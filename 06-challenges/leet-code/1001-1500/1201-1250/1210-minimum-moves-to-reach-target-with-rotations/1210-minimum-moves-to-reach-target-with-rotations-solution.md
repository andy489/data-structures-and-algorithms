# 1210. Minimum Moves to Reach Target with Rotations — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-moves-to-reach-target-with-rotations/

---

## Solution: BFS — O(n²) time, O(n²) space

**Idea:** BFS on state (row, col, direction) where direction is 0=horizontal, 1=vertical. The head is at (row, col), tail extends right (horizontal) or down (vertical).

**Algorithm:**
1. State: (r, c, dir) where dir=0 horizontal, dir=1 vertical.
2. BFS: try move right, move down, rotate CW, rotate CCW.
3. Return steps when reaching target state.

**Complexity:**

| | |
|---|---|
| Time | O(n²) |
| Space | O(n²) |
