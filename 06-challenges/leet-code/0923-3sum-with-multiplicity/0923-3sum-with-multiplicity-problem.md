# 923. 3Sum With Multiplicity

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/3sum-with-multiplicity/

---

## Problem Statement

Given an integer array `arr`, and an integer `target`, return the number of tuples `i, j, k` such that `i < j < k` and `arr[i] + arr[j] + arr[k] == target`.

Since the answer can be very large, return it **modulo** `10^9 + 7`.

---

## Examples

**Example 1:**
```
Input:  arr = [1,1,2,2,3,3,4,4,5,5], target = 8
Output: 20
```

**Example 2:**
```
Input:  arr = [1,1,2,2,2,2], target = 5
Output: 12
```

---

## Constraints

- `3 <= arr.length <= 3000`
- `0 <= arr[i] <= 100`
- `0 <= target <= 300`
