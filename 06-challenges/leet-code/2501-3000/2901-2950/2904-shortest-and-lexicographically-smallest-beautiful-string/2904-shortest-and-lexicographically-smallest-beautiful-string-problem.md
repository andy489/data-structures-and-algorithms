# 2904. Shortest and Lexicographically Smallest Beautiful String

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/shortest-and-lexicographically-smallest-beautiful-string/

---

## Problem Statement

You are given a binary string `s` and a positive integer `k`.

A substring of `s` is **beautiful** if the number of `1`'s in it is exactly `k`.

Let `len` be the length of the **shortest** beautiful substring.

Return the lexicographically **smallest** beautiful substring of string `s` with length equal to `len`. If `s` doesn't contain a beautiful substring, return an **empty** string.

---

## Examples

**Example 1:**
```
Input: s = "100011001", k = 3
Output: "11001"
```

**Example 2:**
```
Input: s = "1011", k = 2
Output: "11"
```

**Example 3:**
```
Input: s = "000", k = 1
Output: ""
```

---

## Constraints

- `1 <= s.length <= 100`
- `1 <= k <= s.length`
