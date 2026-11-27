# 669. Trim a Binary Search Tree — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/trim-a-binary-search-tree/

---

## Solution: Recursive DFS — O(n) time, O(n) space

**Idea:** Use BST property: if node < low, return trimmed right subtree; if node > high, return trimmed left subtree; else trim both children recursively.

**Algorithm:**
1. If null, return null.
2. If `node.val < low`, return `trim(node.right)`.
3. If `node.val > high`, return `trim(node.left)`.
4. Else trim both children and return node.

**Complexity:**

| | |
|---|---|
| Time | O(n) — visit each node at most once |
| Space | O(n) — recursion stack |
