# 235. Lowest Common Ancestor of a Binary Search Tree — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/

---

## Solution: BST Property Navigation — O(H) time, O(1) space

**Idea:** Use the BST ordering. If both `p` and `q` are less than `root.val`, the LCA is in the left subtree. If both are greater, it's in the right subtree. Otherwise `root` is the LCA (one is in each subtree, or one equals root).

**Algorithm:**
1. While `true`: if `p.val < root.val && q.val < root.val` → `root = root.left`; elif both greater → `root = root.right`; else return `root`.

## Solution 2: Recursive — same logic, O(H) stack space

**Complexity:**

| | |
|---|---|
| Time | O(H) — O(log n) balanced, O(n) worst |
| Space | O(1) iterative, O(H) recursive |
