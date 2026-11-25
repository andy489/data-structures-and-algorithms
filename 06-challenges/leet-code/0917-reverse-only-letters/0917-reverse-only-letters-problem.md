# 917. Reverse Only Letters

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/reverse-only-letters/

---

## Problem Statement

Given a string `s`, reverse the string according to the following rules:
- All the characters that are not English letters remain in the same position.
- All the English letters (lowercase or uppercase) should be reversed.

Return `s` after reversing it.

---

## Examples

**Example 1:**
```
Input:  s = "ab-cd"
Output: "dc-ba"
```

**Example 2:**
```
Input:  s = "a-bC-dEf-ghIj"
Output: "j-Ih-gfE-dCba"
```

---

## Constraints

- `1 <= s.length <= 100`
- `s` consists of characters with ASCII values in the range `[33, 122]`.
- `s` does not contain `'\"'` or `'\\'`.
