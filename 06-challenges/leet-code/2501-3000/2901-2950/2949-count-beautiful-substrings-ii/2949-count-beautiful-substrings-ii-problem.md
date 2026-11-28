# 2949. Count Beautiful Substrings II

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/count-beautiful-substrings-ii/

---

## Problem Statement

You are given a string `s` and a positive integer `k`.

Let `vowels` and `consonants` be the number of vowels and consonants in a string.

A string is **beautiful** if:

- `vowels == consonants`.
- `(vowels * consonants) % k == 0`, in other terms the multiplication of `vowels` and `consonants` is divisible by `k`.

Return *the number of **non-empty beautiful substrings** in the given string* `s`.

A **substring** is a contiguous sequence of characters in a string.

**Vowel letters** in English are `'a'`, `'e'`, `'i'`, `'o'`, and `'u'`.

---

## Examples

**Example 1:**
```
Input: s = "baeyh", k = 2
Output: 2
```

**Example 2:**
```
Input: s = "abba", k = 1
Output: 3
```

**Example 3:**
```
Input: s = "bcdf", k = 1
Output: 0
```

---

## Constraints

- `1 <= s.length <= 5 * 10^4`
- `1 <= k <= 1000`
- `s` consists of only English lowercase letters.
