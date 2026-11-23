# 530. Minimum Absolute Difference in BST — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-absolute-difference-in-bst/

---

## Solution: Inorder Traversal — O(n) time, O(h) space

**Idea:** In a BST, inorder traversal visits nodes in ascending order. The minimum absolute difference must occur between two adjacent values in sorted order, so tracking the previous node during inorder traversal is sufficient.

**Algorithm:**
1. Perform inorder traversal (left → root → right).
2. At each node, compute `node.val - prev.val` and update the minimum.
3. Update `prev` to current node.

**Complexity:**

| | |
|---|---|
| Time | O(n) — visit every node once |
| Space | O(h) — recursion stack (h = tree height) |
