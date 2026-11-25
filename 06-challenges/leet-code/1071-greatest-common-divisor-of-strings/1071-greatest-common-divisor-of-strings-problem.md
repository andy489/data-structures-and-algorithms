# 1071. Greatest Common Divisor of Strings

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/greatest-common-divisor-of-strings/

---

## Problem Statement

For two strings `s` and `t`, we say "`t` divides `s`" if and only if `s = t + t + t + ... + t + t` (i.e., `t` is concatenated with itself one or more times).

Given two strings `str1` and `str2`, return the largest string `x` such that `x` divides both `str1` and `str2`.

---

## Examples

**Example 1:**
```
Input:  str1 = "ABCABC", str2 = "ABC"
Output: "ABC"
```

**Example 2:**
```
Input:  str1 = "ABABAB", str2 = "ABAB"
Output: "AB"
```

---

## Constraints

- `1 <= str1.length, str2.length <= 1000`
- `str1` and `str2` consist of English uppercase letters.
