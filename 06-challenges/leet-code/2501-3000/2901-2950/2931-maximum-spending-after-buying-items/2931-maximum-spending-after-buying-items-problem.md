# 2931. Maximum Spending After Buying Items

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/maximum-spending-after-buying-items/

---

## Problem Statement

You are given a **0-indexed** `m * n` integer matrix `values`, representing the values of `m * n` different items in `m` different shops. Each shop has `n` items where the `j`th item in the `i`th shop has a value of `values[i][j]`. Additionally, the items in the `i`th shop are sorted in non-increasing order of value. That is, `values[i][j] >= values[i][j + 1]` for all `0 <= j < n - 1`.

On each day, you would like to buy a single item from one of the shops. Specifically, on the `d`th day you can:
- Pick any shop `i`.
- Buy the rightmost available item `j` for the price of `values[i][j] * d`. That is, find the greatest index `j` such that item `j` was never bought before, and buy it for the price of `values[i][j] * d`.

Return the **maximum amount of money that can be spent** on buying all `m * n` products.

---

## Examples

**Example 1:**
```
Input: values = [[8,5,2],[6,4,1],[9,7,3]]
Output: 285
```

**Example 2:**
```
Input: values = [[10,8,6,4,2],[9,7,5,3,2]]
Output: 386
```

---

## Constraints

- `1 <= m == values.length <= 10`
- `1 <= n == values[i].length <= 10^4`
- `1 <= values[i][j] <= 10^6`
- `values[i]` are sorted in non-increasing order.
