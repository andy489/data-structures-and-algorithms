# 1293. Shortest Path in a Grid with Obstacles Elimination — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/shortest-path-in-a-grid-with-obstacles-elimination/

---

## Solution: BFS with State (r, c, k_remaining) — O(m*n*k) time, O(m*n*k) space

**Idea:** BFS where state includes remaining eliminations. Use Manhattan distance heuristic: if remaining >= distance, return distance directly.

**Algorithm:**
1. If k >= m+n-2: return m+n-2 directly (shortcut).
2. BFS state: (r, c, eliminations_left).
3. Track visited[r][c][k] to avoid revisiting.
4. Return steps when reaching (m-1, n-1).

**Complexity:**

| | |
|---|---|
| Time | O(m*n*k) |
| Space | O(m*n*k) |
