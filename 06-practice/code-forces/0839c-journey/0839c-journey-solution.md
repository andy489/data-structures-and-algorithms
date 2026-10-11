# 839C. Journey — Solution

---

## Key Insight

The horse moves from the current node to one of its unvisited neighbors uniformly at random, and "unvisited" means it won't go back to the parent. So effectively, from any node *v* with *k* children, the horse picks one child uniformly at random and continues.

Define `E[v]` = expected distance from *v* to the leaf where the journey ends (counting from *v*):
- Leaf: `E[v] = 0`
- Internal node with children `c₁, ..., cₖ`: `E[v] = 1 + (E[c₁] + ... + E[cₖ]) / k`

The answer is `E[1]`.

---

## Algorithm

### DFS Tree DP

1. Root the tree at node 1.
2. Post-order DFS:
   - If *v* is a leaf (no children): `E[v] = 0.0`
   - Otherwise: `E[v] = 1.0 + average(E[child] for all children of v)`
3. Return `E[1]`.

**Why this is correct:** The horse does not revisit nodes (it only moves to unvisited neighbors). Since the tree has no cycles, once the horse enters a subtree it never exits. From each internal node it picks uniformly among its children in the rooted tree.

---

## Complexity

| | |
|---|---|
| Time | O(n) — single DFS |
| Space | O(n) — recursion stack |
