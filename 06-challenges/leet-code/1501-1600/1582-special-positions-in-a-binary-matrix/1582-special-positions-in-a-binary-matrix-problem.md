# 1582. Special Positions in a Binary Matrix

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/special-positions-in-a-binary-matrix/

---

## Problem Statement

Given an `m x n` binary matrix `mat`, return the number of special positions in `mat`.

A position `(i, j)` is called **special** if `mat[i][j] == 1` and all other elements in row `i` and column `j` are `0` (rows and columns are 0-indexed).

---

## Examples

**Example 1:**
```
Input:  mat = [[1,0,0],[0,0,1],[1,0,0]]
Output: 1
```

**Example 2:**
```
Input:  mat = [[1,0,0],[0,1,0],[0,0,1]]
Output: 3
```

---

## Constraints

- `m == mat.length`
- `n == mat[i].length`
- `1 <= m, n <= 100`
- `mat[i][j]` is either `0` or `1`
