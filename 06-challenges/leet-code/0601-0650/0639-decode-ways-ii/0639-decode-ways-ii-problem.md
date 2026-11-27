# 639. Decode Ways II

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/decode-ways-ii/

---

## Problem Statement

A message containing letters from `A-Z` can be **encoded** into numbers using the following mapping:

```
'A' -> "1"
'B' -> "2"
...
'Z' -> "26"
```

To **decode** an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above. Additionally, the encoded string may contain the character `'*'` which can represent any digit from `'1'` to `'9'` (inclusive).

Given a string `s` consisting of digits and `'*'` characters, return the **number of ways** to decode it. Since the answer may be very large, return it **modulo** `10^9 + 7`.

---

## Examples

**Example 1:**
```
Input:  s = "*"
Output: 9
```

**Example 2:**
```
Input:  s = "1*"
Output: 18
```

**Example 3:**
```
Input:  s = "2*"
Output: 15
```

---

## Constraints

- `1 <= s.length <= 10^5`
- `s[i]` is a digit or `'*'`
