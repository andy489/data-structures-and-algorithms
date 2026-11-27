# 1967. Number of Strings That Appear as Substrings in Word

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/

## Description

Given an array of strings patterns and a string word, return the number of strings in patterns that exist as a substring in word.

A substring is a contiguous sequence of characters within a string.

## Examples

**Example 1:**
```
Input: patterns = ["a","abc","bc","d"], word = "abc"
Output: 3
Explanation:
- "a" appears as a substring in "abc".
- "abc" appears as a substring in "abc".
- "bc" appears as a substring in "abc".
- "d" does not appear as a substring in "abc".
```

**Example 2:**
```
Input: patterns = ["a","b","c"], word = "aaaaabbbbb"
Output: 2
```

**Example 3:**
```
Input: patterns = ["a","a","a"], word = "ab"
Output: 3
```

## Constraints

- 1 <= patterns.length <= 100
- 1 <= patterns[i].length <= 100
- 1 <= word.length <= 100
- patterns[i] and word consist of lowercase English letters.
