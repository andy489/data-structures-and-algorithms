# 3040. Maximum Number of Operations With the Same Score II

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-number-of-operations-with-the-same-score-ii/

---

## Problem Statement

Given an integer array `nums`, you can perform operations where you remove either:
- The first two elements (score = nums[0]+nums[1])
- The last two elements (score = nums[n-1]+nums[n-2])  
- The first and last element (score = nums[0]+nums[n-1])

All operations in a session must have the same score. Return the maximum number of operations.

---

## Examples

**Example 1:**
```
Input:  nums = [3,2,1,2,3,4]
Output: 3
```

**Example 2:**
```
Input:  nums = [3,2,6,1,4]
Output: 2
```

---

## Constraints

- `2 <= nums.length <= 2000`
- `1 <= nums[i] <= 1000`
