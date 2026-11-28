# 3463. Check If Digits Are Equal in String After Operations II

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/check-if-digits-are-equal-in-string-after-operations-ii/

---

## Problem Statement

You are given a string `s` consisting of digits. Perform the following operation repeatedly until the string has **exactly** two digits:

- For each pair of consecutive digits in `s`, starting from the first digit, calculate a new digit as the sum of the two digits **modulo** 10.
- Replace `s` with the sequence of newly calculated digits, maintaining the order in which they are computed.

Return `true` if the final two digits in `s` are the **same**; otherwise, return `false`.

---

## Examples

**Example 1:**
```
Input: s = "3902"
Output: true
```

**Example 2:**
```
Input: s = "34789"
Output: false
```

---

## Constraints

- `3 <= s.length <= 10^5`
- `s` consists of only digits.
