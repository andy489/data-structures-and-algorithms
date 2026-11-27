# 3083. Existence Of A Substring In A String And Its Reverse

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/existence-of-a-substring-in-a-string-and-its-reverse/

---

## Problem Statement

Given a string `s`, find any substring of length 2 of `s` that also appears as a substring of the reverse of `s`.

Return `true` if such a substring exists, and `false` otherwise.

---

## Examples

**Example 1:**
```
Input:  s = "leetcode"
Output: true
```
Explanation: "le" reversed is "el" which is in "leetcode".

**Example 2:**
```
Input:  s = "abcba"
Output: true
```
Explanation: "ab" reversed is "ba" which is in "abcba".

---

## Constraints

- `1 <= s.length <= 100`
- `s consists only of lowercase English letters.`
