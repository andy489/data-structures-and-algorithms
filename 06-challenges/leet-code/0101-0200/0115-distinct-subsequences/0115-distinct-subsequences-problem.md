# 115. Distinct Subsequences

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/distinct-subsequences/

---

## Problem Statement

Given two strings `s` and `t`, return _the number of distinct subsequences of `s` which equals `t`_.

A **subsequence** of a string is formed by deleting some (or no) characters without changing the relative order of the remaining characters.

The test cases are generated so that the answer fits in a **32-bit signed integer**.

---

## Examples

**Example 1:**
```
Input:  s = "rabbbit", t = "rabbit"
Output: 3
Explanation: There are 3 ways to form "rabbit" from "rabbbit" by choosing which of the three 'b's to drop.
```

**Example 2:**
```
Input:  s = "babgbag", t = "bag"
Output: 5
```

---

## Constraints

- `1 <= s.length, t.length <= 1000`
- `s` and `t` consist of English letters.
