# 115A. Party — Solution

---

## Key Insight

The manager hierarchy forms a **forest** (collection of trees). Two employees can be in the same group if and only if neither is an ancestor of the other — exactly the definition of an **antichain** in a partial order.

By Dilworth's theorem, the minimum number of chains needed to cover a partial order equals the maximum antichain size... but here we want the **minimum number of antichains to cover** the poset. That equals the length of the **longest chain**.

The longest chain in the manager hierarchy is simply the **maximum depth** of the forest (where depth of a root = 1).

---

## Algorithm

### DFS Approach

1. Build the tree from parent pointers.
2. For each root (node with `pᵢ = -1`), run DFS computing the depth of each node.
3. Return the maximum depth found.

### Iterative / BFS Approach

1. Compute the depth of every node iteratively using BFS from all roots simultaneously.
2. Return the maximum depth.

---

## Complexity

| | |
|---|---|
| Time | O(n) — each node visited once |
| Space | O(n) — adjacency list + depth array |
