# 474. Ones and Zeroes

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/ones-and-zeroes/

---

## Problem Statement

You are given an array of binary strings `strs` and two integers `m` and `n`.

Return the size of the largest subset of `strs` such that there are **at most** `m` `0`'s and `n` `1`'s in the subset.

A set `x` is a **subset** of a set `y` if all elements of `x` are also elements of `y`.

---

## Examples

**Example 1:**
```
Input:  strs = ["10","0001","111001","1","0"], m = 5, n = 3
Output: 4
```

**Example 2:**
```
Input:  strs = ["10","0","1"], m = 1, n = 1
Output: 2
```

---

## Constraints

- `1 <= strs.length <= 600`
- `1 <= strs[i].length <= 100`
- `strs[i]` consists only of digits `'0'` and `'1'`.
- `1 <= m, n <= 100`
