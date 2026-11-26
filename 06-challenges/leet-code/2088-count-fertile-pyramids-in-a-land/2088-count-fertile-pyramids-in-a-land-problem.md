# 2088. Count Fertile Pyramids in a Land

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-fertile-pyramids-in-a-land/

---

## Problem Statement

Given an `m x n` binary matrix `grid`, count the number of pyramids (upright and inverted) that contain only 1s. A pyramid of height h has a 1-cell apex and each row below has 2 more cells, all 1s.

---

## Examples

**Example 1:**
```
Input:  grid = [[0,1,1,0],[1,1,1,1]]
Output: 2
```

**Example 2:**
```
Input:  grid = [[1,1,1],[1,1,1]]
Output: 2
```

**Example 3:**
```
Input:  grid = [[1,0,1],[0,0,0],[1,0,1]]
Output: 0
```

---

## Constraints

- `m == grid.length`
- `n == grid[i].length`
- `1 <= m, n <= 1000`
- `grid[i][j] is either 0 or 1.`
