# 3456. Find Special Substring of Length K

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-special-substring-of-length-k/

---

## Problem Statement

You are given a string `s` and an integer `k`.

Determine if there exists a substring of length **exactly** `k` in `s` that satisfies the following conditions:

1. The substring consists of **only one distinct character** (e.g., `"aaa"` or `"bbb"`).
2. If there is a character **immediately before** the substring, it must be different from the character in the substring.
3. If there is a character **immediately after** the substring, it must also be different from the character in the substring.

Return `true` if such a substring exists. Otherwise, return `false`.

---

## Examples

**Example 1:**
```
Input: s = "aaabaaa", k = 3
Output: true
```

**Example 2:**
```
Input: s = "abc", k = 2
Output: false
```

---

## Constraints

- `1 <= k <= s.length <= 100`
- `s` consists of lowercase English letters only.
