# 44. Wildcard Matching

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/wildcard-matching/

---

## Problem Statement

Given an input string `s` and a pattern `p`, implement wildcard pattern matching with support for `'?'` and `'*'` where:

- `'?'` matches any single character.
- `'*'` matches any sequence of characters (including the empty sequence).

The matching should cover the **entire** input string (not partial).

---

## Examples

**Example 1:**
```
Input:  s = "aa", p = "a"
Output: false
```

**Example 2:**
```
Input:  s = "aa", p = "*"
Output: true
```

**Example 3:**
```
Input:  s = "cb", p = "?a"
Output: false
```

**Example 4:**
```
Input:  s = "adceb", p = "*a*b"
Output: true
```

**Example 5:**
```
Input:  s = "acdcb", p = "a*c?b"
Output: false
```

---

## Constraints

- `0 <= s.length, p.length <= 2000`
- `s` contains only lowercase English letters.
- `p` contains only lowercase English letters, `'?'` or `'*'`.
