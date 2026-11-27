# 1625. Lexicographically Smallest String After Applying Operations

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations/

---

## Problem Statement

You are given a string `s` of **even length** consisting of digits from `0` to `9`, and two integers `a` and `b`.

You can apply either of the following two operations any number of times and in any order on `s`:

1. **Add** `a` to all odd indices of `s` (0-indexed). Digits post the addition are taken modulo 10.
2. **Rotate** `s` to the right by `b` positions.

Return the **lexicographically smallest** string you can obtain by applying the above operations any number of times on `s`.

---

## Examples

**Example 1:**
```
Input: s = "5525", a = 9, b = 2
Output: "2050"
```

**Example 2:**
```
Input: s = "74", a = 5, b = 1
Output: "24"
```

**Example 3:**
```
Input: s = "0011", a = 4, b = 2
Output: "0011"
```

---

## Constraints
- `2 <= s.length <= 100`
- `s.length` is even.
- `0 <= a <= 9`
- `0 <= b < s.length`
- `s` consists of digits only.
