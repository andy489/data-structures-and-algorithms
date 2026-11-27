# 957. Prison Cells After N Days

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/prison-cells-after-n-days/

---

## Problem Statement

There are `8` prison cells in a row and each cell is either occupied or vacant, represented by `1` or `0` respectively.

Each day, whether the cell is occupied or not changes according to the following rules:

- If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
- Otherwise, it becomes vacant.

Note that because the cell is in a row, the first and the last cells in the row can't have two adjacent neighbors.

You are given an integer array `cells` where `cells[i] == 1` if the `i`th cell is occupied and `cells[i] == 0` if it is vacant, and you are given an integer `n`.

Return the state of the prison after `n` days (i.e., `n` such changes described above).

---

## Examples

**Example 1:**
```
Input:  cells = [0,1,0,1,1,0,0,1], n = 7
Output: [0,0,1,1,0,0,0,0]
```

---

## Constraints

- `cells.length == 8`
- `cells[i]` is either `0` or `1`.
- `1 <= n <= 10^9`
