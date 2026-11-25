# 662. Maximum Width of Binary Tree

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-width-of-binary-tree/

---

## Problem Statement

Given the `root` of a binary tree, return the **maximum width** of the given tree.

The **maximum width** of a tree is the maximum **width** among all levels.

The **width** of one level is defined as the length between the **leftmost** and the **rightmost** non-null nodes, where the null nodes between the two nodes in the leftmost and rightmost are also counted into the length calculation.

It is **guaranteed** that the answer will in the range of a **32-bit** signed integer.

---

## Examples

**Example 1:**
```
Input:  root = [1,3,2,5,3,null,9]
Output: 4
Explanation: Level 3 has width 4 (from node 5 to node 9).
```

**Example 2:**
```
Input:  root = [1,3,2,5,null,null,9,6,null,7]
Output: 7
```

---

## Constraints

- The number of nodes in the tree is in the range `[1, 3000]`.
- `-100 <= Node.val <= 100`
