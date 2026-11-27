# 1123. Lowest Common Ancestor of Deepest Leaves — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/

---

## Solution: DFS — O(n) time, O(h) space

**Idea:** A single DFS pass can simultaneously compute the max depth reachable from each node and determine the LCA. At each node, recurse into both children and get back their (depth, lca) pairs. If the left and right max depths are equal, the current node is the LCA for both subtrees. Otherwise, whichever side is deeper carries forward its LCA unchanged.

**Algorithm:**
1. Define a helper `dfs(node)` that returns `(maxDepth, lca)`.
2. Base case: `null` → `(0, null)`.
3. Recurse left and right.
4. If `leftDepth == rightDepth`: return `(leftDepth + 1, node)`.
5. If `leftDepth > rightDepth`: return `(leftDepth + 1, leftLca)`.
6. Otherwise: return `(rightDepth + 1, rightLca)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each node visited once |
| Space | O(h) — recursion stack, h = tree height |
