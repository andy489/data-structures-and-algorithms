# 886. Possible Bipartition — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/possible-bipartition/

---

## Solution: BFS Graph Coloring — O(n + e) time, O(n + e) space

**Idea:** Build undirected graph. Try 2-coloring with BFS. If a conflict is found (adjacent nodes same color), return false.

**Complexity:**

| | |
|---|---|
| Time | O(n + e) |
| Space | O(n + e) |
