# 1717. Maximum Score From Removing Substrings

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/maximum-score-from-removing-substrings/

---

## Problem Statement

You are given a string `s` and two integers `x` and `y`. You can perform two types of operations any number of times.

- Remove substring `"ab"` and gain `x` points.
- Remove substring `"ba"` and gain `y` points.

Return the maximum points you can gain after applying the above operations on `s`.

---

## Examples

**Example 1:**
```
Input: s = "cdbcbbaaabab", x = 4, y = 5
Output: 19
```

**Example 2:**
```
Input: s = "aabbaaxybbaabb", x = 5, y = 4
Output: 20
```

---

## Constraints

- `1 <= s.length <= 10^5`
- `1 <= x, y <= 10^4`
- `s` consists of lowercase English letters.
