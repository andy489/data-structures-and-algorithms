# 883. Projection Area of 3D Shapes

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/projection-area-of-3d-shapes/

---

## Problem Statement

You are given an `n x n` `grid` where we place some `1 x 1 x 1` cubes that are axis-aligned with the `x`, `y`, and `z` axes.

Each value `v = grid[i][j]` represents a tower of `v` cubes placed on top of cell `(i, j)`.

We view the projection of these cubes onto the `xy`, `yz`, and `zx` planes.

A projection is like a shadow, that maps our three-dimensional figure to a two-dimensional plane. A projection onto the `xy` plane is formed by looking at the figure from directly above. The projection onto the `yz` plane is formed by looking at the figure from the right. The projection onto the `zx` plane is formed by looking at the figure from the front.

Return the total area of all three projections.

---

## Examples

**Example 1:**
```
Input:  grid = [[1,2],[3,4]]
Output: 17
```

**Example 2:**
```
Input:  grid = [[2]]
Output: 5
```

---

## Constraints

- `n == grid.length == grid[i].length`
- `1 <= n <= 50`
- `0 <= grid[i][j] <= 50`
