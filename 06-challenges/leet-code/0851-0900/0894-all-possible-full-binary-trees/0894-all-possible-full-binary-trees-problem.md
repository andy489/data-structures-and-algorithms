# 894. All Possible Full Binary Trees

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/all-possible-full-binary-trees/

---

## Problem Statement

Given an integer `n`, return a list of all possible full binary trees with `n` nodes. Each node of each tree in the answer must have `Node.val == 0`.

A full binary tree is a binary tree where each node has exactly `0` or `2` children.

You may return the answer in any order.

---

## Examples

**Example 1:**
```
Input:  n = 7
Output: [[0,0,0,null,null,0,0,null,null,0,0],[0,0,0,null,null,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,null,null,null,null,0,0],[0,0,0,0,0,null,0,null,null,null,null,null,0]]
```

**Example 2:**
```
Input:  n = 3
Output: [[0,0,0]]
```

---

## Constraints

- `1 <= n <= 20`
