# 1048. Longest String Chain

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/longest-string-chain/

---

## Problem Statement

You are given an array of `words` where each word consists of lowercase English letters.

`wordA` is a **predecessor** of `wordB` if and only if we can insert **exactly one** letter anywhere in `wordA` **without changing the order** of the other characters to make it equal to `wordB`.

For example, `"abc"` is a predecessor of `"abac"`, while `"cba"` is not a predecessor of `"bcad"`.

A **word chain** is a sequence of words `[word1, word2, ..., wordk]` with `k >= 1` where each word is a predecessor of the next.

Return the length of the **longest possible word chain** with words chosen from the given list of `words`.

---

## Examples

**Example 1:**
```
Input:  words = ["a","b","ba","bca","bda","bdca"]
Output: 4
```

**Example 2:**
```
Input:  words = ["xbc","pcxbcf","xb","cxbc","pcxbc"]
Output: 5
```

---

## Constraints

- `1 <= words.length <= 1000`
- `1 <= words[i].length <= 16`
- `words[i]` only consists of lowercase English letters.
