# 133. Clone Graph — Solution

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/clone-graph/

---

## Solution: DFS with HashMap — O(V+E) time, O(V) space

**Idea:** Use a hash map from original node → cloned node as both the visited set and the clone registry.  
Do a DFS from the given node. For each unvisited node, create its clone, record it in the map, then recursively clone all its neighbors and attach them to the clone's neighbor list.

**Algorithm:**
1. If `node` is `null`, return `null`.
2. If `node` is already in the map, return `map[node]` (already cloned).
3. Create `clone = new Node(node.val)` and store `map[node] = clone`.
4. For each `neighbor` in `node.neighbors`, recursively clone it and append to `clone.neighbors`.
5. Return `clone`.

**Why the map is sufficient:**  
The map doubles as a visited guard — if we reach a node already in the map we return its clone immediately, avoiding infinite recursion through cycles.

**Complexity:**

| | |
|---|---|
| Time | O(V + E) — each node and edge visited exactly once |
| Space | O(V) — map + recursion stack, both bounded by the number of nodes |
