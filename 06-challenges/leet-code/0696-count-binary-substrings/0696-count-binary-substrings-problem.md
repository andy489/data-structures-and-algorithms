# 696. Count Binary Substrings

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/count-binary-substrings/

---

## Problem Statement

Given a binary string `s`, return the number of non-empty substrings that have the same number of `0`'s and `1`'s, and all the `0`'s and all the `1`'s in these substrings are **grouped consecutively**.

Substrings that occur multiple times are counted the number of times they occur.

---

## Examples

**Example 1:**
```
Input:  s = "00110011"
Output: 6
Explanation: There are 6 substrings: "0011", "01", "1100", "10", "0011", "01".
```

**Example 2:**
```
Input:  s = "10101"
Output: 4
Explanation: There are 4 substrings: "10", "01", "10", "01".
```

---

## Constraints

- `1 <= s.length <= 10⁵`
- `s[i]` is either `'0'` or `'1'`.
