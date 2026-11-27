# 1727. Largest Submatrix with Rearrangements

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/largest-submatrix-with-rearrangements/

---

## Problem Statement

You are given a binary matrix `matrix` of size `m x n`, and you are allowed to rearrange the **columns** of the `matrix` in any order.

Return *the area of the largest submatrix within* `matrix` *where* **every** *element of the submatrix is* `1` *after reordering the columns optimally.*

---

## Examples

**Example 1:**
```
Input: matrix = [[0,0,1],[1,1,1],[1,0,1]]
Output: 4
Explanation: Rearrange to [[1,0,0],[1,1,1],[1,1,0]]. The 2x2 submatrix at rows [1,2], cols [0,1] gives area 4.
```

**Example 2:**
```
Input: matrix = [[1,0,1],[1,1,0],[1,1,0]]
Output: 4
```

**Example 3:**
```
Input: matrix = [[0,0],[1,1],[0,0]]
Output: 2
```

---

## Constraints

- `m == matrix.length`
- `n == matrix[i].length`
- `1 <= m, n <= 10^5`
- `m * n <= 10^5`
- `matrix[i][j]` is `0` or `1`.
