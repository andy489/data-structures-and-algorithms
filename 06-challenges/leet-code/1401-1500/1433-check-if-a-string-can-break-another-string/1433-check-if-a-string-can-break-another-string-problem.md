# 1433. Check If A String Can Break Another String

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/check-if-a-string-can-break-another-string/

---

## Problem Statement

String `s1` can break `s2` if every character of sorted `s1` >= corresponding character of sorted `s2`. Return if either can break the other.

---

## Examples

**Example 1:**
```
Input:  s1="abc",s2="xya"
Output: true
```

**Example 2:**
```
Input:  s1="abe",s2="acd"
Output: false
```

**Example 3:**
```
Input:  s1="leetcodee",s2="interview"
Output: true
```

---

## Constraints

- `s1.length == s2.length == n`
- `1 <= n <= 10^5`
- `All characters lowercase`
