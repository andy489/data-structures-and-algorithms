# 880. Decoded String at Index

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/decoded-string-at-index/

---

## Problem Statement

You are given an encoded string `s`. To decode the string to a tape, the encoded string is read one character at a time and the following steps are taken:
- If the character read is a letter, that letter is written onto the tape.
- If the character read is a digit `d`, the entire current tape is repeatedly written `d - 1` more times in total.

Given an integer `k`, return the `k`th letter (1-indexed) in the decoded string.

---

## Examples

**Example 1:**
```
Input:  s = "leet2code3", k = 10
Output: "o"
```

**Example 2:**
```
Input:  s = "ha22", k = 5
Output: "h"
```

---

## Constraints

- `2 <= s.length <= 100`
- `s` consists of lowercase English letters and digits `2-9`.
- `1 <= k <= 10^9`
- It is guaranteed that `k <= (decoded string length)`.
