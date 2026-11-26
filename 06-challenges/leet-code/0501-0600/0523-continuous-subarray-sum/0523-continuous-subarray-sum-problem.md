# 523. Continuous Subarray Sum

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/continuous-subarray-sum/

---

## Problem Statement

Given an integer array `nums` and an integer `k`, return `true` if `nums` has a **good subarray** or `false` otherwise.

A **good subarray** is a subarray where:
- its length is **at least two**, and
- the sum of the elements of the subarray is a multiple of `k`.

---

## Examples

**Example 1:**
```
Input:  nums = [23,2,4,6,7], k = 6
Output: true
Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
```

**Example 2:**
```
Input:  nums = [23,2,6,4,7], k = 6
Output: true
Explanation: [23, 2, 6, 4, 7] sums to 42 = 7 × 6.
```

**Example 3:**
```
Input:  nums = [23,2,6,4,7], k = 13
Output: false
```

---

## Constraints

- `1 <= nums.length <= 10^5`
- `0 <= nums[i] <= 10^9`
- `0 <= sum(nums[i]) <= 2^31 - 1`
- `1 <= k <= 2^31 - 1`
