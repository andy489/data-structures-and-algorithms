# 1439. Find The Kth Smallest Sum Of A Matrix With Sorted Rows

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/find-the-kth-smallest-sum-of-a-matrix-with-sorted-rows/

---

## Problem Statement

Each row of the matrix is sorted. Pick one element per row. Return the k-th smallest sum.

---

## Examples

**Example 1:**
```
Input:  mat=[[1,3,11],[2,4,6]],k=5
Output: 7
```

**Example 2:**
```
Input:  mat=[[1,3,11],[2,4,6]],k=9
Output: 17
```

---

## Constraints

- `m == mat.length`
- `n == mat[i].length`
- `1 <= m, n <= 40`
- `1 <= mat[i][j] <= 5000`
- `1 <= k <= min(200, n^m)`
