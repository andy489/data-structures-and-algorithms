# 766. Toeplitz Matrix

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/toeplitz-matrix/

---

## Problem Statement

Given an `m x n` matrix, return `true` if the matrix is **Toeplitz**. Otherwise, return `false`.

A matrix is **Toeplitz** if every diagonal from top-left to bottom-right has the same elements.

---

## Examples

**Example 1:**
```
Input:  matrix = [[1,2,3,4],[5,1,2,3],[9,5,1,2]]
Output: true
```

**Example 2:**
```
Input:  matrix = [[1,2],[2,2]]
Output: false
```

---

## Constraints

- `m == matrix.length`
- `n == matrix[i].length`
- `1 <= m, n <= 20`
- `0 <= matrix[i][j] <= 99`
