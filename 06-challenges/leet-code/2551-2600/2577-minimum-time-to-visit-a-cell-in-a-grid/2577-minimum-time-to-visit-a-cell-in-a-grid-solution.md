# Solution: 2577. Minimum Time to Visit a Cell In a Grid

## Approach: Dijkstra's Algorithm with Parity Trick

This is a shortest path problem on a grid where the constraint is `time >= grid[r][c]`.

**Key Insight:** From the starting cell `(0,0)`, we can always go back and forth between two adjacent cells to "wait" for the right time. If we need to wait at a cell, the minimum extra time we can burn is by bouncing between two cells (each bounce costs 2 seconds).

**Edge Case:** If `grid[0][1] > 1` and `grid[1][0] > 1`, we cannot even leave the starting cell, so return `-1`.

**Algorithm:**
1. Use Dijkstra with a min-heap.
2. When trying to reach cell `(r, c)` at time `t`:
   - We need `t >= grid[r][c]`.
   - If `t < grid[r][c]`, we may need to wait. We can reach at time `grid[r][c]` if `(grid[r][c] - t) % 2 == 0`, otherwise at `grid[r][c] + 1` (parity adjustment).
   - The actual arrival time = `max(t + 1, grid[r][c] + ((grid[r][c] - t) % 2 == 0 ? 0 : 1))`.
3. Run Dijkstra from `(0, 0, time=0)`.
4. Return `dist[m-1][n-1]`.

## Complexity

- **Time:** O(m * n * log(m * n))
- **Space:** O(m * n)
