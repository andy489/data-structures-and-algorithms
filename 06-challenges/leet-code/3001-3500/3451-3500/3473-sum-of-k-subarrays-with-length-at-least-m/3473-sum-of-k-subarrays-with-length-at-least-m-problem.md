# 3473. Sum of K Subarrays With Length at Least M

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/sum-of-k-subarrays-with-length-at-least-m/

---

## Problem Statement

You are given an integer array `nums` and two integers, `k` and `m`.

Return the **maximum** sum of `k` non-overlapping subarrays of `nums`, where each subarray has a length of **at least** `m`.

---

## Examples

**Example 1:**
```
Input: nums = [1,2,-1,3,3,4], k = 2, m = 2
Output: 13
```

**Example 2:**
```
Input: nums = [-10,3,-1,-2], k = 4, m = 1
Output: -10
```

---

## Constraints

- `1 <= nums.length <= 2000`
- `-10^4 <= nums[i] <= 10^4`
- `1 <= k <= floor(nums.length / m)`
- `1 <= m <= 3`
