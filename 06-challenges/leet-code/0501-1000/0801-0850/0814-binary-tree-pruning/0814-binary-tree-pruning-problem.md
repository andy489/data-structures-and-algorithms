# 814. Binary Tree Pruning

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/binary-tree-pruning/

---

## Problem Statement

Given the `root` of a binary tree, return the same tree where every subtree (of the original tree) not containing a `1` has been removed.

---

## Examples

**Example 1:**
```
Input:  root = [1,null,0,0,1]
Output: [1,null,0,null,1]
```

**Example 2:**
```
Input:  root = [1,0,1,0,0,0,1]
Output: [1,null,1,null,1]
```

---

## Constraints

- The number of nodes in the tree is in the range `[1, 200]`.
- `Node.val` is either `0` or `1`.
