# 3319. K-th Largest Perfect Subtree Size in Binary Tree

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/k-th-largest-perfect-subtree-size-in-binary-tree/

## Problem

You are given the `root` of a **binary tree** and an integer `k`.

Return an integer denoting the size of the `k`th **largest** perfect binary subtree, or `-1` if it doesn't exist.

A **perfect binary tree** is a tree where all leaves are on the same level, and every parent has two children.

## Examples

**Example 1:**
```
Input: root = [5,3,6,5,2,5,7,1,8,null,null,6,8], k = 2
Output: 3
Explanation: The sizes of perfect binary subtrees are [3,3,1,1,1,1,1,1]. The 2nd largest is 3.
```

**Example 2:**
```
Input: root = [1,2,3,4,5,6,7], k = 1
Output: 7
Explanation: Sizes [7,3,3,1,1,1,1]. The largest is 7.
```

**Example 3:**
```
Input: root = [1,2,3,null,4], k = 3
Output: -1
Explanation: Sizes [1,1]. Fewer than 3 perfect binary subtrees.
```

## Constraints

- The number of nodes in the tree is in the range `[1, 2000]`.
- `1 <= Node.val <= 2000`
- `1 <= k <= 1024`
