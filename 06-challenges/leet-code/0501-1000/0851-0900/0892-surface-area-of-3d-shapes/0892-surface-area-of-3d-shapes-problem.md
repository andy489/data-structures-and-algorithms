# 892. Surface Area of 3D Shapes

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/surface-area-of-3d-shapes/

---

## Problem Statement

You are given an `n x n` `grid` where you have placed some `1 x 1 x 1` cubes. Each value `v = grid[i][j]` represents a tower of `v` cubes placed on top of cell `(i, j)`.

After placing these cubes, you have decided to glue any directly adjacent cubes to each other, forming several irregular 3D shapes.

Return the total surface area of the resulting shapes.

---

## Examples

**Example 1:**
```
Input:  grid = [[1,2],[3,4]]
Output: 34
```

**Example 2:**
```
Input:  grid = [[1,1,1],[1,0,1],[1,1,1]]
Output: 32
```

---

## Constraints

- `n == grid.length == grid[i].length`
- `1 <= n <= 50`
- `0 <= grid[i][j] <= 50`
