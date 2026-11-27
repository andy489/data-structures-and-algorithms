# 1110. Delete Nodes and Return Forest — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/delete-nodes-and-return-forest/

---

## Solution: Post-order DFS — O(n) time, O(n + d) space

**Idea:** Use post-order DFS (process children before parent). After recursing into children, decide whether to delete the current node. If a node is deleted, its non-null children become new roots of separate trees. The parent's pointer to this node becomes null.

**Algorithm:**
1. Put all values to delete into a hash set for O(1) lookup.
2. DFS the tree. The function takes a node and a boolean `isRoot`:
   - If `node` is null, return null.
   - Determine `deleted = node.val in deleteSet`.
   - If `!deleted && isRoot`, add `node` to the result list.
   - Recurse: `node.left = dfs(node.left, deleted)`, `node.right = dfs(node.right, deleted)`.
   - Return `deleted ? null : node` to the parent (nulls out deleted nodes).
3. Collect all roots and return them.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each node is visited once |
| Space | O(n + d) — recursion stack O(h), hash set O(d), result O(r) |
