# 558. Logical OR of Two Binary Grids Represented as Quad-Trees — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/logical-or-of-two-binary-grids-represented-as-quad-trees/

---

## Solution: Recursive Quad-Tree OR — O(n^2) time, O(log n) space

**Idea:** If either node is a leaf-1, result is leaf-1. If either is a leaf-0, result is the other. Otherwise recurse on all 4 children and merge: if all 4 children are leaves with same value, collapse to a leaf.

**Algorithm:**
1. If `node1.isLeaf`: return `node1.val ? node1 : node2`.
2. If `node2.isLeaf`: return `node2.val ? node2 : node1`.
3. Recurse: `topLeft = intersect(node1.topLeft, node2.topLeft)`, similarly for other 3.
4. If all 4 results are leaves with same val, return new leaf with that val.
5. Otherwise return new non-leaf node with 4 children.

**Complexity:**

| | |
|---|---|
| Time | O(n^2) — visit all grid cells |
| Space | O(log n) — recursion depth |
