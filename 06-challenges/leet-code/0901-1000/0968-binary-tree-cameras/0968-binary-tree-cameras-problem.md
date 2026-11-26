# 968. Binary Tree Cameras

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/binary-tree-cameras/

---

## Problem Statement

You are given the `root` of a binary tree. We install cameras on the tree nodes where each camera at a node can monitor its parent, itself, and its immediate children.

Return the minimum number of cameras needed to monitor all nodes of the tree.

---

## Examples

**Example 1:**
```
Input:  root = [0,0,null,0,0]
Output: 1
```

**Example 2:**
```
Input:  root = [0,0,null,0,null,0,null,null,0]
Output: 2
```

---

## Constraints

- The number of nodes in the tree is in the range `[1, 1000]`.
- `Node.val == 0`
