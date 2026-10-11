# 120F. Spiders — Solution

---

## Key Insight

When merging two trees by identifying one node from each, we can connect any node of one tree to any node of the other at zero additional edge cost (the merged node bridges them). This means the **maximum diameter** of the merged structure is the sum of the two **longest arms** (longest paths from any node to a leaf) contributed by each tree.

To maximize the final diameter:
1. Compute, for each spider, the **two longest paths from a single root** (the two longest branches from any node — i.e., the diameter endpoints' half-paths).
2. Greedily connect spiders by merging at their highest-degree nodes, summing up the longest arms.

---

## Algorithm

### Per-Tree Preprocessing

For each tree:
- Root it arbitrarily.
- For each node, compute `depth[v]` = length of longest path from `v` downward.
- The **two longest arms from a node** are the two largest `depth` values among its children.
- The **local diameter** contribution from node `v` = sum of its two longest arms.
- Track the **maximum arm** of the entire tree (longest path from any one node to a leaf).

### Combining Trees

After computing the maximum arm for each spider:
- Sort arms in descending order.
- The merged diameter = sum of the two largest arms from any pair of trees + 1 (for the merged edge between them), then extend by adding more trees' arms if they can be attached to the same merge point.

The optimal strategy is greedy: take the two largest arms (from possibly different trees) and sum them. The result is the maximum possible diameter.

---

## Complexity

| | |
|---|---|
| Time | O(n · max_nodes²) — tree DP per spider |
| Space | O(n · max_nodes) |
