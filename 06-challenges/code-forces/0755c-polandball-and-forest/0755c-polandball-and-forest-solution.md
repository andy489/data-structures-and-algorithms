# 755C. PolandBall and Forest — Solution

---

## Key Insight

If *pᵢ* = *i*, then node *i* is its own farthest relative — it must be a **root** of its tree (an isolated node or a node equidistant from all others, where it is the center). Each such self-referencing node corresponds to exactly one tree.

For other nodes, *i* and *pᵢ* are in the **same tree**, so we union them.

The answer is simply the **number of nodes *i* where *pᵢ* = *i*** — each such node is a distinct tree root.

---

## Algorithm

### Observation-Based (O(n))

1. Count nodes where `p[i] == i`.
2. That count is the answer.

**Why this works:** In a tree, the "most distant relative with smallest ID" of a root *r* may or may not be itself. However, the construction guarantees that exactly the **roots** of each tree satisfy `p[i] == i`. For any non-root node, its farthest relative is always some other node.

### DSU Approach (for verification / alternative)

1. Initialize DSU with *n* components.
2. For each *i*: if `p[i] != i`, union(i, p[i]).
3. Count distinct components.

---

## Complexity

| | |
|---|---|
| Time | O(n) for counting; O(n α(n)) for DSU |
| Space | O(n) |
