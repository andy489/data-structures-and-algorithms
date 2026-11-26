# 1541. Minimum Insertions to Balance a Parentheses String

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-insertions-to-balance-a-parentheses-string/

---

## Problem Statement

Given a parentheses string `s` containing only `'('` and `')'`. A parentheses string is balanced if:
- Any left parenthesis `'('` must have a corresponding two consecutive right parentheses `'))'`.
- Left parenthesis `'('` must go before its corresponding `'))'`.

For example, `"())"`, `"())(())))"`, and `"(()())))"` are balanced. `")"`, `")"`, and `"(())"` are not balanced.

You can insert the characters `'('` and `')'` at any position of the string. Return the minimum number of insertions needed to make `s` balanced.

---

## Examples

**Example 1:**
```
Input: s = "(()))"
Output: 1
Explanation: The second '(' does not have a corresponding '))', we need to add ')' at the end.
```

**Example 2:**
```
Input: s = "())"
Output: 0
Explanation: The string is already balanced.
```

**Example 3:**
```
Input: s = "))())("
Output: 3
```

---

## Constraints
- `1 <= s.length <= 10^5`
- `s` consists of `'('` and `')'` only.
