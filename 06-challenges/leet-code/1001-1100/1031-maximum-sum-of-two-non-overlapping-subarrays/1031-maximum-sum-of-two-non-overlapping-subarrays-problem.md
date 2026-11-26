# 1031. Maximum Sum of Two Non-Overlapping Subarrays

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-sum-of-two-non-overlapping-subarrays/

---

## Problem Statement

Given an integer array `nums` and two integers `firstLen` and `secondLen`, return the maximum sum of elements in two non-overlapping subarrays with lengths `firstLen` and `secondLen`.

The array with length `firstLen` could occur before or after the array with length `secondLen`, but they have to be non-overlapping.

---

## Examples

**Example 1:**
```
Input:  nums = [0,6,5,2,2,5,1,9,4], firstLen = 1, secondLen = 2
Output: 20
```

**Example 2:**
```
Input:  nums = [3,8,1,3,2,1,8,9,0], firstLen = 3, secondLen = 2
Output: 29
```

---

## Constraints

- `1 <= firstLen, secondLen <= 1000`
- `2 <= firstLen + secondLen <= 1000`
- `firstLen + secondLen <= nums.length <= 1000`
- `0 <= nums[i] <= 1000`
