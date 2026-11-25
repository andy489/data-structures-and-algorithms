# 828. Count Unique Characters of All Substrings of a Given String

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-unique-characters-of-all-substrings-of-a-given-string/

---

## Problem Statement

Let's define a function `countUniqueChars(s)` that returns the number of unique characters in `s`. Given a string `s`, return the sum of `countUniqueChars(t)` where `t` is a substring of `s`.

The test cases are generated such that the answer fits in a 32-bit integer.

---

## Examples

**Example 1:**
```
Input:  s = "ABC"
Output: 10
Explanation: All substrings: "A","B","C","AB","BC","ABC". Count = 1+1+1+2+2+3 = 10.
```

**Example 2:**
```
Input:  s = "ABA"
Output: 8
```

---

## Constraints

- `1 <= s.length <= 10^5`
- `s` consists of uppercase English letters only.
