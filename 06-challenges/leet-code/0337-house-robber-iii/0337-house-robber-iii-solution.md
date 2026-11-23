# 337. House Robber III — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/house-robber-iii/

---

## Solution: DFS with Pair Return — O(n) time, O(n) space

**Idea:** For each node, return a pair `(robThis, skipThis)` where `robThis` is the max if we rob this node, and `skipThis` is the max if we don't. This avoids redundant recomputation.

**Algorithm:**
1. `dfs(node)` returns `int[2]` where `[0] = skip, [1] = rob`.
2. `left = dfs(node.left)`, `right = dfs(node.right)`.
3. `rob = node.val + left[0] + right[0]` (rob this, must skip children).
4. `skip = max(left[0], left[1]) + max(right[0], right[1])` (skip this, can rob or skip children).
5. Return `{skip, rob}`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each node visited once |
| Space | O(n) — recursion stack |
