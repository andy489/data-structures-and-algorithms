# 1839. Longest Substring of All Vowels in Order

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/longest-substring-of-all-vowels-in-order/

---

## Problem Statement

A string is considered **beautiful** if it satisfies both of the following conditions:

- Each of the 5 English vowels (`'a'`, `'e'`, `'i'`, `'o'`, `'u'`) must appear **at least once** in it.
- The letters must be sorted in **alphabetical order** (i.e., all `'a'`s before `'e'`s, all `'e'`s before `'i'`s, etc.).

For example, strings `"aeiou"` and `"aaaaaaeiiiioou"` are considered **beautiful**, but `"uaeio"`, `"aeoiu"`, and `"aaaeeeooo"` are **not beautiful**.

Given a string `word` consisting of English vowels, return *the* **length of the longest beautiful substring** *of* `word`. If no such substring exists, return `0`.

A **substring** is a contiguous sequence of characters in a string.

---

## Examples

**Example 1:**
```
Input: word = "aeiaaioaaaaeiiiiouuuooaauuaeiu"
Output: 13
Explanation: The longest beautiful substring is "aaaaeiiiiouuu" of length 13.
```

**Example 2:**
```
Input: word = "aeeeiiiioooauuuaeiou"
Output: 5
Explanation: The longest beautiful substring is "aeiou" of length 5.
```

**Example 3:**
```
Input: word = "a"
Output: 0
```

---

## Constraints

- `1 <= word.length <= 5 * 10^5`
- `word` consists of characters `'a'`, `'e'`, `'i'`, `'o'`, and `'u'`.
