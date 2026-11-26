# 394. Decode String

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/decode-string/

---

## Problem Statement

Given an encoded string, return its decoded string.

The encoding rule is: `k[encoded_string]`, where the `encoded_string` inside the square brackets is being repeated exactly `k` times. Note that `k` is guaranteed to be a positive integer.

You may assume that the input string is always valid; there are no extra white spaces, square brackets are well-formed, etc. Furthermore, you may assume that the original data does not contain any digits and that all the digits in the input string are for the `k` value.

---

## Examples

**Example 1:**
```
Input:  s = "3[a]2[bc]"
Output: "aaabcbc"
```

**Example 2:**
```
Input:  s = "3[a2[c]]"
Output: "accaccacc"
```

**Example 3:**
```
Input:  s = "2[abc]3[cd]ef"
Output: "abcabccdcdcdef"
```

---

## Constraints

- `1 <= s.length <= 30`
- `s` consists of lowercase English letters, digits, and square brackets `'[]'`.
- `s` is guaranteed to be a valid input.
- All the integers in `s` are in the range `[1, 300]`.
