# 538. Convert BST to Greater Tree — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/convert-bst-to-greater-tree/

---

## Solution: Reverse Inorder Traversal — O(n) time, O(h) space

**Idea:** A reverse inorder traversal (right → root → left) visits nodes in descending order. Maintain a running sum; add it to each node's value as we go.

**Algorithm:**
1. Traverse right subtree first.
2. Add running sum to current node's value, update running sum.
3. Traverse left subtree.

**Complexity:**

| | |
|---|---|
| Time | O(n) |
| Space | O(h) — recursion stack |
