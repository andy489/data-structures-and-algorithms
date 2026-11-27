# 2068. Check Whether Two Strings Are Almost Equivalent

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/check-whether-two-strings-are-almost-equivalent/

---

## Problem Statement

Two strings `word1` and `word2` are **almost equivalent** if the differences between the frequencies of each letter from `'a'` to `'z'` between `word1` and `word2` is at most `3`. Return `true` if `word1` and `word2` are **almost equivalent**, or `false` otherwise.

---

## Examples

**Example 1:**
```
Input:  word1 = "aaaa", word2 = "bccb"
Output: false
```
Explanation: |freq('a')| = 4 > 3.

**Example 2:**
```
Input:  word1 = "abcdeef", word2 = "abaaacc"
Output: true
```
Explanation: All differences ≤ 3.

**Example 3:**
```
Input:  word1 = "cccddabba", word2 = "babababab"
Output: true
```

---

## Constraints

- `n == word1.length == word2.length`
- `1 <= n <= 100`
- `word1 and word2 consist only of lowercase English letters.`
