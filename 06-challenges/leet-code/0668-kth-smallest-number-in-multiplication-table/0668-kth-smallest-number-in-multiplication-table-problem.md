# 668. Kth Smallest Number in Multiplication Table

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/kth-smallest-number-in-multiplication-table/

---

## Problem Statement

Nearly everyone has used the [Multiplication Table](https://en.wikipedia.org/wiki/Multiplication_table). The multiplication table of size `m x n` is an integer matrix `mat` where `mat[i][j] == i * j` (**1-indexed**).

Given three integers `m`, `n`, and `k`, return the `k`th smallest element in the `m x n` multiplication table.

---

## Examples

**Example 1:**
```
Input:  m = 3, n = 3, k = 5
Output: 3
Explanation: The 5th smallest element is 3.
```

**Example 2:**
```
Input:  m = 2, n = 3, k = 6
Output: 6
```

---

## Constraints

- `1 <= m, n <= 3 * 10⁴`
- `1 <= k <= m * n`
