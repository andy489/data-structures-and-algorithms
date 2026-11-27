# 1585. Check If String Is Transformable With Substring Sort Operations

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/check-if-string-is-transformable-with-substring-sort-operations/

---

## Problem Statement

Given two strings `s` and `t`, you want to transform string `s` into string `t` using the following operation any number of times: choose a non-empty substring of `s` and sort it in place so the characters are in ascending order.

For example, applying the operation on the underlined substring in `"14234"` results in `"12344"`.

Return `true` if it is possible to transform `s` into `t`. Otherwise, return `false`.

A **substring** is a contiguous sequence of characters within a string.

---

## Examples

**Example 1:**
```
Input:  s = "84532", t = "34852"
Output: true
```

**Example 2:**
```
Input:  s = "34521", t = "23415"
Output: true
```

**Example 3:**
```
Input:  s = "12345", t = "12435"
Output: false
```

---

## Constraints

- `s.length == t.length`
- `1 <= s.length <= 10^5`
- `s` and `t` only contain digits from `'0'` to `'9'`
