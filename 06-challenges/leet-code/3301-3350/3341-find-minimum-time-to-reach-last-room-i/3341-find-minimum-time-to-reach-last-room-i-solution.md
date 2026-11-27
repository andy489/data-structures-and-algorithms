# 3341. Find Minimum Time to Reach Last Room I — Solution

## Approach: Dijkstra's Algorithm

This is a shortest-path problem on a grid graph. We use Dijkstra's algorithm where the state is `(time, row, col)`. Moving to an adjacent room costs 1 second, but we cannot enter until `moveTime[r][c]` has passed.

**Steps:**
1. Initialize a min-heap with `(0, 0, 0)` (time=0, row=0, col=0).
2. Maintain a `dist` matrix initialized to infinity except `dist[0][0] = 0`.
3. For each state popped from the heap:
   - If we've reached `(n-1, m-1)`, return current time.
   - For each of the 4 adjacent cells `(nr, nc)`:
     - Arrival time = `max(dist[r][c], moveTime[nr][nc]) + 1`.
     - If this arrival time improves `dist[nr][nc]`, update and push to heap.

## Complexity

- **Time:** O(n * m * log(n * m)) — Dijkstra on n×m grid.
- **Space:** O(n * m) — for dist matrix and heap.
