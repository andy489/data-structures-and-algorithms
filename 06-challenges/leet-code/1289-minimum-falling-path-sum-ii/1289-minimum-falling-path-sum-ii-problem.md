# 1289. Minimum Falling Path Sum II

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-falling-path-sum-ii/

---

## Problem Statement

Given an `n x n` integer matrix `grid`, return the minimum sum of a falling path with non-zero shifts.

A falling path with non-zero shifts is a choice of exactly one element from each row of `grid` such that no two elements chosen in adjacent rows are in the same column.

---

## Examples

**Example 1:**
```
Input:  grid = [[1,2,3],[4,5,6],[7,8,9]]
Output: 13
```

---

## Constraints

- `n == grid.length == grid[i].length`
- `1 <= n <= 200`
- `-99 <= grid[i][j] <= 99`
