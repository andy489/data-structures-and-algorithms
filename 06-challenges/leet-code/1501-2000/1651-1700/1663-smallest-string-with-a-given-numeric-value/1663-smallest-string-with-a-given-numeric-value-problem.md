# 1663. Smallest String With A Given Numeric Value

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/smallest-string-with-a-given-numeric-value/

---

## Problem Statement

The **numeric value** of a **lowercase character** is defined as its position `(1-indexed)` in the alphabet, so the numeric value of `a` is `1`, the numeric value of `b` is `2`, the numeric value of `z` is `26`, and so on.

The **numeric value** of a **string** consisting of lowercase characters is defined as the sum of its characters' numeric values. For example, the numeric value of the string `"abe"` is equal to `1 + 2 + 5 = 8`.

You are given two integers `n` and `k`. Return **the lexicographically smallest string** with **length** equal to `n` and **numeric value** equal to `k`.

---

## Examples

**Example 1:**
```
Input: n = 3, k = 27
Output: "aay"
Explanation: The numeric value of the string is 1 + 1 + 25 = 27, and it is the smallest string with such a value.
```

**Example 2:**
```
Input: n = 5, k = 73
Output: "aaszz"
```

---

## Constraints

- `1 <= n <= 10^5`
- `n <= k <= 26 * n`
