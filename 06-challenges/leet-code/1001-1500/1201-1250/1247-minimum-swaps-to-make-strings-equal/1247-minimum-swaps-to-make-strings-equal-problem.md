# 1247. Minimum Swaps to Make Strings Equal

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-swaps-to-make-strings-equal/

---

## Problem Statement

You are given two strings `s1` and `s2` of equal length consisting of letters `'x'` and `'y'` only. Your task is to make these two strings equal to each other. You can swap any two characters that belong to different strings, which means: swap `s1[i]` and `s2[j]`.

Return the minimum number of swaps required to make `s1` and `s2` equal, or return `-1` if it is impossible.

---

## Examples

**Example 1:**
```
Input:  s1 = "xx", s2 = "yy"
Output: 1
```

---

## Constraints

- `1 <= s1.length, s2.length <= 1000`
- `s1.length == s2.length`
- `s1, s2 only contain 'x' or 'y'`
