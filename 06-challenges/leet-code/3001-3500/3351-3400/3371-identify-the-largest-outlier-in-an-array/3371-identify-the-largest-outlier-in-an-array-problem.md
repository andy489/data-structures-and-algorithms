# 3371. Identify the Largest Outlier in an Array

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/identify-the-largest-outlier-in-an-array/

---

## Problem Statement

You are given an integer array `nums`. This array contains `n` elements, where **exactly** `n - 2` elements are **special numbers**. One of the remaining two elements is the *sum* of these special numbers, and the other is an **outlier**.

An **outlier** is defined as a number that is *neither* one of the original special numbers *nor* the element representing the sum of those numbers.

**Note** that special numbers, the sum element, and the outlier must have **distinct** indices, but *may* share the **same** value.

Return the **largest** potential **outlier** in `nums`.

---

## Examples

**Example 1:**
```
Input:  nums = [2,3,5,10]
Output: 10
```
Special numbers: 2, 3 → sum = 5, outlier = 10.

**Example 2:**
```
Input:  nums = [-2,-1,-3,-6,4]
Output: 4
```
Special numbers: -2, -1, -3 → sum = -6, outlier = 4.

**Example 3:**
```
Input:  nums = [1,1,1,1,1,5,5]
Output: 5
```
Special numbers: five 1s → sum = 5, outlier = 5 (the other 5).

---

## Constraints

- `3 <= nums.length <= 10^5`
- `-1000 <= nums[i] <= 1000`
- The input is generated such that at least one potential outlier exists.
