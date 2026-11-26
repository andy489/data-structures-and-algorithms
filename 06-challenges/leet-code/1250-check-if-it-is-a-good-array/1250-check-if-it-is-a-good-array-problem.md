# 1250. Check If It Is a Good Array

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/check-if-it-is-a-good-array/

---

## Problem Statement

Given an array `nums` of positive integers. Your task is to select some subset of `nums`, multiply each element by an integer and add all these products together.
In other words, return whether the following equality is satisfied for some choice of integers:
`a[0] * nums[0] + a[1] * nums[1] + ... + a[k] * nums[k] == 1`

This is known as "Bezout's Identity".

---

## Examples

**Example 1:**
```
Input:  nums = [12,5,7,23]
Output: true
```

---

## Constraints

- `1 <= nums.length <= 10^3`
- `1 <= nums[i] <= 10^9`
