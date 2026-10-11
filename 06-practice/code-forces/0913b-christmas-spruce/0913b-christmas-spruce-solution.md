# 913B. Christmas Spruce — Solution

---

## Key Insight

For each non-leaf vertex, count how many of its **direct children** are leaves. If any non-leaf vertex has fewer than 3 leaf children, the answer is `No`.

A vertex is a **leaf** if it has no children (i.e., no other vertex lists it as its parent).

---

## Algorithm

1. Build the tree from parent pointers. Track `children[v]` = list of children of `v`.
2. Identify leaves: vertex `v` is a leaf iff `children[v]` is empty.
3. For every non-leaf vertex `v`:
   - Count how many children of `v` are leaves.
   - If count < 3: output `No` and stop.
4. If all non-leaf vertices pass: output `Yes`.

**Edge case:** The root (vertex 1) is treated like any other non-leaf: it must also have at least 3 leaf children.

---

## Complexity

| | |
|---|---|
| Time | O(n) — build tree + single pass |
| Space | O(n) |
