# 1750. Minimum Length of String After Deleting Similar Ends

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/minimum-length-of-string-after-deleting-similar-ends/

---

## Problem Statement

Given a string `s` consisting only of characters `'a'`, `'b'`, and `'c'`. You are asked to apply the following algorithm on the string any number of times:

1. Pick a **non-empty** prefix from the string `s` where all the characters in the prefix are equal.
2. Pick a **non-empty** suffix from the string `s` where all the characters in the suffix are equal.
3. The prefix and the suffix should not intersect at any index.
4. The characters from the prefix and suffix must be the same.
5. Delete both the prefix and the suffix.

Return the **minimum length** of `s` after performing the above operation any number of times (possibly zero times).

---

## Examples

**Example 1:**
```
Input: s = "ca"
Output: 2
Explanation: You can't remove any characters, so the string stays as is.
```

**Example 2:**
```
Input: s = "cabaabac"
Output: 0
Explanation: Optimal: remove "c"+"c", then "a"+"a", then "b"+"b".
```

**Example 3:**
```
Input: s = "aabccabba"
Output: 3
Explanation: Remove "aa"+"a" to get "bccabb", then "b"+"b" to get "cca". Length = 3.
```

---

## Constraints

- `1 <= s.length <= 10^5`
- `s` only consists of characters `'a'`, `'b'`, and `'c'`.
