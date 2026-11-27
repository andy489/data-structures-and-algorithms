# 1192. Critical Connections in a Network — Solution

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/critical-connections-in-a-network/

---

## Solution: Tarjan's Bridge-Finding Algorithm — O(V + E) time, O(V + E) space

**Idea:** A bridge (critical connection) is an edge `(u, v)` such that removing it disconnects the graph. Tarjan's algorithm finds all bridges in one DFS pass using two arrays:
- `disc[u]`: discovery time of node `u`.
- `low[u]`: the lowest discovery time reachable from the subtree rooted at `u` via back edges.

An edge `(u, v)` is a bridge if and only if `low[v] > disc[u]` after the DFS from `u` to `v`.

**Algorithm:**
1. Build an adjacency list.
2. Run DFS. For each node `u` visited at time `timer`:
   - Set `disc[u] = low[u] = timer++`.
   - For each neighbour `v`:
     - Skip the parent edge.
     - If `v` is unvisited: recurse, then update `low[u] = min(low[u], low[v])`. If `low[v] > disc[u]`, record `(u, v)` as a bridge.
     - If `v` is visited: update `low[u] = min(low[u], disc[v])`.
3. Return all recorded bridges.

**Complexity:**

| | |
|---|---|
| Time | O(V + E) — single DFS |
| Space | O(V + E) — adjacency list, disc/low arrays, call stack |
