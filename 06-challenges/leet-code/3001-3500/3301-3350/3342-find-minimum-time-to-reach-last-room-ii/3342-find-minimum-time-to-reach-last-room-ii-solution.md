# 3342. Find Minimum Time to Reach Last Room II — Solution

## Approach: Dijkstra's Algorithm with Alternating Step Cost

This is an extension of problem 3341. The move cost alternates: the 1st move costs 1 second, the 2nd costs 2 seconds, the 3rd costs 1 second, etc. We track the parity of the move count as part of our Dijkstra state.

**State:** `(time, row, col, parity)` where `parity` is 0 for a 1-second move next, 1 for a 2-second move next.

**Steps:**
1. Initialize min-heap with `(0, 0, 0, 0)`.
2. `dist[r][c][p]` = minimum time to reach `(r,c)` with parity `p`.
3. For each adjacent cell `(nr, nc)`:
   - `cost = 1` if `parity == 0`, else `cost = 2`.
   - `arrive = max(t, moveTime[nr][nc]) + cost`.
   - New parity = `1 - parity`.

## Complexity

- **Time:** O(n * m * log(n * m)) — Dijkstra with 2× states.
- **Space:** O(n * m) — dist array and heap.
