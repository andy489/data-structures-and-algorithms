# 2911. Minimum Changes to Make K Semi-palindromes

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-changes-to-make-k-semi-palindromes/

---

## Problem Statement

Given a string `s` and an integer `k`, partition `s` into `k` non-empty contiguous substrings. Return the minimum number of character changes required so that every substring becomes a **semi-palindrome**.

A string of length `l` is a **semi-palindrome** if there exists a positive divisor `d` of `l` with `1 ≤ d < l` such that, for every index `i` in `[0, d - 1]`, the characters at positions `i, i + d, i + 2d, ...` form a palindrome.

**Example:** `"abcabc"` with `d = 3` gives groups `"aa"`, `"bb"`, `"cc"` — each a palindrome, so it is a semi-palindrome.

---

## Examples

**Example 1:**
```
Input:  s = "abcac", k = 2
Output: 1
```
Partition into `"ab"` and `"cac"`. Change `"ab"` → `"aa"` (semi-palindrome with `d = 1`). One change total.

**Example 2:**
```
Input:  s = "abcdef", k = 2
Output: 2
```
Partition into `"abc"` and `"def"`. Each needs one change. Two changes total.

**Example 3:**
```
Input:  s = "aabbaa", k = 3
Output: 0
```
Partition into `"aa"`, `"bb"`, `"aa"`. All are already semi-palindromes.

---

## Constraints

- `2 ≤ s.length ≤ 200`
- `1 ≤ k ≤ s.length / 2`
- `s` consists of lowercase English letters only
