# 1462. Course Schedule Iv — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/course-schedule-iv/

---

## Solution: Floyd-Warshall Transitive Closure — O(n^3) time, O(n^2) space

**Idea:** Build a reachability matrix using Floyd-Warshall. reach[i][j] = true if course i is a prerequisite of j.

**Algorithm:**
1. Initialize reach[u][v] = true for each prerequisite.
2. Floyd-Warshall: for each k, reach[i][j] |= reach[i][k] && reach[k][j].
3. Answer each query with reach[u][v].

**Complexity:**

| | |
|---|---|
| Time | O(n^3) |
| Space | O(n^2) |
