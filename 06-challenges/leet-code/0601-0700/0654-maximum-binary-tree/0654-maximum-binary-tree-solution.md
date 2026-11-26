# 654. Maximum Binary Tree — Solution

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-binary-tree/

---

## Solution: Recursive Divide and Conquer — O(n²) time, O(n) space

**Idea:** Find the max in the current range, make it root, recursively build left and right subtrees.

**Algorithm:**
1. Find index of maximum element in current range.
2. Create a TreeNode with that value.
3. Recursively build left subtree from left portion, right subtree from right portion.

**Complexity:**

| | |
|---|---|
| Time | O(n²) — worst case sorted array |
| Space | O(n) — recursion stack depth |
