# 2915. Length of the Longest Subsequence That Sums to Target

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/length-of-the-longest-subsequence-that-sums-to-target/

---

## Problem Statement

You are given a **0-indexed** array of integers `nums`, and an integer `target`.

Return the **length of the longest subsequence** of `nums` that sums up to `target`. If no such subsequence exists, return `-1`.

A **subsequence** is an array that can be derived from another array by deleting some or no elements without changing the order of the remaining elements.

---

## Examples

**Example 1:**
```
Input: nums = [1,2,3,4,5], target = 9
Output: 3
Explanation: Longest subsequences summing to 9 are [1,3,5] and [2,3,4].
```

**Example 2:**
```
Input: nums = [4,1,3,2,1,5], target = 7
Output: 4
Explanation: Longest subsequence is [1,3,2,1].
```

**Example 3:**
```
Input: nums = [1,1,5,4,5], target = 3
Output: -1
```

---

## Constraints

- `1 <= nums.length <= 1000`
- `1 <= nums[i] <= 1000`
- `1 <= target <= 1000`
