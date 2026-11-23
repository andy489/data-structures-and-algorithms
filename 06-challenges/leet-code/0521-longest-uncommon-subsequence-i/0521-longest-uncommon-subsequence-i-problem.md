# 521. Longest Uncommon Subsequence I

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/longest-uncommon-subsequence-i/

---

## Problem Statement

Given two strings `a` and `b`, return the length of the **longest uncommon subsequence** between the two strings. If no such uncommon subsequence exists, return `-1`.

An **uncommon subsequence** is a subsequence that is a subsequence of one but **not** the other string.

A **subsequence** of a string `s` is a string that can be obtained by deleting any number of characters from `s`.

---

## Examples

**Example 1:**
```
Input:  a = "aba", b = "cdc"
Output: 3
```

**Example 2:**
```
Input:  a = "aaa", b = "bbb"
Output: 3
```

**Example 3:**
```
Input:  a = "aaa", b = "aaa"
Output: -1
```

---

## Constraints

- `1 <= a.length, b.length <= 100`
- `a` and `b` consist of lower-case English letters.
