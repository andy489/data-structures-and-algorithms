# 862B. Mahmoud and Ehab and the Bipartiteness — Solution

---

## Key Insight

A graph is bipartite if and only if it has **no odd cycles**. A tree is always bipartite. We can 2-color the tree (BFS/DFS from any root), putting nodes into sets **A** (even depth) and **B** (odd depth).

A graph is bipartite if and only if all edges connect a node in A to a node in B (no intra-set edges). The **maximum complete bipartite graph** on sets A and B has `|A| × |B|` edges. We already have `n − 1` tree edges, so:

```
answer = |A| × |B| − (n − 1)
```

---

## Algorithm

1. BFS/DFS from any root, 2-coloring the tree.
2. Count `a = |A|` (even-depth nodes) and `b = |B|` (odd-depth nodes).
3. Return `a * b - (n - 1)`.

**Why this is the maximum:** Any bipartite graph on vertex sets A and B can have at most `|A| × |B|` edges (one between each pair across the bipartition). We subtract the `n − 1` edges already in the tree.

**Note:** The answer should be output as a **64-bit integer** since `a × b` can reach up to 2.5 × 10⁹ for *n* = 10⁵.

---

## Complexity

| | |
|---|---|
| Time | O(n) — single BFS/DFS |
| Space | O(n) |
