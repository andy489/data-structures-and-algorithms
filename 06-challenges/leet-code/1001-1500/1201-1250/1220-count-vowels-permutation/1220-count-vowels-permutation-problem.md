# 1220. Count Vowels Permutation

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-vowels-permutation/

---

## Problem Statement

Given an integer `n`, your task is to count how many strings of length `n` can be formed under the following rules:
- Each character is a lowercase vowel (`a`, `e`, `i`, `o`, `u`).
- Each vowel `a` may only be followed by an `e`.
- Each vowel `e` may only be followed by an `a` or an `i`.
- Each vowel `i` may **not** be followed by another `i`.
- Each vowel `o` may only be followed by an `i` or a `u`.
- Each vowel `u` may only be followed by an `a`.

Since the answer may be too large, return it modulo `10^9 + 7`.

---

## Examples

**Example 1:**
```
Input:  n = 1
Output: 5
```

---

## Constraints

- `1 <= n <= 2 * 10^4`
