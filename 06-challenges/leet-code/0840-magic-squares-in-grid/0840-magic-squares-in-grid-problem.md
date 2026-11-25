# 840. Magic Squares In Grid

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/magic-squares-in-grid/

---

## Problem Statement

A `3 x 3` magic square is a `3 x 3` grid filled with distinct numbers from `1` to `9` such that each row, column, and both diagonals all have the same sum of `15`. Given a `row x col` grid of integers, return the number of 3 × 3 contiguous magic square subgrids.

---

## Examples

**Example 1:**
```
Input:  grid = [[4,3,8,4],[9,5,1,9],[2,7,6,2]]
Output: 1
```

---

## Constraints

- `row == grid.length`
- `col == grid[i].length`
- `1 <= row, col <= 10`
- `0 <= grid[i][j] <= 15`
