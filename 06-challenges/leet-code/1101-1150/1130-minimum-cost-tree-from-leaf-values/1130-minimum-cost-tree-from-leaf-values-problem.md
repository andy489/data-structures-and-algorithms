# 1130. Minimum Cost Tree From Leaf Values

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-cost-tree-from-leaf-values/

---

## Problem Statement

Given an array `arr` of positive integers, consider all binary trees such that:

- Each node has either 0 or 2 children.
- The values of `arr` correspond to the values of each leaf in an in-order traversal of the tree.
- The value of each non-leaf node is equal to the product of the largest leaf value in its left and right subtree, respectively.

Among all possible binary trees considered, return the smallest possible sum of the values of each non-leaf node. It is guaranteed this sum fits into a 32-bit integer.

A node is a leaf if and only if it has zero children.

---

## Examples

**Example 1:**
```
Input:  arr = [6,2,4]
Output: 32
Explanation: Two possible trees exist. The first has non-leaf sum 36, the second 32.
```

**Example 2:**
```
Input:  arr = [4,11]
Output: 44
```

---

## Constraints

- `2 <= arr.length <= 40`
- `1 <= arr[i] <= 15`
- It is guaranteed that the answer fits into a 32-bit signed integer.
