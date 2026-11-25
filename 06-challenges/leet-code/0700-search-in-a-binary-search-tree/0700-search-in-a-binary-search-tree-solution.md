# 700. Search in a Binary Search Tree — Solution

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/search-in-a-binary-search-tree/

---

## Solution: Iterative BST Search — O(h) time, O(1) space

**Idea:** Use BST property to navigate left or right until found or null.

**Algorithm:**
1. While node != null: if node.val == val return node; if val < node.val go left; else go right.

**Complexity:**

| | |
|---|---|
| Time | O(h) — h is tree height |
| Space | O(1) |

## Solution 2: Recursive — O(h) time, O(h) space

Same logic recursively.

**Complexity:**

| | |
|---|---|
| Time | O(h) |
| Space | O(h) — call stack |
