# Solution for 3905. Multi Source Flood Fill

## Approach

**Multi-source BFS:**

1. Initialize a grid of size `n × m` with zeros.
2. Place initial source colors on the grid.
3. Use a BFS queue initialized with all source cells.
4. At each BFS step, expand to uncolored adjacent cells. When a cell is first reached, assign the spreading color.
5. If multiple sources reach the same cell at the same step, assign the **maximum** color.

**Implementation detail for simultaneous spread:** Use a standard BFS. When a cell is first visited, it gets the color of whoever enqueued it. For the max-color tie-breaking, we need to track the "arrival time" (BFS level). We can process BFS level by level and for each uncolored cell reached in the same level, track the maximum color from all spreading sources.

**Optimized approach:** Sort sources by processing order doesn't matter for single-step. The key insight: BFS naturally processes by distance. For the max-color rule, when multiple sources can reach a cell at the same step, we want the maximum.

**Algorithm:**
- Use a `dist` array initialized to -1 (unvisited).
- Initialize `dist[source] = 0` and `color[source] = color_i`.
- BFS: when processing cell `(r, c)` with color `col`, for each neighbor `(nr, nc)`:
  - If unvisited: set dist, color, enqueue.
  - If `dist[nr][nc] == dist[r][c] + 1` (same distance): update color to `max(color[nr][nc], col)`.

## Complexity

- Time: O(n * m)
- Space: O(n * m)
