# 3039. Apply Operations to Make String Empty

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/apply-operations-to-make-string-empty/

---

## Problem Statement

You are given a string `s`. Repeatedly apply the following operations until `s` is empty:

1. Find the first occurrence of each letter from 'a' to 'z' in `s`. Remove each of these occurrences (in one round).

Return the last non-empty string obtained before it becomes empty.

---

## Examples

**Example 1:**
```
Input:  s = "aabcbbca"
Output: "ba"
```

**Example 2:**
```
Input:  s = "abcd"
Output: "abcd"
```

---

## Constraints

- `1 <= s.length <= 2 * 10^5`
- `s` consists only of lowercase English letters.
