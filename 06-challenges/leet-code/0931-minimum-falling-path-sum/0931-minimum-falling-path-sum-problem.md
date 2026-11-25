# 931. Minimum Falling Path Sum

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-falling-path-sum/

---

## Problem Statement

Given an `n x n` array of integers `matrix`, return the **minimum sum** of any **falling path** through `matrix`.

A **falling path** starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right.

---

## Examples

**Example 1:**
```
Input:  matrix = [[2,1,3],[6,5,4],[7,8,9]]
Output: 13
```

---

## Constraints

- `n == matrix.length == matrix[i].length`
- `1 <= n <= 100`
- `-100 <= matrix[i][j] <= 100`
