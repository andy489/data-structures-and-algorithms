# 1754. Largest Merge of Two Strings

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/largest-merge-of-two-strings/

---

## Problem Statement

You are given two strings `word1` and `word2`. You want to construct a string `merge` in the following way: while either `word1` or `word2` are non-empty, choose **one** of the following options:

- If `word1` is non-empty, append the **first** character in `word1` to `merge` and delete it from `word1`.
  - For example, if `word1 = "abc"` and `merge = "z"`, then after choosing this operation, `word1 = "bc"` and `merge = "zabc"`.
- If `word2` is non-empty, append the **first** character in `word2` to `merge` and delete it from `word2`.

Return the **lexicographically largest** `merge` you can construct.

---

## Examples

**Example 1:**
```
Input: word1 = "cabaa", word2 = "bcaaa"
Output: "cbcabaaaaa"
```

**Example 2:**
```
Input: word1 = "abcabc", word2 = "abdcaba"
Output: "abdcabcabcaba"
```

---

## Constraints

- `1 <= word1.length, word2.length <= 3000`
- `word1` and `word2` consist only of lowercase English letters.
