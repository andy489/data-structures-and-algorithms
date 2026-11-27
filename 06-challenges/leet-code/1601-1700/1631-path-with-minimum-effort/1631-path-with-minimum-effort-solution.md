# 1631. Path With Minimum Effort — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/path-with-minimum-effort/

---

## Solution: Dijkstra's Algorithm — O(rows * cols * log(rows * cols)) time, O(rows * cols) space

**Idea:** Use Dijkstra's algorithm where the "cost" of reaching a cell is the maximum absolute difference encountered along the path so far. The priority queue processes cells in order of their minimum-effort cost.

**Algorithm:**
1. Initialize `effort[0][0] = 0`; all other cells to infinity.
2. Use a min-heap `(effort, row, col)`.
3. For each cell popped, explore 4 neighbors. The cost to reach a neighbor is `max(currentEffort, |heights[row][col] - heights[nr][nc]|)`.
4. If this cost is less than stored effort, update and push to heap.
5. Return `effort[rows-1][cols-1]` when reached.

**Complexity:**

| | |
|---|---|
| Time | O(rows * cols * log(rows * cols)) — Dijkstra on a grid |
| Space | O(rows * cols) — effort array and priority queue |
