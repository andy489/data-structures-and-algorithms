# 1072. Flip Columns For Maximum Number of Equal Rows

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/

---

## Problem Statement

You are given an `m x n` binary matrix `matrix`.

You can choose any number of columns in the matrix and flip every cell in that column (i.e., Change the value of the cell from `0` to `1` or vice versa).

Return the maximum number of rows that have all values equal after some number of flips.

---

## Examples

**Example 1:**
```
Input:  matrix = [[0,1],[1,1]]
Output: 1
```

**Example 2:**
```
Input:  matrix = [[0,1],[1,0]]
Output: 2
```

---

## Constraints

- `m == matrix.length`
- `n == matrix[i].length`
- `1 <= m, n <= 300`
- `matrix[i][j]` is either `0` or `1`.
