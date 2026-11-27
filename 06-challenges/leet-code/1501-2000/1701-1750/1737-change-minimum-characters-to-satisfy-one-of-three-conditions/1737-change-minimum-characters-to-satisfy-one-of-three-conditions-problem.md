# 1737. Change Minimum Characters to Satisfy One of Three Conditions

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/change-minimum-characters-to-satisfy-one-of-three-conditions/

---

## Problem Statement

You are given two strings `a` and `b` that consist of lowercase letters. In one operation, you can change any character in `a` or `b` to **any lowercase letter**.

Your goal is to satisfy **one** of the following three conditions:

1. **Every** letter in `a` is **strictly less than** every letter in `b` in the alphabet.
2. **Every** letter in `b` is **strictly less than** every letter in `a` in the alphabet.
3. **Both** `a` and `b` consist of **only one** distinct letter.

Return *the **minimum** number of operations needed to achieve your goal.*

---

## Examples

**Example 1:**
```
Input: a = "aba", b = "caa"
Output: 2
Explanation: Convert 'b' in a to 'a', and 'c' in b to 'a'. Both consist of only 'a'. Cost = 2.
```

**Example 2:**
```
Input: a = "dabadd", b = "cda"
Output: 3
```

---

## Constraints

- `1 <= a.length, b.length <= 10^5`
- `a` and `b` consist only of lowercase English letters.
