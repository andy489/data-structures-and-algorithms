# 2101. Detonate the Maximum Bombs — Solution

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/detonate-the-maximum-bombs/

---

## Solution: BFS/DFS on Directed Graph — O(n^3) time, O(n^2) space

**Idea:** Build a directed graph where there is an edge from bomb `i` to bomb `j` if bomb `j` lies within the range of bomb `i`. Then for each starting bomb, do a BFS/DFS to count how many bombs can be chain-detonated. Return the maximum count.

A bomb `j` is within range of bomb `i` if the Euclidean distance between centers is less than or equal to `ri` (the radius of bomb `i`). To avoid floating-point issues, compare `dist^2 <= ri^2`, i.e., `(x2-x1)^2 + (y2-y1)^2 <= ri^2`.

**Algorithm:**
1. For each pair `(i, j)`, add a directed edge `i -> j` if `(xj-xi)^2 + (yj-yi)^2 <= ri^2`.
2. For each bomb `i` as start, run BFS and count reachable nodes.
3. Return the maximum count.

**Complexity:**

| | |
|---|---|
| Time | O(n^3) — O(n^2) to build graph, O(n^2) per BFS, n starts |
| Space | O(n^2) — adjacency list |
