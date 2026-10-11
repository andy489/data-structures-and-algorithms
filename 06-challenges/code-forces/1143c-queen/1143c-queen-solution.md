# 1143C. Queen — Solution

---

## Key Insight

A vertex *v* is deletable when:
1. `c[v] == 1`
2. All children of *v* also have `c == 1` (none of them respects *v*)

When *v* is deleted, its children are re-parented to *v*'s parent. This can make *v*'s parent newly deletable (if *v* was the only child with `c == 0`, removing it might satisfy condition 2 for the parent).

Use a **priority queue (min-heap)** of currently deletable vertices and process them in order.

---

## Algorithm

1. Build the tree and track for each vertex:
   - `c[v]`
   - `children[v]`
   - `cnt0[v]` = number of children with `c == 0`
2. Initialize the heap with all non-root vertices where `c[v] == 1` and `cnt0[v] == 0`.
3. While heap is non-empty:
   - Pop smallest vertex *v*.
   - Output *v*, delete it.
   - Let *par* = parent of *v*.
   - For each child *u* of *v*: re-parent *u* to *par*. Update `cnt0[par]` if `c[u] == 0`.
   - If `c[v] == 0`: decrement `cnt0[par]` (v itself was a child with c=0).
   - If *par* is now deletable (non-root, `c[par] == 1`, `cnt0[par] == 0`): push *par* to heap.
4. If nothing was output: print `-1`.

---

## Complexity

| | |
|---|---|
| Time | O(n log n) — each vertex processed at most once, heap operations |
| Space | O(n) |
