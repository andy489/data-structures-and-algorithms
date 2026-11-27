# 1591. Strange Printer II — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/strange-printer-ii/

---

## Solution: Topological Sort — O(m*n + C^2) time, O(C^2) space

**Idea:** Each color's bounding rectangle must be printed before any color that overlaps it (the overlapping color is painted on top). Build a dependency graph and check for cycles via topological sort.

**Algorithm:**
1. Find the bounding rectangle (top/bottom/left/right) for each color.
2. For each color `c`, any different color within its bounding box must be painted after `c` — add `c -> other` dependency.
3. Perform topological sort (BFS/Kahn's). If all used colors are processed, return true; otherwise a cycle exists.

**Complexity:**

| | |
|---|---|
| Time | O(m*n + C^2) — bounding-box scan + dependency check between C=60 colors |
| Space | O(C^2) — dependency sets |
