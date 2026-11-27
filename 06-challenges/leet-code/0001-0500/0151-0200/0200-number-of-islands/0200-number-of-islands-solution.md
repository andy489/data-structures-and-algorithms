# 200. Number of Islands — Solution

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/number-of-islands/

---

## Solution: DFS with in-place marking — O(m·n) time, O(m·n) space

**Idea:** Iterate over every cell. Whenever a `'1'` is found, increment the island counter and trigger a DFS that sinks the entire connected land mass by overwriting each visited cell with `'0'`. This avoids a separate visited array while still preventing revisits.

The four neighbours are encoded in a single 5-element array `DIRS = {-1, 0, 1, 0, -1}`: consecutive pairs `(DIRS[k], DIRS[k+1])` for `k = 0..3` yield `(-1,0)`, `(0,1)`, `(1,0)`, `(0,-1)` — up, right, down, left.

**Algorithm:**
1. For each cell `(r, c)` where `grid[r][c] == '1'`:
   - Increment `count`.
   - Call `dfs(r, c)` to mark all reachable land cells as `'0'`.
2. In `dfs(r, c)`:
   - Return if out of bounds or `grid[r][c] != '1'`.
   - Set `grid[r][c] = '0'`.
   - Recurse on all four neighbours via the `DIRS` loop.
3. Return `count`.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) — each cell visited at most twice (outer scan + DFS sink) |
| Space | O(m·n) — recursion stack in the worst case (all land, snake-shaped) |

---

## Solution 2: BFS with in-place marking — O(m·n) time, O(min(m,n)) space

**Idea:** Same traversal logic as DFS but driven by a BFS queue. The queue at any moment holds only cells on the frontier of the current island, so its size is bounded by the shorter grid dimension.

**Algorithm:**
1. For each unvisited land cell `(r, c)`:
   - Increment `count`, mark it `'0'`, and enqueue it.
   - While the queue is non-empty:
     - Dequeue a cell and explore all four neighbours via the `DIRS` loop.
     - For each neighbour that is `'1'`, mark it `'0'` and enqueue it.
2. Return `count`.

**Complexity:**

| | |
|---|---|
| Time | O(m·n) — each cell enqueued at most once |
| Space | O(min(m, n)) — BFS queue width bounded by the shorter dimension |
