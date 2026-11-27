# 3365. Rearrange K Substrings to Form Target String

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/rearrange-k-substrings-to-form-target-string/

---

## Problem Statement

You are given two strings `s` and `t`, both of which are anagrams of each other, and an integer `k`.

Your task is to determine whether it is possible to split the string `s` into `k` equal-sized substrings, rearrange the substrings, and concatenate them in *any order* to create a new string that matches the given string `t`.

Return `true` if this is possible, otherwise, return `false`.

An **anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, using all the original letters exactly once.

A **substring** is a contiguous **non-empty** sequence of characters within a string.

---

## Examples

**Example 1:**
```
Input:  s = "abcd", t = "cdab", k = 2
Output: true
```
Split s into 2 substrings of length 2: ["ab", "cd"]. Rearranging as ["cd", "ab"] gives "cdab" = t.

**Example 2:**
```
Input:  s = "aabbcc", t = "bbaacc", k = 3
Output: true
```
Split s into 3 substrings of length 2: ["aa", "bb", "cc"]. Rearranging as ["bb", "aa", "cc"] gives "bbaacc" = t.

**Example 3:**
```
Input:  s = "aabbcc", t = "bbaacc", k = 2
Output: false
```
Split s into 2 substrings of length 3: ["aab", "bcc"]. These cannot be rearranged to form t = "bbaacc".

---

## Constraints

- `1 <= s.length == t.length <= 2 * 10^5`
- `1 <= k <= s.length`
- `s.length` is divisible by `k`
- `s` and `t` consist only of lowercase English letters
- `s` and `t` are anagrams of each other
