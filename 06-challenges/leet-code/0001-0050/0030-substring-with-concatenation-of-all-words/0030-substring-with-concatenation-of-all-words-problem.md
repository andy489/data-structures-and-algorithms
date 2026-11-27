# 30. Substring with Concatenation of All Words

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/substring-with-concatenation-of-all-words/

---

## Problem Statement

You are given a string `s` and an array of strings `words`. All strings in `words` have the **same length**.

A **concatenated string** is a string that exactly contains all the strings of any permutation of `words` concatenated.

- For example, if `words = ["ab","cd","ef"]`, then `"abcdef"`, `"abefcd"`, `"cdabef"`, `"cdefab"`, `"efabcd"`, and `"efcdab"` are all concatenated strings. `"acdbef"` is not a concatenated string because it is not the concatenation of any permutation of `words`.

Return an array of the starting indices of all the concatenated substrings in `s`. You can return the answer in **any order**.

---

## Examples

**Example 1:**
```
Input:  s = "barfoothefoobarman", words = ["foo","bar"]
Output: [0,9]
```
Explanation: The substring starting at 0 is `"barfoo"`, which is a concatenation of `"bar"` and `"foo"`. The substring starting at 9 is `"foobar"`, which is a concatenation of `"foo"` and `"bar"`.

**Example 2:**
```
Input:  s = "wordgoodgoodgoodbestword", words = ["word","good","best","word"]
Output: []
```

**Example 3:**
```
Input:  s = "barfoofoobarthefoobarman", words = ["bar","foo","the"]
Output: [6,9,12]
```

---

## Constraints

- `1 <= s.length <= 10^4`
- `1 <= words.length <= 5000`
- `1 <= words[i].length <= 30`
- `s` and `words[i]` consist of lowercase English letters
