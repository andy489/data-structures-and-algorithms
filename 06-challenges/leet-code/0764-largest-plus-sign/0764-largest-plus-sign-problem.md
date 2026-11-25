# 764. Largest Plus Sign

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/largest-plus-sign/

---

## Problem Statement

You are given an integer `n`. You have an `n x n` binary grid `grid` with all values initially `1`'s except for some indices given in the array `mines`. The `i`th element of the array `mines` is defined as `mines[i] = [xi, yi]` where `grid[xi][yi] == 0`.

Return the **order** of the largest axis-aligned plus sign of `1`'s contained in `grid`. If there is none, return `0`.

An **axis-aligned plus sign** of `1`'s of order `k` has some center `grid[r][c] == 1` along with four arms of length `k - 1` going up, down, left, and right, all of value `1`.

---

## Examples

**Example 1:**
```
Input:  n = 5, mines = [[4,2]]
Output: 2
```

**Example 2:**
```
Input:  n = 1, mines = []
Output: 1
```

---

## Constraints

- `1 <= n <= 500`
- `0 <= mines.length <= 5000`
- `0 <= xi, yi < n`
- All the pairs `(xi, yi)` are **unique**.
