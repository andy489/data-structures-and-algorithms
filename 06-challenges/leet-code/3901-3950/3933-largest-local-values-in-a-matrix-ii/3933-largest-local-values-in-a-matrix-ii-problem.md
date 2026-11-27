# 3933. Largest Local Values in a Matrix II

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/largest-local-values-in-a-matrix-ii/

## Problem

You are given an `n x m` integer matrix `matrix` containing non-negative integers.

A **non-zero** cell `(row, col)` checks the cells near it as follows:

- Let `x = matrix[row][col]`.
- Consider every cell within `x` rows and `x` columns of `(row, col)`.
- Ignore cells that are outside the matrix.
- Ignore the cells where **both** the row distance and column distance are exactly `x`.

The cell `(row, col)` is a **local maximum** if it is **non-zero** and no considered cell has a value **greater than** `x`.

Return an integer denoting the number of **local maximums** in `matrix`.

## Examples

**Example 1:**

```
Input: matrix = [[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,2,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0],[0,0,0,0,0,0,0]]
Output: 1
```

**Example 2:**

```
Input: matrix = [[1,2],[3,4]]
Output: 1
Explanation: Only cell with value 4 is a local maximum.
```

**Example 3:**

```
Input: matrix = [[1,0,1],[0,1,0],[1,0,1]]
Output: 5
```

**Example 4:**

```
Input: matrix = [[1,1],[1,1]]
Output: 4
```

## Constraints

- `1 <= n == matrix.length <= 200`
- `1 <= m == matrix[i].length <= 200`
- `0 <= matrix[i][j] <= 200`
