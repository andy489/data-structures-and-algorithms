# 1590. Make Sum Divisible by P

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/make-sum-divisible-by-p/

---

## Problem Statement

Given an array of positive integers `nums`, remove the **smallest** subarray (possibly **empty**) such that the **sum** of the remaining elements is divisible by `p`. It is **not** allowed to remove the whole array.

Return the length of the smallest subarray that you need to remove, or `-1` if it's impossible.

A **subarray** is defined as a contiguous block of elements in the array.

---

## Examples

**Example 1:**
```
Input:  nums = [3,1,4,2], p = 6
Output: 1
```

**Example 2:**
```
Input:  nums = [6,3,5,2], p = 9
Output: 2
```

**Example 3:**
```
Input:  nums = [1,2,3], p = 3
Output: 0
```

---

## Constraints

- `1 <= nums.length <= 10^5`
- `1 <= nums[i] <= 10^9`
- `1 <= p <= 10^9`
