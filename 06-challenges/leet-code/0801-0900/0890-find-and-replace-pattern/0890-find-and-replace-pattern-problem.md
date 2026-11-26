# 890. Find and Replace Pattern

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-and-replace-pattern/

---

## Problem Statement

Given a list of strings `words` and a string `pattern`, return a list of `words[i]` that match `pattern`. You may return the answer in any order.

A word matches the pattern if there exists a permutation of letters `p` so that after replacing every letter `x` in the pattern with `p(x)`, we get the desired word.

Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.

---

## Examples

**Example 1:**
```
Input:  words = ["aa","bb","bc","ac","ca","ba"], pattern = "ab"
Output: ["bc","ac","ca","ba"]
```

---

## Constraints

- `1 <= pattern.length <= 20`
- `1 <= words.length <= 50`
- `words[i].length == pattern.length`
- `pattern` and `words[i]` are lowercase English letters.
