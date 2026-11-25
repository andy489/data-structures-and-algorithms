# 908. Smallest Range I

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/smallest-range-i/

---

## Problem Statement

You are given an integer array `nums` and an integer `k`.

In one operation, you can choose any `nums[i]` and change it to `nums[i] + x` where `x` is an integer from the range `[-k, k]`.

Return the **minimum** value of `max(nums) - min(nums)` after performing the mentioned operation on every element of `nums`.

---

## Examples

**Example 1:**
```
Input:  nums = [1], k = 0
Output: 0
```

**Example 2:**
```
Input:  nums = [0,10], k = 2
Output: 6
```

---

## Constraints

- `1 <= nums.length <= 10^4`
- `0 <= nums[i] <= 10^4`
- `0 <= k <= 10^4`
