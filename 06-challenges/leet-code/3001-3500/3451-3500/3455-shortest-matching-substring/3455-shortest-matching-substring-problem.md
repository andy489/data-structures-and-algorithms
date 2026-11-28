# 3455. Shortest Matching Substring

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/shortest-matching-substring/

---

## Problem Statement

You are given a string `s` and a pattern string `p`, where `p` contains **exactly two** `'*'` characters.

The `'*'` in `p` matches any sequence of zero or more characters.

Return the length of the **shortest** substring in `s` that matches `p`. If there is no such substring, return -1.

**Note:** The empty substring is considered valid.

---

## Examples

**Example 1:**
```
Input: s = "abaacbaecebce", p = "ba*c*ce"
Output: 8
```

**Example 2:**
```
Input: s = "baccbaadbc", p = "cc*baa*adb"
Output: -1
```

**Example 3:**
```
Input: s = "a", p = "**"
Output: 0
```

**Example 4:**
```
Input: s = "madlogic", p = "*adlogi*"
Output: 6
```

---

## Constraints

- `1 <= s.length <= 10^5`
- `2 <= p.length <= 10^5`
- `s` contains only lowercase English letters.
- `p` contains only lowercase English letters and exactly two `'*'`.
