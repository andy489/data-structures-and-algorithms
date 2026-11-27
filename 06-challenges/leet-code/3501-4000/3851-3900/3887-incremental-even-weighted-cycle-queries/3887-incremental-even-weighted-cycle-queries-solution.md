# Solution: 3887. Incremental Even-Weighted Cycle Queries

## Approach: Weighted DSU (Disjoint Set Union)

The key insight is that all cycles in a graph have even weight sum if and only if the graph is **2-colorable with parity** — i.e., we can assign a parity (0 or 1) to each node such that for every edge (u, v, w), the XOR of parities of u and v equals w % 2.

This is equivalent to maintaining a **bipartite-like weighted DSU** where each node stores its **parity relative to its root**.

### Algorithm

For each edge `(u, v, w)`:
1. Find the roots of `u` and `v` with their accumulated parities.
2. If `u` and `v` are in different components, merge them. The new parity relation is determined by the edge weight.
3. If `u` and `v` are in the same component, check if `parity[u] XOR parity[v] == w % 2`. If yes, adding this edge keeps all cycles even-weighted, so count it. Otherwise, skip.

### Why It Works

A cycle formed by adding edge `(u, v, w)` when `u` and `v` are already connected has weight equal to `path_weight(u, v) + w`. The path weight parity equals `parity[u] XOR parity[v]`. For the cycle to have even weight sum, we need `parity[u] XOR parity[v] == w % 2`.

If this holds for every edge added, then every cycle has even sum.

## Complexity

- **Time:** O(E * α(N)) where α is the inverse Ackermann function (nearly O(1) per operation)
- **Space:** O(N) for the DSU arrays
