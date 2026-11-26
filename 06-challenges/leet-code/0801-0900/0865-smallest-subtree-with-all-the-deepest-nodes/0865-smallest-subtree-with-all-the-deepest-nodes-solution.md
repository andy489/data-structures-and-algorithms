# 865. Smallest Subtree with all the Deepest Nodes — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/

---

## Solution: DFS returning (depth, LCA) — O(n) time, O(n) space

**Idea:** Post-order DFS. Each call returns (max_depth, lca_node). If left and right subtrees have equal depth, current node is the LCA. Otherwise return the deeper side's (depth+1, lca).

**Algorithm:**
1. Recursive helper returns (depth, node).
2. If left.depth == right.depth: return (left.depth + 1, current node).
3. Else: return (max(left.depth, right.depth) + 1, deeper side's node).

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — recursion stack |
