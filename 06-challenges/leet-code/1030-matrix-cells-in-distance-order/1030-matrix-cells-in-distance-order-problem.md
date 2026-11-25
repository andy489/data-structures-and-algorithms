# 1030. Matrix Cells in Distance Order

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/matrix-cells-in-distance-order/

---

## Problem Statement

You are given four integers `rows`, `cols`, `rCenter`, and `cCenter`. There is a `rows x cols` matrix and you are on the cell with the coordinates `(rCenter, cCenter)`.

Return the coordinates of all cells in the matrix, sorted by their distance from `(rCenter, cCenter)` from the smallest distance to the largest distance. You may return the answer in any order that satisfies this condition.

The distance between two cells `(r1, c1)` and `(r2, c2)` is `|r1 - r2| + |c1 - c2|`.

---

## Examples

**Example 1:**
```
Input:  rows = 1, cols = 2, rCenter = 0, cCenter = 0
Output: [[0,0],[0,1]]
```

**Example 2:**
```
Input:  rows = 2, cols = 2, rCenter = 0, cCenter = 1
Output: [[0,1],[0,0],[1,1],[1,0]]
```

---

## Constraints

- `1 <= rows, cols <= 100`
- `0 <= rCenter < rows`
- `0 <= cCenter < cols`
