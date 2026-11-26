# 329. Longest Increasing Path in a Matrix — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/longest-increasing-path-in-a-matrix/

---

## Solution: DFS + Memoization — O(m*n) time, O(m*n) space

**Idea:** For each cell, DFS to find the longest increasing path starting from it. Cache results in a memo array to avoid recomputation (each cell is computed once).

**Algorithm:**
1. For each cell `(r, c)`, call `dfs(r, c, memo)`.
2. `dfs(r, c)`: if `memo[r][c] > 0`, return it. Otherwise, for each of 4 neighbors `(nr, nc)` where `matrix[nr][nc] > matrix[r][c]`, recursively call `dfs(nr, nc)`.
3. `memo[r][c] = 1 + max(dfs over valid neighbors)`.
4. Return `max(memo[r][c])` over all cells.

**Complexity:**

| | |
|---|---|
| Time | O(m*n) — each cell computed once |
| Space | O(m*n) — memo table + call stack |
