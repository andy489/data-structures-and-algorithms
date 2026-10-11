# 1325C. Ehab and Path-etic MEXs — Solution

---

## Key Insight

The maximum MEX over all paths is at least 2 if there exists any path containing both edges labeled 0 and 1. We want to **avoid** placing 0 and 1 on edges that share a common path — meaning they must **not** lie on a single root-to-leaf path.

The optimal strategy is to place the small labels (0, 1, 2, ...) on edges that connect the same pair of "branch points", so no path is forced to traverse both. Specifically:

**Place labels 0, 1, ..., k on edges incident to the same vertex** (i.e., they all share an endpoint). Any path passes through at most one edge from this group (since they all emanate from the same node and diverge immediately). Thus the MEX of any path using edges from this set is at most 1 (it sees at most one of {0,1,...,k}).

**Goal:** Assign as many small labels as possible to edges incident to the same node. The optimal result has maximum MEX = 2, achieved when 0 and 1 cannot appear on the same path.

---

## Algorithm

1. For each node, collect its incident edges.
2. Assign labels greedily: assign label 0 to an edge incident to a node, label 1 to another edge of the **same node** (so 0 and 1 share a vertex — they can't be on a simple path together without the common vertex "breaking" the path).
3. Specifically: find the node with highest degree. Assign labels `0, 1, ..., deg-1` to its edges. Assign remaining labels `deg, deg+1, ...` to remaining edges in any order.
4. Since all edges assigned small labels share a vertex, no simple path can contain two of them.

**Why maximum MEX = 2:** No path contains both 0 and 1 (they share a vertex, so any path through them must start/end at that vertex — but a path visits each vertex at most once, so it can only contain one of the edges incident there). Thus MEX of any path is ≤ 2.

---

## Complexity

| | |
|---|---|
| Time | O(n) — compute degrees + assign labels |
| Space | O(n) |
