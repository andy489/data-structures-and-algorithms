# 654. Maximum Binary Tree

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-binary-tree/

---

## Problem Statement

You are given an integer array `nums` with no duplicates. A **maximum binary tree** can be built recursively from `nums` using the following algorithm:

1. Create a root node whose value is the maximum value in `nums`.
2. Recursively build the left subtree on the **subarray prefix** to the left of the maximum value.
3. Recursively build the right subtree on the **subarray suffix** to the right of the maximum value.

Return the **maximum binary tree** built from `nums`.

---

## Examples

**Example 1:**
```
Input:  nums = [3,2,1,6,0,5]
Output: [6,3,5,null,2,0,null,null,1]
```

**Example 2:**
```
Input:  nums = [3,2,1]
Output: [3,null,2,null,1]
```

---

## Constraints

- `1 <= nums.length <= 1000`
- `0 <= nums[i] <= 1000`
- All integers in `nums` are **unique**.
