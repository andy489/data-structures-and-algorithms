# 3042. Count Prefix and Suffix Pairs I

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/count-prefix-and-suffix-pairs-i/

---

## Problem Statement

You are given a 0-indexed string array `words`.

Define a boolean function `isPrefixAndSuffix(str1, str2)` that returns `true` if `str1` is both a prefix and a suffix of `str2`, and `false` otherwise.

Return an integer denoting the number of index pairs `(i, j)` such that `i < j` and `isPrefixAndSuffix(words[i], words[j])` is `true`.

---

## Examples

**Example 1:**
```
Input:  words = ["a","aba","ababa","aa"]
Output: 4
```

**Example 2:**
```
Input:  words = ["pa","papa","ma","mama"]
Output: 2
```

---

## Constraints

- `1 <= words.length <= 50`
- `1 <= words[i].length <= 10`
- `words[i]` consists only of lowercase English letters.
