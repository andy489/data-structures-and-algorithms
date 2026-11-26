# 1284. Minimum Number of Flips to Convert Binary Matrix to Zero Matrix

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-number-of-flips-to-convert-binary-matrix-to-zero-matrix/

---

## Problem Statement

Given a `m x n` binary matrix `mat`. In one step, you can choose one cell and flip it and all the four neighbors of it if they exist (Flip is changing 1 to 0 and 0 to 1). A pair of cells are called neighbors if they share one edge.

Return the minimum number of flips required to convert `mat` to the zero matrix. If there is no possible solution, return `-1`.

---

## Examples

**Example 1:**
```
Input:  mat = [[0,0],[0,1]]
Output: 3
```

---

## Constraints

- `m == mat.length`
- `n == mat[i].length`
- `1 <= m, n <= 3`
- `mat[i][j] is either 0 or 1`
