# 1961. Check If String Is a Prefix of Array

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/check-if-string-is-a-prefix-of-array/

## Description

Given a string s and an array of strings words, determine whether s is a prefix string of words.

A string s is a prefix string of words if s can be made by concatenating the first k strings in words for some positive k no larger than words.length.

Return true if s is a prefix string of words, or false otherwise.

## Examples

**Example 1:**
```
Input: s = "iloveleetcode", words = ["i","love","leetcode","apples"]
Output: true
Explanation: s can be made by concatenating "i", "love", and "leetcode" together.
```

**Example 2:**
```
Input: s = "iloveleetcode", words = ["apples","i","love","leetcode"]
Output: false
```

## Constraints

- 1 <= words.length <= 100
- 1 <= words[i].length <= 20
- 1 <= s.length <= 1000
- words[i] and s consist of only lowercase English letters.
