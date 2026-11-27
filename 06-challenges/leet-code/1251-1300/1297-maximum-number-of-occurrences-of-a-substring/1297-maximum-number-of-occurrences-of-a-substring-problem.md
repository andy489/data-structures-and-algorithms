# 1297. Maximum Number of Occurrences of a Substring

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-number-of-occurrences-of-a-substring/

---

## Problem Statement

Given a string `s`, return the maximum number of occurrences of any substring under the following rules:
- The number of unique characters in the substring must be less than or equal to `maxLetters`.
- The substring size must be between `minSize` and `maxSize` inclusive.

---

## Examples

**Example 1:**
```
Input:  s = "aababcaab", maxLetters = 2, minSize = 3, maxSize = 4
Output: 2
```

---

## Constraints

- `1 <= s.length <= 10^5`
- `1 <= maxLetters <= 26`
- `1 <= minSize <= maxSize <= min(26, s.length)`
