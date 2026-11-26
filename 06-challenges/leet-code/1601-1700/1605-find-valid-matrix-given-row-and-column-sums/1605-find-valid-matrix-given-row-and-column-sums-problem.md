# 1605. Find Valid Matrix Given Row and Column Sums

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/

---

## Problem Statement

You are given two arrays `rowSum` and `colSum` of non-negative integers where `rowSum[i]` is the sum of the elements in the `i`th row and `colSum[j]` is the sum of the elements of the `j`th column of a 2D matrix.

In other words, you do not know the elements of the matrix, but you do know the sums of each row and column.

Find any matrix of **non-negative** integers of size `rowSum.length x colSum.length` that satisfies the `rowSum` and `colSum` requirements.

Return **a 2D array** representing any matrix that fulfills the requirements. It's guaranteed that at least one matrix that fulfills the requirements exists.

---

## Examples

**Example 1:**
```
Input: rowSum = [3,8], colSum = [4,7]
Output: [[3,0],[1,7]]
Explanation:
  Row 0: 3+0=3 ✓, Row 1: 1+7=8 ✓
  Col 0: 3+1=4 ✓, Col 1: 0+7=7 ✓
```

**Example 2:**
```
Input: rowSum = [5,7,10], colSum = [8,6,8]
Output: [[0,5,0],[6,1,0],[2,0,8]]
```

---

## Constraints

- `1 <= rowSum.length, colSum.length <= 500`
- `0 <= rowSum[i], colSum[j] <= 10^8`
- `sum(rowSum) == sum(colSum)`
