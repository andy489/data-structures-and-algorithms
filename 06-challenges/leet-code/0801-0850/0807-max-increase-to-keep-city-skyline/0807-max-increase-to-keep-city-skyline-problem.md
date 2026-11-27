# 807. Max Increase to Keep City Skyline

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/max-increase-to-keep-city-skyline/

---

## Problem Statement

There is a city whose buildings are represented by a grid `grid[i][j]`. The skyline when looking north/south is determined by the max in each column; east/west by the max in each row.

You can increase the height of any building by any amount, but you cannot change the skyline in any direction. Return the maximum total sum that the heights of the buildings can be increased by.

---

## Examples

**Example 1:**
```
Input:  grid = [[3,0,8,4],[2,4,5,7],[9,2,6,3],[0,3,1,0]]
Output: 35
```

---

## Constraints

- `n == grid.length`
- `n == grid[r].length`
- `2 <= n <= 50`
- `0 <= grid[i][j] <= 100`
