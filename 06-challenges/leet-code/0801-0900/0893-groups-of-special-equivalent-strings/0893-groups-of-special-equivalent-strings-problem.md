# 893. Groups of Special-Equivalent Strings

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/groups-of-special-equivalent-strings/

---

## Problem Statement

You are given an array of strings of the same length `words`.

In one move, you can swap any two even-indexed characters or any two odd-indexed characters of a string `words[i]`.

Two strings `words[i]` and `words[j]` are special-equivalent if after some number of moves, `words[i] == words[j]`.

Return the number of groups of special-equivalent strings from `words`.

---

## Examples

**Example 1:**
```
Input:  words = ["abcd","cdab","cbad","xyzz","zzxy","zzyx"]
Output: 3
```

**Example 2:**
```
Input:  words = ["abc","acb","bac","bca","cab","cba"]
Output: 3
```

---

## Constraints

- `1 <= words.length <= 1000`
- `1 <= words[i].length <= 20`
- `words[i]` consist of lowercase English letters.
- All the strings are of the same length.
