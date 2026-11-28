# 3487. Maximum Unique Subarray Sum After Deletion

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/maximum-unique-subarray-sum-after-deletion/

---

## Problem Statement

You are given an integer array `nums`.

You are allowed to delete any number of elements from `nums` without making it **empty**. After performing the deletions, select a subarray of `nums` such that:

1. All elements in the subarray are **unique**.
2. The sum of the elements in the subarray is **maximized**.

Return the **maximum sum** of such a subarray.

---

## Examples

**Example 1:**
```
Input: nums = [1,2,3,4,5]
Output: 15
```

**Example 2:**
```
Input: nums = [1,1,0,1,1]
Output: 1
```

**Example 3:**
```
Input: nums = [1,2,-1,-2,1,0,-1]
Output: 3
```

---

## Constraints

- `1 <= nums.length <= 100`
- `-100 <= nums[i] <= 100`
