# 984. String Without AAA or BBB

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/string-without-aaa-or-bbb/

---

## Problem Statement

Given two integers `a` and `b`, return any string `s` such that:

- `s` has length `a + b` and contains exactly `a` `'a'` letters, and exactly `b` `'b'` letters,
- The substring `'aaa'` does not occur in `s`, and
- The substring `'bbb'` does not occur in `s`.

---

## Examples

**Example 1:**
```
Input:  a = 1, b = 2
Output: "abb"
```

**Example 2:**
```
Input:  a = 4, b = 1
Output: "aabaa"
```

---

## Constraints

- `0 <= a, b <= 100`
- It is guaranteed such an `s` exists for the given `a` and `b`.
