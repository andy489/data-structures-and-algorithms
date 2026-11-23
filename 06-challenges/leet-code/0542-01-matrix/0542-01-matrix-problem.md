# 542. 01 Matrix

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/01-matrix/

---

## Problem Statement

Given an `m x n` binary matrix `mat`, return the distance of the nearest `0` for each cell.

The distance between two cells sharing a common edge is `1`.

---

## Examples

**Example 1:**
```
Input:  mat = [[0,0,0],[0,1,0],[0,0,0]]
Output: [[0,0,0],[0,1,0],[0,0,0]]
```

**Example 2:**
```
Input:  mat = [[0,0,0],[0,1,0],[1,1,1]]
Output: [[0,0,0],[0,1,0],[1,2,1]]
```

---

## Constraints

- `m == mat.length`
- `n == mat[i].length`
- `1 <= m, n <= 10^4`
- `1 <= m * n <= 10^4`
- `mat[i][j]` is either `0` or `1`
- There is at least one `0` in `mat`
