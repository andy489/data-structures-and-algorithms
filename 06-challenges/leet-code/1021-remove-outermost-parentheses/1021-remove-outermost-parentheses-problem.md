# 1021. Remove Outermost Parentheses

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/remove-outermost-parentheses/

---

## Problem Statement

A valid parentheses string is either empty `""`, `"(" + A + ")"`, or `A + B`, where `A` and `B` are valid parentheses strings, and `+` represents string concatenation.

A valid parentheses string `s` is primitive if it is nonempty and there does not exist a way to split it into `s = A + B`, with `A` and `B` nonempty valid parentheses strings.

Given a valid parentheses string `s`, consider its primitive decomposition: `s = P_1 + P_2 + ... + P_k`, where each `P_i` is a primitive valid parentheses string.

Return `s` after removing the outermost parentheses of every primitive string in the primitive decomposition of `s`.

---

## Examples

**Example 1:**
```
Input:  s = "(()())(())"
Output: "()()()"
```

**Example 2:**
```
Input:  s = "(()())(())(()(()))"
Output: "()()()()(())"
```

---

## Constraints

- `1 <= s.length <= 10^5`
- `s[i]` is either `'('` or `')'`.
- `s` is a valid parentheses string.
