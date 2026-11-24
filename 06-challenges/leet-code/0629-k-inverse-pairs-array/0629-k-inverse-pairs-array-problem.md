# 629. K Inverse Pairs Array

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/k-inverse-pairs-array/

---

## Problem Statement

For an integer array `nums`, an **inverse pair** is a pair of integers `[nums[i], nums[j]]` where `0 <= i < j < nums.length` and `nums[i] > nums[j]`.

Given two integers `n` and `k`, return the number of different arrays consisting of numbers from `1` to `n` such that there are exactly `k` **inverse pairs**. Since the answer can be huge, return it **modulo** `10^9 + 7`.

---

## Examples

**Example 1:**
```
Input:  n = 3, k = 0
Output: 1
```

**Example 2:**
```
Input:  n = 3, k = 1
Output: 2
```

---

## Constraints

- `1 <= n <= 1000`
- `0 <= k <= 1000`
