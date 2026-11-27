# 3364. Minimum Positive Sum Subarray

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-positive-sum-subarray/

---

## Problem Statement

You are given an integer array `nums` and **two** integers `l` and `r`. Your task is to find the **minimum** sum of a **subarray** whose size is between `l` and `r` (inclusive) and whose sum is greater than 0.

Return the **minimum** sum of such a subarray. If no such subarray exists, return -1.

A **subarray** is a contiguous non-empty sequence of elements within an array.

---

## Examples

**Example 1:**
```
Input:  nums = [3,-2,1,4], l = 2, r = 3
Output: 1
```
Subarrays of length 2–3 with positive sum: [3,-2]=1, [1,4]=5, [3,-2,1]=2, [-2,1,4]=3. Minimum is 1.

**Example 2:**
```
Input:  nums = [-2,2,-3,1], l = 2, r = 3
Output: -1
```
No subarray of length 2–3 has a positive sum.

**Example 3:**
```
Input:  nums = [1,2,3,4], l = 2, r = 4
Output: 3
```
Subarray [1,2] has sum 3, the minimum positive sum.

---

## Constraints

- `1 <= nums.length <= 100`
- `1 <= l <= r <= nums.length`
- `-1000 <= nums[i] <= 1000`
