# 1704. Determine if String Halves Are Alike

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/determine-if-string-halves-are-alike/

---

## Problem Statement

You are given a string `s` of even length. Split this string into two halves of equal lengths, and let `a` be the first half and `b` be the second half.

Two strings are **alike** if they have the same number of vowels (`'a'`, `'e'`, `'i'`, `'o'`, `'u'`, `'A'`, `'E'`, `'I'`, `'O'`, `'U'`). Notice that `s` contains uppercase and lowercase letters.

Return `true` if `a` and `b` are **alike**. Otherwise, return `false`.

---

## Examples

**Example 1:**
```
Input: s = "book"
Output: true
Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel.
```

**Example 2:**
```
Input: s = "textbook"
Output: false
Explanation: a = "text" and b = "book". a has 1 vowel whereas b has 2.
```

---

## Constraints

- `2 <= s.length <= 1000`
- `s.length` is even.
- `s` consists of **uppercase and lowercase** letters.
