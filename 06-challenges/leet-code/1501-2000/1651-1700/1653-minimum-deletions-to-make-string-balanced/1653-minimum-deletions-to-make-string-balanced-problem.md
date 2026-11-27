# 1653. Minimum Deletions to Make String Balanced

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/

---

## Problem Statement

You are given a string `s` consisting only of characters `'a'` and `'b'`.

You can delete any number of characters in `s` to make `s` **balanced**. `s` is balanced if there is no pair of indices `(i, j)` such that `i < j` and `s[i] = 'b'` and `s[j] = 'a'`.

Return the **minimum** number of deletions needed to make `s` balanced.

---

## Examples

**Example 1:**
```
Input: s = "aababbab"
Output: 2
```

**Example 2:**
```
Input: s = "bbaaaaabb"
Output: 2
```

---

## Constraints

- `1 <= s.length <= 10^5`
- `s[i]` is `'a'` or `'b'`.
