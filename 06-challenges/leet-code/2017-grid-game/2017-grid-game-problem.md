# 2017. Grid Game

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/grid-game/

---

## Problem Statement

You are given a 0-indexed 2D array `grid` of size `2 x n`, where `grid[r][c]` represents the number of points at position `(r, c)`. Two robots are playing a game. Robot 1 goes first from `(0,0)` to `(1,n-1)`. It must move right or down. After it moves, the cells it visits become 0. Then Robot 2 makes the same trip. Return the number of points collected by Robot 2 if **both** robots play **optimally** (Robot 1 minimizes Robot 2's points, Robot 2 maximizes its own).

---

## Examples

**Example 1:**
```
Input:  grid = [[2,5,4],[1,5,1]]
Output: 4
```

**Example 2:**
```
Input:  grid = [[3,3,1],[8,5,2]]
Output: 4
```

**Example 3:**
```
Input:  grid = [[1,3,1,15],[1,3,3,1]]
Output: 7
```

---

## Constraints

- `grid.length == 2`
- `n == grid[0].length`
- `1 <= n <= 5 * 10^4`
- `1 <= grid[i][j] <= 10^5`
