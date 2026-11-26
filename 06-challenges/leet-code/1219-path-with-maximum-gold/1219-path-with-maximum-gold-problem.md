# 1219. Path With Maximum Gold

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/path-with-maximum-gold/

---

## Problem Statement

In a gold mine `grid` of size `m x n`, each cell in this mine has an integer representing the amount of gold in that cell, `0` if it is empty.

Return the maximum amount of gold you can collect under the conditions:
- Every time you are located in a cell you will collect all the gold in that cell.
- From your position you can walk one step to the left, right, up, or down.
- You can't visit the same cell more than once.
- Never visit a cell with `0` gold.
- You can start and stop collecting gold from any position in the grid that has some gold.

---

## Examples

**Example 1:**
```
Input:  grid = [[0,6,0],[5,8,7],[0,9,0]]
Output: 24
```

---

## Constraints

- `1 <= m, n <= 15`
- `0 <= grid[i][j] <= 100`
- `There are at most 25 cells containing gold.`
