# 2033. Minimum Operations to Make a Uni-Value Grid

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-operations-to-make-a-uni-value-grid/

---

## Problem Statement

You are given a 2D integer grid `grid` and an integer `x`. In one operation, add or subtract `x` from any element. Make all elements equal with minimum operations, or return -1 if impossible.

---

## Examples

**Example 1:**
```
Input:  grid = [[2,4],[6,8]], x = 2
Output: 4
```
Explanation: Make all 4: ops = (4-2)/2 + 0 + (6-4)/2 + (8-4)/2 = 1+0+1+2=4.

**Example 2:**
```
Input:  grid = [[1,5],[2,3]], x = 1
Output: 5
```

**Example 3:**
```
Input:  grid = [[1,2],[3,4]], x = 2
Output: -1
```

---

## Constraints

- `m == grid.length`
- `n == grid[0].length`
- `1 <= m, n <= 10^5`
- `1 <= x, grid[i][j] <= 10^4`
