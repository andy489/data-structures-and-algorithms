# 783. Minimum Distance Between BST Nodes — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-distance-between-bst-nodes/

---

## Solution: In-order Traversal — O(n) time, O(h) space

**Idea:** In-order traversal of a BST yields values in sorted order. The minimum difference is always between adjacent values in this sorted sequence.

**Algorithm:**
1. In-order traverse the tree, tracking the previous value.
2. Update min difference at each node.

**Complexity:**

| | |
|---|---|
| Time | O(n) — visit every node |
| Space | O(h) — recursion stack, h = tree height |
