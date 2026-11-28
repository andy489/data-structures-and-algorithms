# 2925. Maximum Score After Applying Operations on a Tree — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-score-after-applying-operations-on-a-tree/

---

## Solution: Tree DP (DFS) — O(n) time, O(n) space

**Idea:** The total sum of all values minus the minimum we must keep (to maintain health) equals the maximum score. For each subtree rooted at node `v`, we compute the minimum sum that must stay "alive" on paths through `v`. 

Key insight: at every node, to keep all paths healthy, at least one node on every root-to-leaf path must remain non-zero. We can greedily take everything in a subtree except the minimum cost to keep it healthy. The DFS returns the minimum "kept" sum for each subtree. For a leaf, we must keep its value. For an internal node, we can either keep the node itself (cost = `values[node]`, children can all be zeroed out, returning sum of subtree sums) or keep the minimum across children's kept sums.

**Algorithm:**
1. Build adjacency list from `edges`.
2. DFS from node 0 with parent tracking.
3. For a leaf (no children), return `values[leaf]` as the must-keep cost.
4. For an internal node, let `childSum` = sum of must-keep costs across all children and `subtreeSum` = sum of values in subtree.
   - Option A: keep this node → cost is `values[node]`, we can zero out everything else below.
   - Option B: keep one node per subtree branch → cost is `childSum`.
   - Take the minimum: `min(values[node], childSum)`.
5. Answer = `totalSum - dfs(0, -1)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) |
