# 1160. Find Words That Can Be Formed by Characters

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/find-words-that-can-be-formed-by-characters/

---

## Problem Statement

You are given an array of strings `words` and a string `chars`.

A string is **good** if it can be formed by characters from `chars` (each character can only be used once). Return the sum of lengths of all **good** strings in `words`.

---

## Examples

**Example 1:**
```
Input:  words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: "cat" and "hat" can be formed — lengths 3 + 3 = 6.
```

**Example 2:**
```
Input:  words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation: "hello" and "world" can be formed — lengths 5 + 5 = 10.
```

---

## Constraints

- `1 <= words.length <= 1000`
- `1 <= words[i].length, chars.length <= 100`
- `words[i]` and `chars` consist of lowercase English letters
