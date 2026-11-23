# 572. Subtree of Another Tree

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/subtree-of-another-tree/

---

## Problem Statement

Given the roots of two binary trees `root` and `subRoot`, return `true` if there is a node in the tree with root `root` whose subtree is identical in structure and node values to `subRoot`, or `false` otherwise.

---

## Examples

**Example 1:**
```
Input:  root = [3,4,5,1,2], subRoot = [4,1,2]
Output: true
```

**Example 2:**
```
Input:  root = [3,4,5,1,2,null,null,null,null,0], subRoot = [4,1,2]
Output: false
```

---

## Constraints

- `1 <= number of nodes in root <= 2000`
- `1 <= number of nodes in subRoot <= 1000`
- `-10^4 <= Node.val <= 10^4`
