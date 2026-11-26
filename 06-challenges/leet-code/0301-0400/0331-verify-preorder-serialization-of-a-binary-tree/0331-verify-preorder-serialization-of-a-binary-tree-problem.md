# 331. Verify Preorder Serialization of a Binary Tree

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/

---

## Problem Statement

One way to serialize a binary tree is to use **preorder traversal**. When we encounter a non-null node, we record the node's value. If it is a null node, we record using a sentinel value such as `'#'`.

Given a string of comma-separated values `preorder`, return `true` if it is a correct preorder traversal serialization of some binary tree. Otherwise, return `false`.

It is guaranteed that each comma-separated value in the string must be either an integer or a character `'#'` representing null pointer.

You may assume that the input format is always valid.

---

## Examples

**Example 1:**
```
Input:  preorder = "9,3,4,#,#,1,#,#,2,#,6,#,#"
Output: true
```

**Example 2:**
```
Input:  preorder = "1,#"
Output: false
```

**Example 3:**
```
Input:  preorder = "9,#,#,1"
Output: false
```

---

## Constraints

- `1 <= preorder.length <= 10^4`
- `preorder` consist of integers in the range `[0, 100]` and `'#'` separated by commas `','`.
