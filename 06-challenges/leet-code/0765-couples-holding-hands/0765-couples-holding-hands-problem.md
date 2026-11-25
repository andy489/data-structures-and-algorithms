# 765. Couples Holding Hands

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/couples-holding-hands/

---

## Problem Statement

There are `n` couples sitting in `2n` seats arranged in a row and want to hold hands.

The people and seats are represented by an integer array `row` where `row[i]` is the ID of the person sitting in the `i`th seat. The couples are numbered in order, the first couple being `(0, 1)`, the second couple `(2, 3)`, and so on with the last couple being `(2n - 2, 2n - 1)`.

Return the **minimum** number of swaps so that every couple is sitting side by side. A swap consists of choosing any two people, then they stand up and switch seats.

---

## Examples

**Example 1:**
```
Input:  row = [0,2,1,3]
Output: 1
```

**Example 2:**
```
Input:  row = [3,2,1,0]
Output: 0
```

---

## Constraints

- `2n == row.length`
- `2 <= n <= 30`
- `0 <= row[i] <= 2n - 1`
- All the integers in `row` are **unique**.
