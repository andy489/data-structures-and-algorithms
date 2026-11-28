# 3458. Select K Disjoint Special Substrings

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/select-k-disjoint-special-substrings/

---

## Problem Statement

Given a string `s` of length `n` and an integer `k`, determine whether it is possible to select `k` disjoint **special substrings**.

A **special substring** is a substring where:

- Any character present inside the substring should not appear outside it in the string.
- The substring is not the entire string `s`.

**Note** that all `k` substrings must be disjoint, meaning they cannot overlap.

Return `true` if it is possible to select `k` such disjoint special substrings; otherwise, return `false`.

---

## Examples

**Example 1:**
```
Input: s = "abcdbaefab", k = 2
Output: true
```

**Example 2:**
```
Input: s = "cdefdc", k = 3
Output: false
```

**Example 3:**
```
Input: s = "abeabe", k = 0
Output: true
```

---

## Constraints

- `2 <= n == s.length <= 5 * 10^4`
- `0 <= k <= 26`
- `s` consists only of lowercase English letters.
