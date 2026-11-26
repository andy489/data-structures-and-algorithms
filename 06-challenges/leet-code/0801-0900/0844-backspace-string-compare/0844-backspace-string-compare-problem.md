# 844. Backspace String Compare

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/backspace-string-compare/

---

## Problem Statement

Given two strings `s` and `t`, return `true` if they are equal when both are typed into empty text editors. `'#'` means a backspace character.

---

## Examples

**Example 1:**
```
Input: s = "ab#c", t = "ad#c"
Output: true
Explanation: Both become "ac".
```

**Example 2:**
```
Input: s = "ab##", t = "c#d#"
Output: true
Explanation: Both become "".
```

**Example 3:**
```
Input: s = "a#c", t = "b"
Output: false
```

---

## Constraints

- `1 <= s.length, t.length <= 200`
- `s` and `t` only contain lowercase letters and `'#'` characters.
