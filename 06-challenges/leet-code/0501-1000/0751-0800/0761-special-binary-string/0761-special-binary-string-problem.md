# 761. Special Binary String

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/special-binary-string/

---

## Problem Statement

**Special binary strings** are binary strings with the following two properties:

- The number of `0`'s is equal to the number of `1`'s.
- Every prefix of the binary string has at least as many `1`'s as `0`'s.

You are given a **special binary** string `s`.

A move consists of choosing two consecutive, non-empty special substrings of `s`, and swapping them.

Return the **lexicographically largest** result that can be obtained after any number of moves.

---

## Examples

**Example 1:**
```
Input:  s = "11011000"
Output: "11100100"
```

**Example 2:**
```
Input:  s = "10"
Output: "10"
```

---

## Constraints

- `1 <= s.length <= 50`
- `s[i]` is either `'0'` or `'1'`.
- `s` is a special binary string.
