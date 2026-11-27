# 1026. Maximum Difference Between Node and Ancestor

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/

---

## Problem Statement

Given the `root` of a binary tree, find the maximum value `v` for which there exist different nodes `a` and `b` where `v = |a.val - b.val|` and `a` is an ancestor of `b`.

A node `a` is an ancestor of `b` if either: any child of `a` is equal to `b` or any child of `a` is an ancestor of `b`.

---

## Examples

**Example 1:**
```
Input:  root = [8,3,10,1,6,null,14,null,null,4,7,13]
Output: 7
```

---

## Constraints

- The number of nodes in the tree is in the range `[2, 5000]`.
- `0 <= Node.val <= 10^5`
