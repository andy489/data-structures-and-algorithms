# 1022. Sum of Root To Leaf Binary Numbers

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/sum-of-root-to-leaf-binary-numbers/

---

## Problem Statement

You are given the `root` of a binary tree where each node has a value `0` or `1`. Each root-to-leaf path represents a binary number starting with the most significant bit.

Return the sum of all root-to-leaf binary numbers.

---

## Examples

**Example 1:**
```
Input:  root = [1,0,1,0,1,0,1]
Output: 22
Explanation: (100) + (101) + (110) + (111) = 4 + 5 + 6 + 7 = 22
```

---

## Constraints

- The number of nodes in the tree is in the range `[1, 1000]`.
- `Node.val` is `0` or `1`.
