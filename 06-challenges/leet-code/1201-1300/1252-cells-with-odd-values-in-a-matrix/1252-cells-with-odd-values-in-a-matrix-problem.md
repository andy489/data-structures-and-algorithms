# 1252. Cells with Odd Values in a Matrix

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/cells-with-odd-values-in-a-matrix/

---

## Problem Statement

There is an `m x n` matrix that is initialized to all `0`'s. There is also a 2D array `indices` where each `indices[i] = [ri, ci]` represents a 0-indexed location to perform some increment operations on the matrix.

For each location `indices[i]`, do both of the following:
1. Increment all the cells on row `ri`.
2. Increment all the cells on column `ci`.

Return the number of cells with odd values in the matrix after all operations are performed.

---

## Examples

**Example 1:**
```
Input:  m = 2, n = 3, indices = [[0,1],[1,1]]
Output: 6
```

---

## Constraints

- `1 <= m, n <= 50`
- `1 <= indices.length <= 100`
- `0 <= ri < m`
- `0 <= ci < n`
