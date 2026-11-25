# 1003. Check If Word Is Valid After Substitutions

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/check-if-word-is-valid-after-substitutions/

---

## Problem Statement

Given a string `s`, determine if it is valid. A string is valid if, starting with the empty string, you can repeatedly insert the string `"abc"` into another string to produce `s`. More formally, `s` is valid if and only if there is some sequence of insertions that produces it.

---

## Examples

**Example 1:**
```
Input:  s = "aabcbc"
Output: true
```

**Example 2:**
```
Input:  s = "abcabcababcc"
Output: true
```

**Example 3:**
```
Input:  s = "abccba"
Output: false
```

---

## Constraints

- `1 <= s.length <= 2 * 10^4`
- `s` consists of letters `'a'`, `'b'`, and `'c'`
