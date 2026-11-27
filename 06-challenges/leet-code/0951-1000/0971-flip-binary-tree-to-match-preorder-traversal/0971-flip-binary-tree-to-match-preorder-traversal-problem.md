# 971. Flip Binary Tree To Match Preorder Traversal

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/flip-binary-tree-to-match-preorder-traversal/

---

## Problem Statement

You are given the `root` of a binary tree with `n` nodes, where each node is uniquely assigned a value from `1` to `n`. You are also given a sequence of `n` values `voyage`, which is the desired pre-order traversal of the binary tree.

Any node in the binary tree can be flipped by swapping its left and right subtrees. Return the smallest list of nodes that were flipped to make the pre-order traversal of the tree match `voyage`. If it is impossible, return the list `[-1]`.

---

## Examples

**Example 1:**
```
Input:  root = [1,2], voyage = [2,1]
Output: [-1]
```

**Example 2:**
```
Input:  root = [1,2,3], voyage = [1,3,2]
Output: [1]
```

---

## Constraints

- The number of nodes in the tree is `n`.
- `n == voyage.length`
- `1 <= n <= 100`
- `1 <= Node.val, voyage[i] <= n`
- All the values in the tree are unique.
- All the values in `voyage` are unique.
