# ABCPATH. ABC Path — Solution

**Problem ID:** 9921
**Link:** https://www.spoj.com/problems/ABCPATH/

---

## Solution: BFS/DFS with DP Memoization — O(H·W·26) time, O(H·W) space

**Idea:** For each cell, precompute the length of the longest consecutive-letter path starting from that cell. A cell with letter `L` can extend to any 8-directional neighbour containing `L+1`. We process cells in reverse alphabetical order (Z first, then Y, ..., A) so that when computing a cell's value, all its successors are already computed. The answer is `max(dp[i][j])` over all cells containing 'A', where `dp[i][j]` is 1 plus the best reachable extension.

**Algorithm:**
1. Read the grid.
2. Initialize `dp[i][j] = 1` for every cell (a single letter always forms a path of length 1).
3. For letters `c` from `'Z'-1` down to `'A'` (i.e., `'Y'` down to `'A'`): for each cell `(i,j)` with grid value `c`, check all 8 neighbours. If a neighbour contains `c+1`, update `dp[i][j] = max(dp[i][j], 1 + dp[ni][nj])`.
4. Answer = `max(dp[i][j])` for all cells where `grid[i][j] == 'A'`.

**Complexity:**

| | |
|---|---|
| Time | O(H·W·26) — at most 26 passes over the grid |
| Space | O(H·W) — dp table |
