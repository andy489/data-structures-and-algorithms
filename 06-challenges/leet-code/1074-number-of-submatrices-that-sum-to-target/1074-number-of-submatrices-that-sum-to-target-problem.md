# 1074. Number of Submatrices That Sum to Target

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/number-of-submatrices-that-sum-to-target/

---

## Problem Statement

Given a `matrix` and a `target`, return the number of non-empty submatrices that sum to `target`.

A submatrix `x1, y1, x2, y2` is the set of all cells `matrix[x][y]` with `x1 <= x <= x2` and `y1 <= y <= y2`.

---

## Examples

**Example 1:**
```
Input:  matrix = [[0,1,0],[1,1,1],[0,1,0]], target = 0
Output: 4
```

**Example 2:**
```
Input:  matrix = [[1,-1],[-1,1]], target = 0
Output: 5
```

---

## Constraints

- `1 <= matrix.length <= 100`
- `1 <= matrix[0].length <= 100`
- `-1000 <= matrix[i][j] <= 1000`
- `-10^8 <= target <= 10^8`
