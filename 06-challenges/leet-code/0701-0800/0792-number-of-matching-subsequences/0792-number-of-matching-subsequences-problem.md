# 792. Number of Matching Subsequences

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/number-of-matching-subsequences/

---

## Problem Statement

Given a string `s` and an array of strings `words`, return the number of `words[i]` that is a subsequence of `s`.

A **subsequence** of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.

---

## Examples

**Example 1:**
```
Input:  s = "abcde", words = ["a","bb","acd","ace"]
Output: 3
Explanation: "a", "acd", "ace" are subsequences of s.
```

**Example 2:**
```
Input:  s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
Output: 2
```

---

## Constraints

- `1 <= s.length <= 5 * 10^4`
- `1 <= words.length <= 5000`
- `1 <= words[i].length <= 50`
- `s` and `words[i]` consist of only lowercase English letters.
