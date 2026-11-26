# 2060. Check If an Original String Exists Given Two Encoded Strings

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/check-if-an-original-string-exists-given-two-encoded-strings/

---

## Problem Statement

An encoded string may contain digits representing repetition of the previous group. Given two encoded strings `s1` and `s2`, check if there's a common original string they could both encode.

---

## Examples

**Example 1:**
```
Input:  s1 = "internationalization", s2 = "i18n"
Output: true
```

**Example 2:**
```
Input:  s1 = "l123e", s2 = "44"
Output: true
```

**Example 3:**
```
Input:  s1 = "a5b", s2 = "c5b"
Output: false
```

---

## Constraints

- `1 <= s1.length, s2.length <= 40`
- `s1 and s2 consist of lowercase English letters and digits.`
- `1 <= number of wildcards in s1, s2 <= 10^4`
