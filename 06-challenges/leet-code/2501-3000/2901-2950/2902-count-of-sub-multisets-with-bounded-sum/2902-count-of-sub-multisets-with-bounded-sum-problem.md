# 2902. Count of Sub-Multisets With Bounded Sum

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-of-sub-multisets-with-bounded-sum/

---

## Problem Statement

You are given a **0-indexed** array `nums` of non-negative integers, and two integers `l` and `r`.

Return the **count of sub-multisets** within `nums` where the sum of elements in each subset falls within the inclusive range of `[l, r]`.

Since the answer may be large, return it modulo `10^9 + 7`.

A **sub-multiset** is an **unordered** collection of elements of the array in which a given value `x` can occur `0, 1, ..., occ[x]` times, where `occ[x]` is the number of occurrences of `x` in the array.

**Note** that:
- Two **sub-multisets** are the same if sorting both sub-multisets results in identical multisets.
- The sum of an **empty** multiset is `0`.

---

## Examples

**Example 1:**
```
Input: nums = [1,2,2,3], l = 6, r = 6
Output: 1
Explanation: The only subset of nums that has a sum of 6 is {1, 2, 3}.
```

**Example 2:**
```
Input: nums = [2,1,4,2,7], l = 1, r = 5
Output: 7
```

**Example 3:**
```
Input: nums = [1,2,1,3,5,2], l = 3, r = 5
Output: 9
```

---

## Constraints

- `1 <= nums.length <= 2 * 10^4`
- `0 <= nums[i] <= 2 * 10^4`
- Sum of `nums` does not exceed `2 * 10^4`.
- `0 <= l <= r <= 2 * 10^4`
