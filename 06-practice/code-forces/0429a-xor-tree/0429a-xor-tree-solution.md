# 429A. Xor-tree — Solution

---

## Key Insight

An operation on node *x* flips nodes at even depth offset from *x* in its subtree. This means each node's final value depends on **how many times it was covered by an ancestor operation at even depth distance**.

Crucially, operating on node *x* is independent per subtree: it only affects nodes in *x*'s subtree. This allows a **greedy DFS from the root**: process nodes top-down and decide whether to apply an operation at each node based on whether the current node's value matches the goal.

---

## Algorithm

### DFS (Greedy Top-Down)

1. Root the tree at node 1.
2. Compute `diff[v] = initial[v] XOR goal[v]` for each node (1 if needs flipping, 0 otherwise).
3. DFS from root, tracking `flips` — the number of ancestor operations that currently affect this node (i.e., the parity of operations applied at even-distance ancestors).
4. At node *v*:
   - Current effective value = `initial[v] XOR (flips % 2)`.
   - If it doesn't match `goal[v]`: apply an operation at *v*, add *v* to answer, increment `flips`.
   - Recurse into children with updated `flips` (children are at odd distance → they are **unaffected** by an operation at *v*, so `flips` resets for children's perspective as they see +1 distance).

**Precise tracking:** Each node needs to know the parity of how many of its ancestors at even depth offset from it have been operated on. Maintain two counters along the DFS path (even/odd depth flip counts).

---

## Complexity

| | |
|---|---|
| Time | O(n) — single DFS pass |
| Space | O(n) — recursion stack + answer list |
