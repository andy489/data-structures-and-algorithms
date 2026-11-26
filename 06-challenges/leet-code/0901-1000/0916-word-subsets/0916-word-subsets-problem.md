# 916. Word Subsets

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/word-subsets/

---

## Problem Statement

You are given two string arrays `words1` and `words2`.

A string `b` is a **subset** of string `a` if every letter in `b` occurs in `a` including multiplicity.

A string `a` from `words1` is **universal** if for every `b` in `words2`, `b` is a subset of `a`.

Return an array of all the **universal** strings in `words1`. You may return the answer in any order.

---

## Examples

**Example 1:**
```
Input:  words1 = ["amazon","apple","facebook","google","leetcode"], words2 = ["e","o"]
Output: ["facebook","google","leetcode"]
```

---

## Constraints

- `1 <= words1.length, words2.length <= 10^4`
- `1 <= words1[i].length, words2[i].length <= 10`
- `words1[i]` and `words2[i]` consist only of lowercase English letters.
