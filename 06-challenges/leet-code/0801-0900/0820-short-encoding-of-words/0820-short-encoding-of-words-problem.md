# 820. Short Encoding of Words

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/short-encoding-of-words/

---

## Problem Statement

A valid encoding of an array of `words` is any reference string `s` and array of indices `indices` such that `words[i]` is a suffix of `s` starting at `indices[i]`, and each word ends with `'#'` in `s`.

Return the length of the shortest reference string `s`.

---

## Examples

**Example 1:**
```
Input:  words = ["time","me","bell"]
Output: 10
Explanation: "time#bell#" encodes all words (me is a suffix of time).
```

**Example 2:**
```
Input:  words = ["t"]
Output: 2
```

---

## Constraints

- `1 <= words.length <= 2000`
- `1 <= words[i].length <= 7`
- `words[i]` consists of only lowercase letters.
