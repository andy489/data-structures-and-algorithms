# 580C. Kefa and Park — Solution

---

## Key Insight

DFS/BFS from the root, tracking the current consecutive cat streak on the path. If the streak exceeds *m*, **prune** that entire subtree (do not recurse further). If we reach a **leaf** with streak ≤ *m*, count it.

---

## Algorithm

### DFS with Cat Counter

1. Root the tree at vertex 1 (treat the undirected input as a directed rooted tree during DFS).
2. DFS with state `(node, parent, consecutive_cats)`:
   - If `a[node] == 1`: `consecutive_cats++`, else `consecutive_cats = 0`.
   - If `consecutive_cats > m`: return (prune branch).
   - If `node` is a leaf (no children other than parent): increment answer.
   - Otherwise: recurse into all children.

**Leaf definition:** A node with degree 1 that is not the root. In the DFS, a leaf is a node with no unvisited neighbors (all neighbors are the parent).

---

## Complexity

| | |
|---|---|
| Time | O(n) — each node visited at most once |
| Space | O(n) — recursion stack |
