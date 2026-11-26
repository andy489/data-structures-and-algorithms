# 1463. Cherry Pickup Ii

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/cherry-pickup-ii/

---

## Problem Statement

Two robots start at top-left and top-right of a grid. They move simultaneously downward. Return max cherries they can collect without double-counting.

---

## Examples

**Example 1:**
```
Input:  grid=[[3,1,1],[2,5,1],[1,5,5],[2,1,1]]
Output: 24
```

**Example 2:**
```
Input:  grid=[[1,0,0,0,0,0,1],[2,0,0,0,0,3,0],[2,3,1,0,3,0,0],[0,0,0,4,0,0,2],[0,0,0,2,0,0,0],[0,0,3,0,0,0,0]]
Output: 28
```

---

## Constraints

- `rows == grid.length`
- `cols == grid[i].length`
- `2 <= rows, cols <= 70`
- `0 <= grid[i][j] <= 100`
