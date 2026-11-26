# 932. Beautiful Array

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/beautiful-array/

---

## Problem Statement

An array `nums` of length `n` is **beautiful** if for every `i < k < j`:
- `nums[k] * 2 != nums[i] + nums[j]`

Given the integer `n`, return any **beautiful** array `nums` of length `n`. The generated array should consist of `n` elements from `1` to `n`.

---

## Examples

**Example 1:**
```
Input:  n = 4
Output: [2,1,4,3]
```

**Example 2:**
```
Input:  n = 5
Output: [3,1,2,5,4]
```

---

## Constraints

- `1 <= n <= 1000`
