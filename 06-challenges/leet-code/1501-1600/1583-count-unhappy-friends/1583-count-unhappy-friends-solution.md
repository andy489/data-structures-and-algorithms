# 1583. Count Unhappy Friends — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-unhappy-friends/

---

## Solution: Rank Preprocessing — O(n^2) time, O(n^2) space

**Idea:** Precompute `rank[i][j]` = how highly person `i` ranks person `j` (smaller rank = higher preference). For each person `x` paired with `y`, check every other person `u` paired with `v` to see if both `x` prefers `u` over `y` and `u` prefers `x` over `v`.

**Algorithm:**
1. Build `rank[i][j]` from `preferences`.
2. Build `paired[i]` lookup from `pairs`.
3. For each `x`, iterate over all `u != x, u != paired[x]`. If `rank[x][u] < rank[x][y]` and `rank[u][x] < rank[u][v]`, mark `x` as unhappy and break.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) — for each of n persons, check up to n-2 others |
| Space | O(n^2) — rank table |
