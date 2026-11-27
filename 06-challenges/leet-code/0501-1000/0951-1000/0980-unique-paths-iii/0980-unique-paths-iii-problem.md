# 980. Unique Paths III

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/unique-paths-iii/

---

## Problem Statement

You are given an `m x n` integer array `grid` where `grid[i][j]` could be:

- `1` representing the starting square. There is exactly one starting square.
- `2` representing the ending square. There is exactly one ending square.
- `0` representing empty squares we can walk over.
- `-1` representing obstacles that we cannot walk over.

Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.

---

## Examples

**Example 1:**
```
Input:  grid = [[1,0,0,0],[0,0,0,0],[0,0,2,-1]]
Output: 2
```

**Example 2:**
```
Input:  grid = [[1,0,0,0],[0,0,0,0],[0,0,0,2]]
Output: 4
```

---

## Constraints

- `m == grid.length`
- `n == grid[i].length`
- `1 <= m, n <= 20`
- `1 <= m * n <= 20`
- `-1 <= grid[i][j] <= 2`
- There is exactly one starting and one ending cell.
