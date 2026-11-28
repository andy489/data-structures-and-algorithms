# 2913. Subarrays Distinct Element Sum of Squares I

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-i/

---

## Problem Statement

You are given a **0-indexed** integer array `nums`.

The **distinct count** of a subarray of `nums` is defined as the number of distinct values in `nums[i..j]` (a subarray from index `i` to `j`).

Return the sum of the **squares** of **distinct counts** of all subarrays of `nums`.

A subarray is a contiguous **non-empty** sequence of elements within an array.

---

## Examples

**Example 1:**
```
Input: nums = [1,2,1]
Output: 15
Explanation: 1^2 + 1^2 + 1^2 + 2^2 + 2^2 + 2^2 = 15
```

**Example 2:**
```
Input: nums = [1,1]
Output: 3
Explanation: 1^2 + 1^2 + 1^2 = 3
```

---

## Constraints

- `1 <= nums.length <= 100`
- `1 <= nums[i] <= 100`
