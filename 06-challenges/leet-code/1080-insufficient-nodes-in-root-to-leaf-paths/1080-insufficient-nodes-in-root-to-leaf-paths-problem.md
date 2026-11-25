# 1080. Insufficient Nodes in Root to Leaf Paths

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/

---

## Problem Statement

Given the `root` of a binary tree and an integer `limit`, delete all **insufficient nodes** in the tree simultaneously, and return the root of the resulting binary tree.

A node is **insufficient** if every root to leaf path intersecting this node has a sum strictly less than `limit`.

---

## Examples

**Example 1:**
```
Input:  root = [1,2,3,4,-99,-99,7,8,1,-99,2,null,6,null,null], limit = 1
Output: [1,2,3,4,null,null,7,8,1,null,2,null,6]
```

**Example 2:**
```
Input:  root = [5,-99,-99], limit = -1
Output: [5,null,-99]
```

---

## Constraints

- The number of nodes in the tree is in the range `[1, 5000]`.
- `-10^5 <= Node.val <= 10^5`
- `-10^9 <= limit <= 10^9`
