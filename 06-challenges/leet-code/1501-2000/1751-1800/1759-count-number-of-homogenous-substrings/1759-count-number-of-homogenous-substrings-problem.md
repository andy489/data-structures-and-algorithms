# 1759. Count Number of Homogenous Substrings

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-number-of-homogenous-substrings/

---

## Problem Statement

Given a string `s`, return the number of **homogenous** substrings of `s`. Since the answer may be too large, return it **modulo** `10^9 + 7`.

A string is **homogenous** if all the characters of the string are the same.

A **substring** is a contiguous sequence of characters within a string.

---

## Examples

**Example 1:**
```
Input: s = "abbcccaa"
Output: 13
Explanation: Homogenous substrings: "a" appears 3 times, "b" appears 2 times, "c" appears 3 times, "aa" appears 1 time, "bb" appears 1 time, "cc" appears 2 times, "ccc" appears 1 time, "aaa" - no. Total = 3+2+3+1+1+2+1 = 13.
```

**Example 2:**
```
Input: s = "xy"
Output: 2
```

**Example 3:**
```
Input: s = "zzzzz"
Output: 15
```

---

## Constraints

- `1 <= s.length <= 10^5`
- `s` consists of lowercase letters.
