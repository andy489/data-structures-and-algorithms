# 971. Flip Binary Tree To Match Preorder Traversal — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/

---

## Solution: DFS Preorder — O(n) time, O(n) space

**Idea:** DFS preorder. At each node, if the left child doesn't match the next expected value, flip. If neither child matches, return [-1].

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(n) — recursion + result |
