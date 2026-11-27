# 1638. Count Substrings That Differ by One Character

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-substrings-that-differ-by-one-character/

---

## Problem Statement

Given two strings `s` and `t`, find the number of ways you can choose a non-empty substring of `s` and replace a **single character** by a different character such that the resulting substring is a substring of `t`. In other words, find the number of substrings in `s` that differ from some substring in `t` by **exactly one character**.

---

## Examples

**Example 1:**
```
Input: s = "aba", t = "baba"
Output: 6
Explanation: The 6 pairs are (s[0..0], t[1..1]), (s[0..2], t[0..2]), (s[0..2], t[1..3]),
             (s[2..2], t[1..1]), (s[2..2], t[3..3]), (s[0..0], t[3..3]).
```

**Example 2:**
```
Input: s = "ab", t = "bb"
Output: 3
Explanation: Substrings of s that differ by exactly one char from some substring of t:
             "a", "ab", "b".
```

---

## Constraints

- `1 <= s.length, t.length <= 100`
- `s` and `t` consist of lowercase English letters.
