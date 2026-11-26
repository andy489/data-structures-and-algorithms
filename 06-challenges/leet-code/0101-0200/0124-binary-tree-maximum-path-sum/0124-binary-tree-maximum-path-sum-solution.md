# 124. Binary Tree Maximum Path Sum — Solution

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/binary-tree-maximum-path-sum/

---

## Solution: Post-order DFS — O(n) time, O(h) space

**Idea:** For each node, compute the maximum "gain" it can contribute to its parent (either go left, go right, or take the node alone — never take a negative branch). At the same time, consider using the node as the **apex** of a path that spans both children; update a global maximum if this local sum is better.

**Algorithm:**
1. Define `dfs(node)` that returns the maximum single-branch gain from `node` upward.
2. At each node:
   - Recursively compute `leftGain = max(0, dfs(node.left))` — discard negative branches.
   - Recursively compute `rightGain = max(0, dfs(node.right))`.
   - The path through `node` as apex has sum `node.val + leftGain + rightGain`; update the global answer.
   - Return `node.val + max(leftGain, rightGain)` — the best single-side extension to the parent.
3. Start with `ans = Integer.MIN_VALUE` to handle all-negative trees.

**Complexity:**

| | |
|---|---|
| Time | O(n) — each node visited exactly once |
| Space | O(h) — recursion stack depth equals tree height; O(log n) balanced, O(n) worst case |
