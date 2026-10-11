# 981C. Useful Decomposition — Solution

---

## Key Insight

For all paths to share a common vertex, there must exist a **central vertex** *c* such that every path passes through *c*. This is possible only when the tree has **at most one vertex with degree ≥ 3** (a "star-like" structure centered at *c*).

**When is a valid decomposition impossible?**  
If there are two or more vertices with degree ≥ 3, the paths through those vertices cannot all share a single common vertex — output `No`.

**When it is possible:**
- If **all vertices have degree ≤ 2**: the tree is a path. One path covers all edges: `(leaf1, leaf2)`.
- If **exactly one vertex *c* has degree ≥ 3**: *c* is the center. Each path goes from a leaf to another leaf through *c*, or from *c* to a leaf if the tree is star-shaped. Specifically, pair up the leaves via *c*: each path is `(leaf, c)` for each branch ending in a leaf (for a pure star) or `(leaf₁, leaf₂)` for paths that can be merged through *c*.

**Simpler formulation:** The center is always the unique high-degree node (or any node in the path case). Each path starts at a leaf of a subtree hanging off the center and ends at the center (or another leaf through the center). Since the tree must have paths sharing *c*, each path connects two leaves via *c* (when possible) or is a single edge from *c* to a leaf.

---

## Algorithm

1. Find all vertices with degree ≥ 3. If count > 1: output `No`.
2. If count == 0 (it's a path): find the two leaves (degree-1 vertices), output one path between them.
3. If count == 1 (center *c*): find all leaves of the tree. Each leaf `l` yields a path `(l, c)`. Output all these paths.

---

## Complexity

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
