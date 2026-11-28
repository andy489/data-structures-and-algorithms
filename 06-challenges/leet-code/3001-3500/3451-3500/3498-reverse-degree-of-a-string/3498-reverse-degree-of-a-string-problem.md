# 3498. Reverse Degree of a String

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/reverse-degree-of-a-string/

---

## Problem Statement

Given a string `s`, calculate its **reverse degree**.

The **reverse degree** is calculated as follows:

1. For each character, multiply its position in the *reversed* alphabet (`'a'` = 26, `'b'` = 25, ..., `'z'` = 1) with its position in the string **(1-indexed)**.
2. Sum these products for all characters in the string.

Return the **reverse degree** of `s`.

---

## Examples

**Example 1:**
```
Input: s = "abc"
Output: 148
```

**Example 2:**
```
Input: s = "zaza"
Output: 160
```

---

## Constraints

- `1 <= s.length <= 1000`
- `s` contains only lowercase English letters.
