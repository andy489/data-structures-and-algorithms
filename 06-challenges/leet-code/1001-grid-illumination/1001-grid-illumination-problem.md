# 1001. Grid Illumination

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/grid-illumination/

---

## Problem Statement

There is a 2D grid of size `n x n` where each cell of this grid has a lamp that is initially turned off.

You are given a 2D array of lamp positions `lamps`, where `lamps[i] = [rowi, coli]` indicates that the lamp at `grid[rowi][coli]` is turned on. Even if the same lamp is listed more than once, it is turned on.

When a lamp is turned on, it illuminates its cell and all other cells in the same row, column, or diagonal.

You are also given another 2D array `queries`, where `queries[j] = [rowj, colj]`. For the `j`th query, determine whether `grid[rowj][colj]` is illuminated or not. After answering the `j`th query, turn off the lamp at `grid[rowj][colj]` and its 8 adjacent lamps if they exist. A lamp that has been turned off is not turned on again.

Return an array of integers `ans`, where `ans[j]` should be `1` if the cell in the `j`th query was illuminated, or `0` if the lamp was not illuminated.

---

## Examples

**Example 1:**
```
Input:  n = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,0]]
Output: [1,0]
```

**Example 2:**
```
Input:  n = 5, lamps = [[0,0],[4,4]], queries = [[1,1],[1,1]]
Output: [1,1]
```

---

## Constraints

- `1 <= n <= 10^9`
- `0 <= lamps.length <= 20000`
- `0 <= queries.length <= 20000`
- `lamps[i].length == 2`
- `0 <= lamps[i][0], lamps[i][1] < n`
- `queries[j].length == 2`
- `0 <= queries[j][0], queries[j][1] < n`
