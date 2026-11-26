# 99. Recover Binary Search Tree

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/recover-binary-search-tree/

---

## Problem Statement

You are given the `root` of a binary search tree (BST), where the values of **exactly two** nodes of the tree were swapped by mistake. *Recover the tree without changing its structure.*

---

## Examples

**Example 1:**
```
Input:  root = [1,3,null,null,2]
Output: [3,1,null,null,2]
```

**Example 2:**
```
Input:  root = [3,1,4,null,null,2]
Output: [2,1,4,null,null,3]
```

---

## Constraints

- The number of nodes in the tree is in the range `[2, 1000]`.
- `-2^31 <= Node.val <= 2^31 - 1`

**Follow up:** A solution using `O(n)` space is straightforward. Could you devise a constant `O(1)` space solution?
