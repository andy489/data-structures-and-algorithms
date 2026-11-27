# 926. Flip String to Monotone Increasing

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/flip-string-to-monotone-increasing/

---

## Problem Statement

A binary string is **monotone increasing** if it consists of some number of `0`'s (possibly none), followed by some number of `1`'s (also possibly none).

You are given a binary string `s`. You can flip `s[i]` changing it from `0` to `1` or from `1` to `0`.

Return the **minimum** number of flips to make `s` monotone increasing.

---

## Examples

**Example 1:**
```
Input:  s = "00110"
Output: 1
```

**Example 2:**
```
Input:  s = "010110"
Output: 2
```

---

## Constraints

- `1 <= s.length <= 10^5`
- `s[i]` is either `'0'` or `'1'`.
