# 1162. As Far from Land as Possible

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/as-far-from-land-as-possible/

---

## Problem Statement

Given an `n x n` grid containing only values `0` and `1`, where `0` represents water and `1` represents land, find a water cell such that its distance to the nearest land cell is **maximized**, and return the distance. If no land or water exists in the grid, return `-1`.

The distance used in this problem is the **Manhattan distance**: the distance between two cells `(x0, y0)` and `(x1, y1)` is `|x0 - x1| + |y0 - y1|`.

---

## Examples

**Example 1:**
```
Input:  grid = [[1,0,1],[0,0,0],[1,0,1]]
Output: 2
Explanation: The water cell at (1,1) is at distance 2 from the nearest land cell.
```

**Example 2:**
```
Input:  grid = [[1,0,0],[0,0,0],[0,0,0]]
Output: 4
Explanation: The water cell at (2,2) is at Manhattan distance 4 from the land cell (0,0).
```

---

## Constraints

- `n == grid.length`
- `n == grid[i].length`
- `1 <= n <= 100`
- `grid[i][j]` is `0` or `1`
