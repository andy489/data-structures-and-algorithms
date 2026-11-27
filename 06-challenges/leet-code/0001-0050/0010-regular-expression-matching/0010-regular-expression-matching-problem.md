# 10. Regular Expression Matching

**Difficulty:** Hard  
**Link:** https://leetcode.com/problems/regular-expression-matching/

---

## Problem Statement

Given an input string `s` and a pattern `p`, implement regular expression matching with support for `'.'` and `'*'` where:

- `'.'` matches any single character.
- `'*'` matches zero or more of the preceding element.

The matching should cover the **entire** input string (not partial).

---

## Examples

**Example 1:**
```
Input:  s = "aa", p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
```

**Example 2:**
```
Input:  s = "aa", p = "a*"
Output: true
Explanation: '*' means zero or more 'a's. Here it matches two 'a's.
```

**Example 3:**
```
Input:  s = "ab", p = ".*"
Output: true
Explanation: ".*" matches any sequence of characters.
```

---

## Constraints

- `1 <= s.length <= 20`
- `1 <= p.length <= 20`
- `s` contains only lowercase English letters.
- `p` contains only lowercase English letters, `'.'`, and `'*'`.
- It is guaranteed for each occurrence of `'*'`, there will be a previous valid character to match.
