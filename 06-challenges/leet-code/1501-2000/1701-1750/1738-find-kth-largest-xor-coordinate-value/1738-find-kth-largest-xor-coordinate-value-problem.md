# 1738. Find Kth Largest XOR Coordinate Value

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-kth-largest-xor-coordinate-value/

---

## Problem Statement

You are given a 2D matrix of size `m x n`, consisting of non-negative integers. You are also given an integer `k`.

The **value** of coordinate `(a, b)` of the matrix is the XOR of all `matrix[i][j]` where `0 <= i <= a < m` and `0 <= j <= b < n` (0-indexed).

Find the `k`th largest value (1-indexed) among all the coordinates of the matrix.

---

## Examples

**Example 1:**
```
Input: matrix = [[5,2],[1,6]], k = 1
Output: 7
Explanation: The XOR values: (0,0)=5, (0,1)=7, (1,0)=4, (1,1)=0. Largest is 7.
```

**Example 2:**
```
Input: matrix = [[5,2],[1,6]], k = 2
Output: 5
```

**Example 3:**
```
Input: matrix = [[5,2],[1,6]], k = 3
Output: 4
```

---

## Constraints

- `m == matrix.length`
- `n == matrix[i].length`
- `1 <= m, n <= 1000`
- `0 <= matrix[i][j] <= 10^6`
- `1 <= k <= m * n`
