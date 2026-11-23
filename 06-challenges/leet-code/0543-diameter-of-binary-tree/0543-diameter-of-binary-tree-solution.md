# 543. Diameter of Binary Tree — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/diameter-of-binary-tree/

---

## Solution: DFS Post-order — O(n) time, O(h) space

**Idea:** At each node, the longest path through it = left depth + right depth. Track global max while returning depth up.

**Algorithm:**
1. DFS returns depth of subtree.
2. At each node: `leftDepth = dfs(left)`, `rightDepth = dfs(right)`.
3. Update `maxDiameter = max(maxDiameter, leftDepth + rightDepth)`.
4. Return `1 + max(leftDepth, rightDepth)`.

**Complexity:**

| | |
|---|---|
| Time | O(n) — visit every node once |
| Space | O(h) — recursion stack, h = tree height |
