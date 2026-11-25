# 1042. Flower Planting With No Adjacent — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/flower-planting-with-no-adjacent/

---

## Solution: Greedy Graph Coloring — O(n + E) time, O(n + E) space

**Idea:** Since every node has degree ≤ 3 and we have 4 colors, greedy coloring always works: for each node, pick any color not used by already-colored neighbors.

**Algorithm:**
1. Build adjacency list.
2. For each garden 1..n: collect colors of already-colored neighbors, pick the smallest color not in that set.
3. Assign that color.

**Complexity:**

| | |
|---|---|
| Time | O(n + E) |
| Space | O(n + E) |
