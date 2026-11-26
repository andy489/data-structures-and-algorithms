# 865. Smallest Subtree with all the Deepest Nodes

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/

---

## Problem Statement

Given the `root` of a binary tree, the depth of each node is the shortest distance to the root.

Return the smallest subtree such that it contains all the deepest nodes in the original tree. If a node is the deepest, then it is the smallest subtree with all the deepest nodes.

The subtree of a node is a tree consisting of a node and all of its descendants.

---

## Examples

**Example 1:**
```
Input:  root = [3,5,1,6,2,0,8,null,null,7,4]
Output: [2,7,4]
```

**Example 2:**
```
Input:  root = [1]
Output: [1]
```

---

## Constraints

- The number of nodes in the tree will be in the range `[1, 500]`.
- `0 <= Node.val <= 500`
- The values of the nodes in the tree are unique.
