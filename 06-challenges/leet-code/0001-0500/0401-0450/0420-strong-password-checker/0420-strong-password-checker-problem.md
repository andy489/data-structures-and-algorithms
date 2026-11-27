# 420. Strong Password Checker

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/strong-password-checker/

---

## Problem Statement

A password is considered **strong** if the below conditions are all met:

- It has at least `6` characters and at most `20` characters.
- It contains at least **one lowercase** letter, at least **one uppercase** letter, and at least **one digit**.
- It does not contain three repeating characters in a row (i.e., `"B**aaa**bb0"` is weak, but `"B**aa**bb0"` is strong).

Given a string `password`, return the **minimum number of steps** required to make `password` strong. if `password` is already strong, return `0`.

In one step, you can:

- Insert one character to `password`,
- Delete one character from `password`, or
- Replace one character of `password` with another character.

---

## Examples

**Example 1:**
```
Input:  s = "a"
Output: 5
```

**Example 2:**
```
Input:  s = "aA1"
Output: 3
```

**Example 3:**
```
Input:  s = "1337C0d3"
Output: 0
```

---

## Constraints

- `1 <= s.length <= 50`
- `s` consists of letters, digits, dot `'.'` or exclamation mark `'!'`.
