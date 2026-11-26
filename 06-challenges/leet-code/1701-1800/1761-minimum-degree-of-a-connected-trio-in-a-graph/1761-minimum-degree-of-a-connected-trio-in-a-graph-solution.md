# 1761. Minimum Degree of a Connected Trio in a Graph — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-degree-of-a-connected-trio-in-a-graph/

---

## Solution: Adjacency Matrix Enumeration — O(n^3) time, O(n^2) space

**Idea:** Since `n <= 400`, we can use an adjacency matrix and enumerate all O(n^3) triples. For each triple `(i, j, k)` that forms a connected trio (all three edges exist), compute its degree as `deg[i] + deg[j] + deg[k] - 6` (subtract 6 for the 3 internal edges counted twice each).

**Algorithm:**
1. Build an adjacency matrix `adj[n+1][n+1]` and degree array `deg[n+1]`.
2. Iterate over all triples `i < j < k`.
3. If `adj[i][j] && adj[j][k] && adj[i][k]`, compute degree = `deg[i] + deg[j] + deg[k] - 6`.
4. Track and return the minimum degree found, or -1 if none.

**Complexity:**

| | |
|---|---|
| Time | O(n^3) — triple nested loop over all node triples |
| Space | O(n^2) — adjacency matrix |
