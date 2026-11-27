# 2556. Disconnect Path in a Binary Matrix by at Most One Flip — Solution

## Approach: Two DFS/BFS Passes

**Key Insight:** If flipping one cell can disconnect the path, then there exists a cell that lies on ALL paths from `(0,0)` to `(m-1,n-1)` (a "bridge" or "cut vertex" in terms of grid paths). 

**Algorithm:**
1. Run DFS from `(0,0)` marking visited cells. If no path exists initially, return `true`.
2. Mark visited cells as `0` (temporarily) during the first DFS to "use up" these cells.
3. Run DFS again from `(0,0)`. If the second DFS also finds a path, then there are at least 2 vertex-disjoint paths — we cannot disconnect with one flip, return `false`.
4. If the second DFS fails to find a path, then all paths share a cell — we can disconnect by flipping it, return `true`.

**Why this works:** If the grid has two vertex-disjoint paths (excluding start/end), no single internal cell flip can disconnect both. If only one such path exists, flipping the unique bottleneck disconnects.

## Complexity

- **Time:** O(m * n) — two DFS traversals
- **Space:** O(m * n) — recursion stack / visited state
