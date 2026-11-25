# 885. Spiral Matrix III

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/spiral-matrix-iii/

---

## Problem Statement

You start at the cell `(rStart, cStart)` of an `rows x cols` grid facing east. The northwest corner is at the first row and column in the grid, and the southeast corner is at the last row and column.

You will walk in a clockwise spiral shape to visit every position in this grid. Whenever you move outside the grid's boundary, we continue our walk outside the grid (but may return to the grid boundary later). Eventually, we reach all `rows * cols` spaces of the grid.

Return an array of coordinates representing the positions of the grid in the order you visited them.

---

## Examples

**Example 1:**
```
Input:  rows = 1, cols = 4, rStart = 0, cStart = 0
Output: [[0,0],[0,1],[0,2],[0,3]]
```

---

## Constraints

- `1 <= rows, cols <= 100`
- `0 <= rStart < rows`
- `0 <= cStart < cols`
