# 779. K-th Symbol in Grammar

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/k-th-symbol-in-grammar/

---

## Problem Statement

We build a table of `n` rows (1-indexed). We start by writing `0` in the 1st row. Now in every subsequent row, we look at the previous row and replace each occurrence of `0` with `01`, and each occurrence of `1` with `10`.

Given two integer `n` and `k`, return the `k`-th (1-indexed) symbol in the `n`-th row of the table.

---

## Examples

**Example 1:**
```
Input:  n = 1, k = 1
Output: 0
```

**Example 2:**
```
Input:  n = 2, k = 1
Output: 0
```

**Example 3:**
```
Input:  n = 2, k = 2
Output: 1
```

---

## Constraints

- `1 <= n <= 30`
- `1 <= k <= 2^(n - 1)`
