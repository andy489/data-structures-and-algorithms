# 998. Maximum Binary Tree II

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-binary-tree-ii/

---

## Problem Statement

A maximum tree is a tree where every node has a value greater than any other value in its subtree.

You are given the `root` of a maximum binary tree and an integer `val`.

Just as in the previous problem, the given tree was constructed from a list `a` (`root = Construct(a)`) recursively with the following `Construct(a)` routine:

- If `a` is empty, return `null`.
- Otherwise, let `a[i]` be the largest element of `a`. Create a `root` node with the value `a[i]`.
- The left subtree of `root` will be `Construct(a[0, 1, ..., i - 1])`.
- The right subtree of `root` will be `Construct(a[i + 1, i + 2, ..., a.length - 1])`.
- Return `root`.

Note that we were not given `a` directly, only a root node `root = Construct(a)`.

Suppose `b` is a copy of `a` with the value `val` appended to it. It is guaranteed that `b` has unique values.

Return `Construct(b)`.

---

## Examples

**Example 1:**
```
Input:  root = [4,1,3,null,null,2], val = 5
Output: [5,4,null,1,3,null,null,2]
```

**Example 2:**
```
Input:  root = [5,2,4,null,1], val = 3
Output: [5,2,4,null,1,null,3]
```

---

## Constraints

- The number of nodes in the tree is in the range `[1, 100]`.
- `1 <= Node.val <= 200`
- All the values of the tree are unique.
- `1 <= val <= 200`
