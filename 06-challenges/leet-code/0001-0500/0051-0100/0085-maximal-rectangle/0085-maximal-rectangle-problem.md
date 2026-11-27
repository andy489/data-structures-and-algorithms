# 85. Maximal Rectangle

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximal-rectangle/

---

## Problem Statement

Given a `rows x cols` binary matrix filled with `'0'`s and `'1'`s, find the largest rectangle containing only `'1'`s and return its area.

---

## Examples

**Example 1:**
```
Input:  matrix = [["1","0","1","0","0"],
                  ["1","0","1","1","1"],
                  ["1","1","1","1","1"],
                  ["1","0","0","1","0"]]
Output: 6
Explanation: The maximal rectangle is shown in the third row spanning columns 1-5 with height 3
             (columns 2-4, height 3... actually the 2×3 block in rows 1-2, cols 2-4 = area 6).
```

**Example 2:**
```
Input:  matrix = [["0"]]
Output: 0
```

**Example 3:**
```
Input:  matrix = [["1"]]
Output: 1
```

---

## Constraints

- `rows == matrix.length`
- `cols == matrix[i].length`
- `1 <= rows, cols <= 200`
- `matrix[i][j]` is `'0'` or `'1'`.
