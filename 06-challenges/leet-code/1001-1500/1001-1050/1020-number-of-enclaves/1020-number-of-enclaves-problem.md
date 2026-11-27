# 1020. Number of Enclaves

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-enclaves/

---

## Problem Statement

You are given an `m x n` binary matrix `grid`, where `0` represents a sea cell and `1` represents a land cell.

A move consists of walking from one land cell to another adjacent (4-directionally) land cell or walking off the boundary of the grid.

Return the number of land cells in `grid` for which we cannot walk off the boundary of the grid in any number of moves.

---

## Examples

**Example 1:**
```
Input:  grid = [[0,0,0,0],[1,0,1,0],[0,1,1,0],[0,0,0,0]]
Output: 3
```

**Example 2:**
```
Input:  grid = [[0,1,1,0],[0,0,1,0],[0,0,1,0],[0,0,0,0]]
Output: 0
```

---

## Constraints

- `m == grid.length`
- `n == grid[i].length`
- `1 <= m, n <= 500`
- `grid[i][j]` is either `0` or `1`.
