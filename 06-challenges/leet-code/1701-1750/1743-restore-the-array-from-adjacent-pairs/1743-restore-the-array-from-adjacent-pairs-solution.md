# 1743. Restore the Array from Adjacent Pairs — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/restore-the-array-from-adjacent-pairs/

---

## Solution: Graph Traversal (DFS/BFS from Endpoint) — O(n) time, O(n) space

**Idea:** Build an adjacency list (undirected graph). The two endpoints of the array each have degree 1 (only one neighbor). Start DFS from either endpoint and traverse, keeping track of the previous node to avoid going backwards.

**Algorithm:**
1. Build adjacency list from `adjacentPairs`.
2. Find a node with degree 1 — this is the start of the array.
3. Walk the chain: at each step, pick the neighbor that isn't the previous node.
4. Return the resulting array.

**Complexity:**

| | |
|---|---|
| Time | O(n) — single pass to build graph + single traversal |
| Space | O(n) — adjacency list |
