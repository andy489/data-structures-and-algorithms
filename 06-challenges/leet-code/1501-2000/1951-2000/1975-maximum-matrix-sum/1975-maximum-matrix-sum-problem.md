# 1975. Maximum Matrix Sum

**Difficulty:** Medium

**Link:** https://leetcode.com/problems/maximum-matrix-sum/

## Problem

You are given an `n x n` integer matrix. You can do the following operation any number of times:

- Choose any two adjacent elements of matrix and multiply each of them by `-1`.

Two elements are considered adjacent if and only if they share a border.

Your goal is to maximize the summation of the matrix's elements. Return the maximum sum of the matrix's elements using the operation mentioned above.

## Examples

**Example 1:**
```
Input: matrix = [[1,-1],[-1,1]]
Output: 4
```

**Example 2:**
```
Input: matrix = [[1,2,3],[-1,-2,-3],[1,2,3]]
Output: 16
```

## Constraints

- `n == matrix.length == matrix[i].length`
- `2 <= n <= 250`
- `-10^5 <= matrix[i][j] <= 10^5`
