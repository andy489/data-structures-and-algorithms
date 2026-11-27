# 424. Longest Repeating Character Replacement

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/longest-repeating-character-replacement/

---

## Problem Statement

You are given a string `s` and an integer `k`. You can choose any character of the string and change it to any other uppercase English character. You can perform this operation at most `k` times.

Return the length of the longest substring containing the same letter you can get after performing the above operations.

---

## Examples

**Example 1:**
```
Input:  s = "ABAB", k = 2
Output: 4
```

**Example 2:**
```
Input:  s = "AABABBA", k = 1
Output: 4
```

---

## Constraints

- `1 <= s.length <= 10^5`
- `s` consists of only uppercase English letters
- `0 <= k <= s.length`
