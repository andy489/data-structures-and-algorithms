# 1559. Detect Cycles in 2D Grid

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/detect-cycles-in-2d-grid/

---

## Problem Statement

Given a 2D array of characters `grid` of size `m x n`, you need to find if there exists any cycle consisting of the **same value** in `grid`.

A cycle is a path of **length 4 or more** in the grid that starts and ends at the same cell. From a given cell, you can move to one of the cells adjacent to it — in one of the four directions (up, down, left, or right), if it has the **same value** of the current cell.

Also, you cannot move to the cell you came from in the last step, i.e., the cycle must not contain any sub-path of length 2.

Return `true` if any such cycle of the **same value** exists in `grid`, otherwise, return `false`.

---

## Examples

**Example 1:**
```
Input: grid = [["a","a","a","a"],["a","b","b","a"],["a","b","b","a"],["a","a","a","a"]]
Output: true
Explanation: There are two valid cycles shown in different colors in the image above.
```

**Example 2:**
```
Input: grid = [["c","c","c","a"],["c","d","c","c"],["c","c","e","c"],["f","c","c","c"]]
Output: true
```

**Example 3:**
```
Input: grid = [["a","b","b"],["b","z","b"],["b","b","a"]]
Output: false
```

---

## Constraints
- `m == grid.length`
- `n == grid[i].length`
- `1 <= m, n <= 500`
- `grid[i][j]` is a lowercase English letter.
