# 992. Subarrays with K Different Integers

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/subarrays-with-k-different-integers/

---

## Problem Statement

Given an integer array `nums` and an integer `k`, return the number of good subarrays of `nums`.

A good array is an array where the number of different integers in that array is exactly `k`.

---

## Examples

**Example 1:**
```
Input:  nums = [1,2,1,2,3], k = 2
Output: 7
```

**Example 2:**
```
Input:  nums = [1,2,1,3,4], k = 3
Output: 3
```

---

## Constraints

- `1 <= nums.length <= 2 * 10^4`
- `1 <= nums[i] <= nums.length`
- `1 <= k <= nums.length`
