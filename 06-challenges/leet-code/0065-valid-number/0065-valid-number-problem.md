# 65. Valid Number

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/valid-number/

---

## Problem Statement

Given a string `s`, return `true` if `s` is a **valid number**, or `false` otherwise.

A **valid number** is either a **decimal number** or an **integer** followed by an optional exponent.

A **decimal number** can be written with an optional sign (`'+'` or `'-'`) followed by one of:
- Digits followed by a dot: `"2."`
- Digits followed by a dot followed by digits: `"2.3"`
- A dot followed by digits: `".3"`

An **integer** can be written with an optional sign followed by digits.

An **exponent** is the character `'e'` or `'E'` followed by an integer.

---

## Examples

**Example 1:**
```
Input:  s = "0"
Output: true
```

**Example 2:**
```
Input:  s = "e"
Output: false
```

**Example 3:**
```
Input:  s = "."
Output: false
```

**Valid examples:** `"2"`, `"0089"`, `"-0.1"`, `"+3.14"`, `"4."`, `"-.9"`, `"2e10"`, `"-90E3"`, `"3e+7"`, `"+6e-1"`, `"53.5e93"`, `"-123.456e789"`

**Invalid examples:** `"abc"`, `"1a"`, `"1e"`, `"e3"`, `"99e2.5"`, `"--6"`, `"-+3"`, `"95a54e53"`

---

## Constraints

- `1 <= s.length <= 20`
- `s` consists of only English letters, digits `0-9`, `'+'`, `'-'`, and `'.'`
