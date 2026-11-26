# 1614. Maximum Nesting Depth of the Parentheses

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/maximum-nesting-depth-of-the-parentheses/

---

## Problem Statement

A string is a **valid parentheses string** (denoted **VPS**) if and only if it consists of `"("` and `")"` characters only, and either:
- It is an empty string `""`, or a single character not equal to `"("` or `")"`,
- It can be written as `AB` (`A` concatenated with `B`) where both `A` and `B` are VPS's, or
- It can be written as `(A)` where `A` is a VPS.

The **nesting depth** of `s` is the maximum number of open parentheses at any point.

Given a VPS represented as `s`, return the **nesting depth** of `s`.

---

## Examples

**Example 1:**
```
Input: s = "(1+(2*3)+((8)/4))+1"
Output: 3
```

**Example 2:**
```
Input: s = "(1)+((2))+(((3)))"
Output: 3
```

---

## Constraints

- `1 <= s.length <= 100`
- `s` consists of digits `0-9` and characters `'+'`, `'-'`, `'*'`, `'/'`, `'('`, and `')'`
- It is guaranteed that parentheses expression `s` is a VPS
