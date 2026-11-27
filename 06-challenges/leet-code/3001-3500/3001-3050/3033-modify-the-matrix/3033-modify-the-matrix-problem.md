# 3033. Modify The Matrix

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/modify-the-matrix/

---

## Problem Statement

Given a 0-indexed integer matrix `matrix` of size `m x n`, find the minimum and maximum values in each column, then replace all `-1` values with the maximum value of their column.

---

## Examples

**Example 1:**
```
Input:  matrix = [[1,2,-1],[4,-1,6],[7,8,9]]
Output: [[1,2,9],[4,9,6],[7,8,9]]
```
Explanation: -1 at (0,2) replaced by max col 2 = 9. -1 at (1,1) replaced by max col 1 = 8.

**Example 2:**
```
Input:  matrix = [[3,-1],[5,2]]
Output: [[3,2],[5,2]]
```
Explanation: -1 at (0,1) replaced by max col 1 = 2.

---

## Constraints

- `m == matrix.length`
- `n == matrix[i].length`
- `1 <= m, n <= 50`
- `-1 <= matrix[i][j] <= 100`
