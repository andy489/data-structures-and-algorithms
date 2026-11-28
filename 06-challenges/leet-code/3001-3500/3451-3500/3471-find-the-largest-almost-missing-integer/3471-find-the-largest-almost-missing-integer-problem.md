# 3471. Find the Largest Almost Missing Integer

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-the-largest-almost-missing-integer/

---

## Problem Statement

You are given an integer array `nums` and an integer `k`.

An integer `x` is **almost missing** from `nums` if `x` appears in *exactly* one subarray of size `k` within `nums`.

Return the **largest** **almost missing** integer from `nums`. If no such integer exists, return `-1`.

A **subarray** is a contiguous sequence of elements within an array.

---

## Examples

**Example 1:**
```
Input: nums = [3,9,2,1,7], k = 3
Output: 7
```

**Example 2:**
```
Input: nums = [3,9,7,2,1,7], k = 4
Output: 3
```

**Example 3:**
```
Input: nums = [0,0], k = 1
Output: -1
```

---

## Constraints

- `1 <= nums.length <= 50`
- `0 <= nums[i] <= 50`
- `1 <= k <= nums.length`
