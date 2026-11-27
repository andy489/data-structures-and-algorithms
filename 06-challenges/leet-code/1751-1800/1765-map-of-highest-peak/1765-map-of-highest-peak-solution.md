# 1765. Map of Highest Peak — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/map-of-highest-peak/

---

## Solution: Multi-Source BFS — O(m*n) time, O(m*n) space

**Idea:** This is essentially a multi-source BFS problem. All water cells have height 0 and are the BFS sources. Each land cell's height equals its minimum BFS distance to any water cell. This maximizes heights while satisfying the adjacency constraint.

**Algorithm:**
1. Initialize a result matrix with -1 (unvisited).
2. Add all water cells to the BFS queue with height 0.
3. Process the queue level by level (BFS), assigning each unvisited neighbor a height of `current + 1`.
4. Return the result matrix.

**Complexity:**

| | |
|---|---|
| Time | O(m*n) — each cell is visited once |
| Space | O(m*n) — queue and result matrix |
