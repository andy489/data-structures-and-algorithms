# 236. Lowest Common Ancestor of a Binary Tree — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/

---

## Solution: Recursive Post-order — O(n) time, O(H) space

**Idea:** Recurse into both subtrees. If a node equals `p` or `q`, return it. If both children return non-null, the current node is the LCA. Otherwise propagate the non-null child upward.

**Algorithm:**
1. Base: if `root == null || root == p || root == q` return `root`.
2. `left = lca(root.left, p, q)`, `right = lca(root.right, p, q)`.
3. If both non-null → return `root`; else return whichever is non-null.

**Complexity:**

| | |
|---|---|
| Time | O(n) — visits every node |
| Space | O(H) — recursion stack |
