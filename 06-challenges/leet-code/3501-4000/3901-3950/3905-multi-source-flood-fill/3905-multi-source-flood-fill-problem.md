# 3905. Multi Source Flood Fill

**Difficulty:** Medium

**Link:** https://leetcode.com/problems/multi-source-flood-fill/

## Problem

You are given two integers `n` and `m` representing the number of rows and columns of a grid, respectively.

You are also given a 2D integer array `sources`, where `sources[i] = [r_i, c_i, color_i]` indicates that the cell `(r_i, c_i)` is initially colored with `color_i`. All other cells are initially uncolored and represented as 0.

At each time step, every currently colored cell spreads its color to all adjacent **uncolored** cells in the four directions: up, down, left, and right. All spreads happen simultaneously.

If **multiple** colors reach the same uncolored cell at the same time step, the cell takes the color with the **maximum** value.

The process continues until no more cells can be colored.

Return a 2D integer array representing the final state of the grid, where each cell contains its final color.

## Examples

**Example 1:**
```
Input: n = 3, m = 3, sources = [[0,0,1],[2,2,2]]
Output: [[1,1,2],[1,2,2],[2,2,2]]
```

**Example 2:**
```
Input: n = 3, m = 3, sources = [[0,1,3],[1,1,5]]
Output: [[3,3,3],[5,5,5],[5,5,5]]
```

**Example 3:**
```
Input: n = 2, m = 2, sources = [[1,1,5]]
Output: [[5,5],[5,5]]
```

## Constraints

- `1 <= n, m <= 10^5`
- `1 <= n * m <= 10^5`
- `1 <= sources.length <= n * m`
- `sources[i] = [r_i, c_i, color_i]`
- `0 <= r_i <= n - 1`
- `0 <= c_i <= m - 1`
- `1 <= color_i <= 10^6`
- All `(r_i, c_i)` in `sources` are distinct.
