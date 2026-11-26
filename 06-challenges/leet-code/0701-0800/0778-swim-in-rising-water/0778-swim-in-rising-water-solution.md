# 778. Swim in Rising Water — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/swim-in-rising-water/

---

## Solution: Min-Heap (Dijkstra-style) — O(n² log n) time, O(n²) space

**Idea:** Use a min-heap where each entry is `(max_elevation_seen, row, col)`. The answer is the minimum bottleneck path from (0,0) to (n-1,n-1), i.e., the path that minimizes the maximum elevation. This is classic Dijkstra on a max-edge bottleneck.

**Algorithm:**
1. Push `(grid[0][0], 0, 0)` to heap.
2. Pop minimum; if destination reached, return max elevation.
3. Push unvisited neighbors with `max(current_max, grid[nr][nc])`.

**Complexity:**

| | |
|---|---|
| Time | O(n² log n) — each cell pushed once |
| Space | O(n²) — heap and visited set |
