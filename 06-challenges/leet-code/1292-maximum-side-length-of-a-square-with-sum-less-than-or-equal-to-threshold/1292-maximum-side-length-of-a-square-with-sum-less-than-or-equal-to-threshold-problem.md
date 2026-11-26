# 1292. Maximum Side Length of a Square with Sum Less Than or Equal to Threshold

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/

---

## Problem Statement

Given a `m x n` matrix `mat` and an integer `threshold`, return the maximum side-length of a square with a sum less than or equal to `threshold` or return `0` if there is no such square.

---

## Examples

**Example 1:**
```
Input:  mat = [[1,1,3,2,4,3,2],[1,1,3,2,4,3,2],[1,1,3,2,4,3,2]], threshold = 4
Output: 2
```

---

## Constraints

- `m == mat.length`
- `n == mat[i].length`
- `1 <= m, n <= 300`
- `0 <= mat[i][j] <= 10^4`
- `0 <= threshold <= 10^5`
