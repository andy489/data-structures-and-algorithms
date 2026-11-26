# 943. Find the Shortest Superstring

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/find-the-shortest-superstring/

---

## Problem Statement

Given an array of strings `words`, return the smallest string that contains each string in `words` as a substring. If there are multiple valid strings of the same minimum length, return **any of them**.

You may assume that no string in `words` is a substring of another string in `words`.

---

## Examples

**Example 1:**
```
Input:  words = ["alex","loves","leetcode"]
Output: "alexlovesleetcode"
```

**Example 2:**
```
Input:  words = ["catg","ctaagt","gcta","ttca","atgcatc"]
Output: "gctaagttcatgcatc"
```

---

## Constraints

- `1 <= words.length <= 12`
- `1 <= words[i].length <= 20`
- All the strings of `words` are **unique**.
