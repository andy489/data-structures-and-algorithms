# 785. Is Graph Bipartite? — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/is-graph-bipartite/

---

## Solution: BFS 2-Coloring — O(V + E) time, O(V) space

**Idea:** A graph is bipartite iff it can be 2-colored with no two adjacent nodes sharing the same color. BFS from each unvisited node, alternating colors.

**Algorithm:**
1. For each unvisited node, BFS and color it 0.
2. Each neighbor gets the opposite color; if it already has the same color, return false.
3. Return true if all nodes colored consistently.

**Complexity:**

| | |
|---|---|
| Time | O(V + E) — visit every node and edge |
| Space | O(V) — color array and queue |
