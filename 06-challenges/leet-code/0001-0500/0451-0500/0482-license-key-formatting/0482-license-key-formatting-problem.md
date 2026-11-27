# 482. License Key Formatting

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/license-key-formatting/

---

## Problem Statement

You are given a license key represented as a string `s` that consists of only alphanumeric characters and dashes. The string is separated into `n + 1` groups by `n` dashes. You are also given an integer `k`.

We want to reformat the string `s` such that each group contains exactly `k` characters, except for the first group, which could be shorter than `k` but still must contain at least one character. Furthermore, there must be a dash inserted between two groups, and you should convert all lowercase letters to uppercase.

Return the reformatted license key.

---

## Examples

**Example 1:**
```
Input:  s = "5F3Z-2e-9-w", k = 4
Output: "5F3Z-2E9W"
```

**Example 2:**
```
Input:  s = "2-5g-3-J", k = 2
Output: "2-5G-3J"
```

---

## Constraints

- `1 <= s.length <= 10^5`
- `s` consists of English letters, digits, and dashes `'-'`.
- `1 <= k <= 10^4`
