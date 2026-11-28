# 2916. Subarrays Distinct Element Sum of Squares II

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/subarrays-distinct-element-sum-of-squares-ii/

---

## Problem Statement

You are given a **0-indexed** integer array `nums`.

The **distinct count** of a subarray of `nums` is defined as the number of distinct values in `nums[i..j]`.

Return the sum of the **squares** of **distinct counts** of all subarrays of `nums`.

Since the answer may be very large, return it **modulo** `10^9 + 7`.

A subarray is a contiguous **non-empty** sequence of elements within an array.

---

## Examples

**Example 1:**
```
Input: nums = [1,2,1]
Output: 15
```

**Example 2:**
```
Input: nums = [2,2]
Output: 3
```

---

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^5`
