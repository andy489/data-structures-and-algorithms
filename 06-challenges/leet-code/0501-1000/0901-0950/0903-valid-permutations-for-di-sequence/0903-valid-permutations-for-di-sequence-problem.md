# 903. Valid Permutations for DI Sequence

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/valid-permutations-for-di-sequence/

---

## Problem Statement

You are given a string `s` of length `n` where `s[i]` is either `'D'` or `'I'`:
- `s[i] == 'I'` means the next pair in a permutation of `[0, 1, ..., n]` must be increasing.
- `s[i] == 'D'` means the next pair must be decreasing.

Return the number of valid permutations of `[0, 1, ..., n]` that satisfy the given constraints. Since the answer may be large, return it **modulo** `10^9 + 7`.

---

## Examples

**Example 1:**
```
Input:  s = "DID"
Output: 5
```

---

## Constraints

- `n == s.length`
- `1 <= n <= 200`
- `s[i]` is either `'I'` or `'D'`.
