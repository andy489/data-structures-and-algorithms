# 809. Expressive Words

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/expressive-words/

---

## Problem Statement

Sometimes people repeat letters to make a word more "expressive". A word is "stretchy" from another word if it can be made by repeating some groups of letters at least 3 times, or keeping them the same.

Given a string `s` and an array `words`, return the number of words in `words` that are stretchy from `s`.

---

## Examples

**Example 1:**
```
Input:  s = "heeelloworld", words = ["hello","di","world","helo"]
Output: 1 (only "hello" is stretchy)
```

---

## Constraints

- `1 <= s.length, words[i].length <= 100`
- `s` and `words[i]` consist of lowercase English letters.
