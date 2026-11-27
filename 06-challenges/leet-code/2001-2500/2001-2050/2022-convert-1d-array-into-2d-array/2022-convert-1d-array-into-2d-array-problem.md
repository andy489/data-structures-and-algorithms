# 2022. Convert 1D Array Into 2D Array

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/convert-1d-array-into-2d-array/

---

## Problem Statement

You are given a 1D integer array `original` and two integers `m` and `n`. Create a 2D array with `m` rows and `n` columns using **all** elements in `original`. Return the 2D array, or an empty 2D array if it is not possible.

---

## Examples

**Example 1:**
```
Input:  original = [1,2,3,4], m = 2, n = 2
Output: [[1,2],[3,4]]
```

**Example 2:**
```
Input:  original = [1,2,3], m = 1, n = 3
Output: [[1,2,3]]
```

**Example 3:**
```
Input:  original = [1,2], m = 1, n = 1
Output: []
```
Explanation: original.length != m * n.

---

## Constraints

- `1 <= original.length <= 5 * 10^4`
- `1 <= m, n <= 4 * 10^4`
- `1 <= original[i] <= 10^5`
