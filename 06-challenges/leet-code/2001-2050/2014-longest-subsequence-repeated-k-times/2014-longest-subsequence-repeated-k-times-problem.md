# 2014. Longest Subsequence Repeated k Times

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/longest-subsequence-repeated-k-times/

---

## Problem Statement

You are given a string `s` of length `n`, and an integer `k`. Find the **longest subsequence** of `s` such that the subsequence repeated `k` times is itself a subsequence of `s`. Return the longest such subsequence, or empty string if none.

---

## Examples

**Example 1:**
```
Input:  s = "letsleetcode", k = 2
Output: "let"
```

**Example 2:**
```
Input:  s = "bb", k = 2
Output: "b"
```

**Example 3:**
```
Input:  s = "ab", k = 2
Output: ""
```

---

## Constraints

- `n == s.length`
- `2 <= n, k <= 2000`
- `s consists of lowercase English letters.`
