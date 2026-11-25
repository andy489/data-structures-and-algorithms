# 856. Score of Parentheses

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/score-of-parentheses/

---

## Problem Statement

Given a balanced parentheses string `s`, return the score of the string based on the following rule:
- `()` has score `1`.
- `AB` has score `A + B`, where `A` and `B` are balanced parentheses strings.
- `(A)` has score `2 * A`, where `A` is a balanced parentheses string.

---

## Examples

**Example 1:**
```
Input:  s = "()"
Output: 1
```

**Example 2:**
```
Input:  s = "(())"
Output: 2
```

**Example 3:**
```
Input:  s = "()()"
Output: 2
```

---

## Constraints

- `2 <= s.length <= 50`
- `s` consists of only `'('` and `')'`.
- `s` is a balanced parentheses string.
