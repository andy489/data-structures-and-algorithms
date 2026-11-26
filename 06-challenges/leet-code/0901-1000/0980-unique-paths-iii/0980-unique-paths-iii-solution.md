# 980. Unique Paths III — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/unique-paths-iii/

---

## Solution: DFS Backtracking — O(4^(m*n)) time, O(m*n) space

**Idea:** DFS with backtracking, counting paths that visit all non-obstacle squares.

**Algorithm:**
1. Find start, count non-obstacle squares.
2. DFS: mark visited, recurse in 4 directions, unmark (backtrack).
3. At end cell, check if all squares visited.

**Complexity:**

| | |
|---|---|
| Time | O(4^(m*n)) — worst case |
| Space | O(m*n) — recursion |
