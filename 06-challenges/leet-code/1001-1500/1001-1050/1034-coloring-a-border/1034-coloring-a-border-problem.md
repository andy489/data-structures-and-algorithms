# 1034. Coloring A Border

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/coloring-a-border/

---

## Problem Statement

You are given an `m x n` integer matrix `grid`, and three integers `row`, `col`, and `color`. Each value in the grid represents the color of the grid square at that location.

Two squares are **connected** if they are adjacent 4-directionally and have the same color. The **connected component** of a square is the maximal set of connected squares.

Find the connected component of `grid[row][col]` and **color its border** with `color`. Return the resulting grid.

---

## Examples

**Example 1:**
```
Input:  grid = [[1,1],[1,2]], row = 0, col = 0, color = 3
Output: [[3,3],[3,2]]
```

**Example 2:**
```
Input:  grid = [[1,2,2],[2,3,2]], row = 0, col = 1, color = 3
Output: [[1,3,3],[2,3,3]]
```

---

## Constraints

- `m == grid.length`
- `n == grid[i].length`
- `1 <= m, n <= 50`
- `1 <= grid[i][j] <= 1000`
- `0 <= row < m`
- `0 <= col < n`
- `1 <= color <= 1000`
