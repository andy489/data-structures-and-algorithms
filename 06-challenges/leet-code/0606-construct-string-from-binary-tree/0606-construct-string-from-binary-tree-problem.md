# 606. Construct String from Binary Tree

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/construct-string-from-binary-tree/

---

## Problem Statement

Given the `root` of a binary tree, construct a string consisting of parenthesis and integers from a binary tree with the preorder traversal way, and return it.

Omit all the empty parenthesis pairs that do not affect the one-to-one mapping relationship between the string and the original binary tree. But if two children are present, only the right child's empty parentheses can be omitted if the left child is null.

---

## Examples

**Example 1:**
```
Input:  root = [1,2,3,4]
Output: "1(2(4))(3)"
```

**Example 2:**
```
Input:  root = [1,2,3,null,4]
Output: "1(2()(4))(3)"
```

---

## Constraints

- The number of nodes in the tree is in the range `[1, 10^4]`
- `-1000 <= Node.val <= 1000`
