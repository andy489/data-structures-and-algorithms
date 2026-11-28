# 3462. Maximum Sum With at Most K Elements

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-sum-with-at-most-k-elements/

---

## Problem Statement

You are given a 2D integer matrix `grid` of size `n x m`, an integer array `limits` of length `n`, and an integer `k`. The task is to find the **maximum sum** of **at most** `k` elements from the matrix `grid` such that:

- The number of elements taken from the `i-th` row of `grid` does not exceed `limits[i]`.

Return the **maximum sum**.

---

## Examples

**Example 1:**
```
Input: grid = [[1,2],[3,4]], limits = [1,2], k = 2
Output: 7
```

**Example 2:**
```
Input: grid = [[5,3,7],[8,2,6]], limits = [2,2], k = 3
Output: 21
```

---

## Constraints

- `n == grid.length == limits.length`
- `m == grid[i].length`
- `1 <= n, m <= 500`
- `0 <= grid[i][j] <= 10^5`
- `0 <= limits[i] <= m`
- `0 <= k <= min(n * m, sum(limits))`
