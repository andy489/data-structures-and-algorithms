# 831. Masking Personal Information

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/masking-personal-information/

---

## Problem Statement

You are given a personal information string `s`, which represents either an email address or a phone number. Return the masked personal information.

- **Email**: Keep first character, replace next characters with `*****`, then keep the rest `@domain`. Format: `l*****e@domain`.
- **Phone**: Keep only digits. Mask all but last 4 digits with `***-***-`. If there are country code digits, prepend `+*-` or `+**-` or `+***-` based on length.

---

## Examples

**Example 1:**
```
Input:  s = "LeetCode@LeetCode.com"
Output: "l*****e@leetcode.com"
```

**Example 2:**
```
Input:  s = "86-(10)12345678"
Output: "+**-***-***-5678"
```

---

## Constraints

- `s` is either a valid email or a phone number.
- `1 <= s.length <= 40`
