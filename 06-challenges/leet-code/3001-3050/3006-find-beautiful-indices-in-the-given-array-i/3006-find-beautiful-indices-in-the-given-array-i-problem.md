# 3006. Find Beautiful Indices in the Given Array I

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-beautiful-indices-in-the-given-array-i/

---

## Problem Statement

You are given a 0-indexed string `s`, a string `a`, a string `b`, and an integer `k`.

An index `i` is beautiful if:
- `0 <= i <= s.length - a.length`
- `s[i..i+a.length-1] == a`
- There exists an index `j` such that `s[j..j+b.length-1] == b` and `|i - j| <= k`.

Return the array that contains beautiful indices in sorted order.

---

## Examples

**Example 1:**
```
Input:  s = "isawsquirrelnearmysquirrelhouseohmy", a = "my", b = "squirrel", k = 15
Output: [16,33]
```

**Example 2:**
```
Input:  s = "abcd", a = "a", b = "a", k = 4
Output: [0]
```

---

## Constraints

- `1 <= k <= s.length <= 10^5`
- `1 <= a.length, b.length <= 10`
- `s`, `a`, `b` contain only lowercase English letters.
