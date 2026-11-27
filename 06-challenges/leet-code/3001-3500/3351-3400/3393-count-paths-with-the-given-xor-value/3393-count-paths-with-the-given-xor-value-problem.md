# 3393. Count Paths With the Given XOR Value

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-paths-with-the-given-xor-value/

---

## Problem Statement

You are given a 2D integer array `grid` with dimensions `m x n`. You are also given an integer `k`.

Your task is to calculate the number of paths from the top-left cell `(0, 0)` to the bottom-right cell `(m - 1, n - 1)` satisfying the following constraint:

The XOR of all the numbers on the path should be equal to `k`.

Return the total number of such paths. Since the answer can be very large, return it modulo `10^9 + 7`.

You may only move **right** or **down** at each step.

---

## Examples

**Example 1:**
```
Input:  grid = [[2,1,5],[7,10,0],[12,6,4]], k = 11
Output: 3
```

**Example 2:**
```
Input:  grid = [[1,3,3,3],[0,3,3,2],[3,0,1,1]], k = 2
Output: 5
```

**Example 3:**
```
Input:  grid = [[1,1,1,2],[3,0,3,2],[3,0,2,2]], k = 10
Output: 0
```

---

## Constraints

- `1 <= m == grid.length <= 300`
- `1 <= n == grid[r].length <= 300`
- `0 <= grid[r][c] < 16`
- `0 <= k < 16`
