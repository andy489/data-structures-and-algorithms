# 1448. Count Good Nodes In Binary Tree

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-good-nodes-in-binary-tree/

---

## Problem Statement

A node X is good if no ancestor of X has a value greater than X. Return the number of good nodes.

---

## Examples

**Example 1:**
```
Input:  root=[3,1,4,3,null,1,5]
Output: 4
```

**Example 2:**
```
Input:  root=[3,3,null,4,2]
Output: 3
```

**Example 3:**
```
Input:  root=[1]
Output: 1
```

---

## Constraints

- `The number of nodes in the binary tree is in [1, 10^5]`
- `-10^4 <= Node.val <= 10^4`
