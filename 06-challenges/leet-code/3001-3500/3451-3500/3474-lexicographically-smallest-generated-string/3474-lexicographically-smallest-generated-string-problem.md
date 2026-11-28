# 3474. Lexicographically Smallest Generated String

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/lexicographically-smallest-generated-string/

---

## Problem Statement

You are given two strings, `str1` and `str2`, of lengths `n` and `m`, respectively.

A string `word` of length `n + m - 1` is defined to be **generated** by `str1` and `str2` if it satisfies the following conditions for **each** index `0 <= i <= n - 1`:

- If `str1[i] == 'T'`, the substring of `word` with size `m` starting at index `i` is **equal** to `str2`, i.e., `word[i..(i + m - 1)] == str2`.
- If `str1[i] == 'F'`, the substring of `word` with size `m` starting at index `i` is **not equal** to `str2`, i.e., `word[i..(i + m - 1)] != str2`.

Return the **lexicographically smallest** possible string that can be **generated** by `str1` and `str2`. If no string can be generated, return an empty string `""`.

---

## Examples

**Example 1:**
```
Input: str1 = "TFTF", str2 = "ab"
Output: "ababa"
```

**Example 2:**
```
Input: str1 = "TFTF", str2 = "abc"
Output: ""
```

**Example 3:**
```
Input: str1 = "F", str2 = "d"
Output: "a"
```

---

## Constraints

- `1 <= n == str1.length <= 10^4`
- `1 <= m == str2.length <= 500`
- `str1` consists only of `'T'` or `'F'`.
- `str2` consists only of lowercase English characters.
