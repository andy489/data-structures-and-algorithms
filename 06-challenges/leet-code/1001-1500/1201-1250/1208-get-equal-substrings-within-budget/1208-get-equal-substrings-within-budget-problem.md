# 1208. Get Equal Substrings Within Budget

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/get-equal-substrings-within-budget/

---

## Problem Statement

You are given two strings `s` and `t` of the same length and an integer `maxCost`.

You want to change `s` to `t`. Changing the `i`-th character of `s` to the `i`-th character of `t` costs `|s[i] - t[i]|`.

Return the maximum length of a substring of `s` that can be changed to be the same as the corresponding substring of `t` with a cost less than or equal to `maxCost`. If there is no substring from `s` that can be changed to its corresponding substring from `t`, return 0.

---

## Examples

**Example 1:**
```
Input:  s = "abcd", t = "bcdf", maxCost = 3
Output: 3
```

---

## Constraints

- `1 <= s.length <= 10^5`
- `t.length == s.length`
- `0 <= maxCost <= 10^6`
- `s and t consist of only lowercase English letters`
