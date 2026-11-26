# 1254. Number of Closed Islands

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-closed-islands/

---

## Problem Statement

Given a 2D grid consists of `0`s (land) and `1`s (water). An island is a maximal 4-directionally connected component of `0`s. The island is closed if the island is completely surrounded by `1`s (i.e., is not on the border).

Return the number of closed islands.

---

## Examples

**Example 1:**
```
Input:  grid = [[1,1,1,1,1,1,1,0],[1,0,0,0,0,1,1,0],[1,0,1,0,1,1,1,0],[1,0,0,0,0,1,0,1],[1,1,1,1,1,1,1,0]]
Output: 2
```

---

## Constraints

- `1 <= grid.length, grid[0].length <= 100`
- `0 <= grid[i][j] <= 1`
