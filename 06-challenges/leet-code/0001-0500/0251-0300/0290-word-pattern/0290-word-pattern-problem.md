# 290. Word Pattern

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/word-pattern/

---

## Problem Statement

Given a `pattern` and a string `s`, find if `s` follows the same pattern.

Here **follow** means a full match, such that there is a bijection between a letter in `pattern` and a **non-empty** word in `s`. Specifically:
- Every occurrence of a letter maps to the same word.
- Every occurrence of a word maps to the same letter.
- No two letters map to the same word, and no two words map to the same letter.

---

## Examples

**Example 1:**
```
Input:  pattern = "abba", s = "dog cat cat dog"
Output: true
```

**Example 2:**
```
Input:  pattern = "abba", s = "dog cat cat fish"
Output: false
```

**Example 3:**
```
Input:  pattern = "aaaa", s = "dog cat cat dog"
Output: false
```

---

## Constraints

- `1 <= pattern.length <= 300`
- `pattern` contains only lower-case English letters.
- `1 <= s.length <= 3000`
- `s` contains only lowercase English letters and spaces `' '`.
- `s` **does not contain** any leading or trailing spaces.
- All the words in `s` are separated by a **single space**.
