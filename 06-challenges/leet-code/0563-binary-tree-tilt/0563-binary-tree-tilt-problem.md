# 563. Binary Tree Tilt

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/binary-tree-tilt/

---

## Problem Statement

Given the `root` of a binary tree, return the **sum of every tree node's tilt**.

The **tilt** of a tree node is the **absolute difference** between the sum of all left subtree node values and all right subtree node values. If a node does not have a left child, the sum of the left subtree node values is treated as `0`. The rule is similar if the node does not have a right child.

---

## Examples

**Example 1:**
```
Input:  root = [1,2,3]
Output: 1
```
Explanation: Tilt of node 2 = |0-0| = 0, tilt of node 3 = |0-0| = 0, tilt of node 1 = |2-3| = 1. Total = 1.

**Example 2:**
```
Input:  root = [4,2,9,3,5,null,7]
Output: 15
```

**Example 3:**
```
Input:  root = [21,7,14,1,1,2,2,3,3]
Output: 9
```

---

## Constraints

- `0 <= number of nodes <= 10^4`
- `-1000 <= Node.val <= 1000`
- Sum of all node values is in `[-10^5, 10^5]`
