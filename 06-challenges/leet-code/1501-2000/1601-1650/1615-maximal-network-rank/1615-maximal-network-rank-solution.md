# 1615. Maximal Network Rank — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximal-network-rank/

---

## Solution: Degree Count + Edge Check — O(n^2) time, O(n + e) space

**Idea:** For every pair of cities `(i, j)`, their network rank is `degree[i] + degree[j]`, minus 1 if there is a direct road between them (to avoid double-counting). Track degrees and connectivity during preprocessing, then enumerate all pairs.

**Algorithm:**
1. Build a `degree[]` array and a boolean `connected[][]` adjacency matrix from `roads`.
2. For every pair `(i, j)` with `i < j`, compute `rank = degree[i] + degree[j] - (connected[i][j] ? 1 : 0)`.
3. Return the maximum rank found.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) — O(e) preprocessing + O(n^2) pair enumeration |
| Space | O(n^2) — adjacency matrix; O(n + e) if a hash set is used instead |
