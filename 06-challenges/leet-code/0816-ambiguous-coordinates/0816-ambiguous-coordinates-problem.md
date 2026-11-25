# 816. Ambiguous Coordinates

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/ambiguous-coordinates/

---

## Problem Statement

We had some 2D coordinates like `"(1, 3)"` or `"(2, 0.5)"`, then we removed all commas, decimal points, and spaces. Given a string `s` representing the encoded string, return a list of strings of all the possible original 2D coordinates.

---

## Examples

**Example 1:**
```
Input:  s = "(123)"
Output: ["(1, 23)","(12, 3)","(1.2, 3)","(1, 2.3)"]
```

---

## Constraints

- `4 <= s.length <= 12`
- `s[0] == '('`, `s[s.length - 1] == ')'`
- The original coordinates contained only digits.
