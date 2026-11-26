# 993. Cousins in Binary Tree

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/cousins-in-binary-tree/

---

## Problem Statement

Given the `root` of a binary tree with unique values and the values of two different nodes `x` and `y`, return `true` if the nodes corresponding to the values `x` and `y` in the tree are cousins, or `false` otherwise.

Two nodes of a binary tree are cousins if they have the same depth with different parents.

---

## Examples

**Example 1:**
```
Input:  root = [1,2,3,4], x = 4, y = 3
Output: false
```

**Example 2:**
```
Input:  root = [1,2,3,null,4,null,5], x = 5, y = 4
Output: true
```

---

## Constraints

- The number of nodes in the tree is in the range `[2, 100]`.
- `1 <= Node.val <= 100`
- Each node has a unique value.
- `x != y`
- `x` and `y` are found in the tree.
