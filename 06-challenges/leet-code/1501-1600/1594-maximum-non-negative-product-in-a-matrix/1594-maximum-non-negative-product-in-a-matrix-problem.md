# 1594. Maximum Non Negative Product in a Matrix

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/

---

## Problem Statement

You are given a `m x n` matrix `grid`. Initially, you are located at the top-left corner `(0, 0)`, and in each step, you can only **move right** or **move down** in the matrix. Among all possible paths starting from the top-left corner `(0, 0)` and ending in the bottom-right corner `(m - 1, n - 1)`, find the path with the **maximum non-negative product**. The product of a path is the product of all integers in the grid cells visited along the path.

Return the **maximum non-negative product modulo** `10^9 + 7`. **If the maximum product is negative, return** `-1`.

Notice that the modulo is performed after getting the maximum product.

---

## Examples

**Example 1:**
```
Input:  grid = [[-1,-2,-3],[-2,-3,-3],[-3,-3,-2]]
Output: -1
```

**Example 2:**
```
Input:  grid = [[1,-2,1],[1,-2,1],[3,-4,1]]
Output: 8
```

**Example 3:**
```
Input:  grid = [[1,3],[0,-4]]
Output: 0
```

---

## Constraints

- `m == grid.length`
- `n == grid[i].length`
- `1 <= m, n <= 15`
- `-4 <= grid[i][j] <= 4`
