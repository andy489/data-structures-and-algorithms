# 1253. Reconstruct a 2 Row Binary Matrix

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/reconstruct-a-2-row-binary-matrix/

---

## Problem Statement

Given the following details of a matrix with n columns and 2 rows:
- The matrix is a binary matrix, which means each element in the matrix can be 0 or 1.
- The sum of elements of the 0-th (upper) row is given as upper.
- The sum of elements of the 1-st (lower) row is given as lower.
- The sum of elements in the i-th column (0-indexed) is colsum[i], which can be either 0, 1, or 2.

Your task is to reconstruct the matrix with upper, lower, and colsum.

---

## Examples

**Example 1:**
```
Input:  upper = 2, lower = 1, colsum = [1,1,1]
Output: [[1,1,0],[0,0,1]]
```

---

## Constraints

- `1 <= colsum.length <= 10^5`
- `0 <= upper, lower <= colsum.length`
- `0 <= colsum[i] <= 2`
