# 730. Count Different Palindromic Subsequences

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-different-palindromic-subsequences/

---

## Problem Statement

Given a string `s`, return the number of different non-empty palindromic subsequences in `s`. Since the answer may be very large, return it **modulo** `10^9 + 7`.

A subsequence is obtained by deleting some characters (possibly zero) from the string without changing the remaining character order.

A sequence is palindromic if it is equal to the reverse of itself.

Two sequences `a1, a2, ...` and `b1, b2, ...` are different if there is some `i` for which `ai != bi`.

---

## Examples

**Example 1:**
```
Input:  s = "bccb"
Output: 6
Explanation: The 6 different non-empty palindromic subsequences are: 'b', 'c', 'bb', 'cc', 'bcb', 'bccb'.
```

**Example 2:**
```
Input:  s = "abcdabcdabcdabcdabcdabcdabcdabcda"
Output: 104860361
```

---

## Constraints

- `1 <= s.length <= 1000`
- `s[i]` is either `'a'`, `'b'`, `'c'`, or `'d'`.
