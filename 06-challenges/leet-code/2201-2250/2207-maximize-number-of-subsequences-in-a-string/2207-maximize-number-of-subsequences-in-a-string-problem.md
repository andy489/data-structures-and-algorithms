# 2207. Maximize Number of Subsequences in a String

**Difficulty:** Medium

**Link:** https://leetcode.com/problems/maximize-number-of-subsequences-in-a-string/

## Problem

You are given a 0-indexed string text and another 0-indexed string pattern of length 2, both of which consist of only lowercase English letters.

You can add either pattern[0] or pattern[1] anywhere in text exactly once. Note that the character can be added even at the beginning or at the end of text.

Return the maximum number of times pattern can occur as a subsequence of the modified text.

A subsequence is a string that can be derived from another string by deleting some or no characters without changing the order of the remaining characters.

## Examples

**Example 1:**
```
Input: text = "abdcdbc", pattern = "ac"
Output: 4
Explanation: If we add pattern[0] = 'a' in between text[1] and text[2], we get "abadcdbc". 
Now, the number of times "ac" occurs as a subsequence is 4.
```

**Example 2:**
```
Input: text = "aabb", pattern = "ab"
Output: 6
```

## Constraints

- 1 <= text.length <= 10⁵
- pattern.length == 2
- text and pattern consist only of lowercase English letters.
