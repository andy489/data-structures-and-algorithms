# 1210. Minimum Moves to Reach Target with Rotations

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-moves-to-reach-target-with-rotations/

---

## Problem Statement

In an `n*n` grid, there is a snake that spans 2 cells and starts moving from the top left corner at `(0, 0)` and `(0, 1)`. The grid has empty cells represented by zeros and blocked cells represented by ones.

The snake wants to reach the lower right corner at `(n-1, n-2)` and `(n-1, n-1)`.

In one move the snake can:
- Move right if there are no blocked cells there.
- Move down if there are no blocked cells there.
- Rotate clockwise if lying horizontally.
- Rotate counterclockwise if lying vertically.

Return the minimum number of moves to reach the target, or -1 if not possible.

---

## Examples

**Example 1:**
```
Input:  grid = [[0,0,0,0,0,1],[1,1,0,0,1,0],[0,0,0,0,1,1],[0,0,1,0,1,0],[0,1,1,0,0,0],[0,1,1,0,0,0]]
Output: 11
```

---

## Constraints

- `2 <= n <= 100`
- `0 <= grid[i][j] <= 1`
- `It is guaranteed that the snake starts at empty cells`
