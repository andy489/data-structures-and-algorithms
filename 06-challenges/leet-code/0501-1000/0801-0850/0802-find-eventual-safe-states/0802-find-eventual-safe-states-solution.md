# 802. Find Eventual Safe States — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-eventual-safe-states/

---

## Solution: DFS with Coloring — O(V+E) time, O(V) space

**Idea:** Use 3-color DFS: 0=unvisited, 1=visiting (in current path), 2=safe. A node is safe if all its neighbors are safe and it's not in a cycle.

**Algorithm:**
1. For each unvisited node, run DFS.
2. Mark node as visiting (1). Recurse on neighbors.
3. If any neighbor is visiting → cycle → mark unsafe (stay 1).
4. If all neighbors are safe → mark node safe (2).
5. Collect all nodes with color 2.

**Complexity:**

| | |
|---|---|
| Time | O(V+E) — each node/edge visited once |
| Space | O(V) — color array + recursion stack |
