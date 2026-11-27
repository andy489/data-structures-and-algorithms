# 2213. Longest Substring of One Repeating Character

**Difficulty:** Hard

**Link:** https://leetcode.com/problems/longest-substring-of-one-repeating-character/

## Problem

You are given a 0-indexed string s. You are also given a 0-indexed string queryCharacters of length k and a 0-indexed array of integer indices queryIndices of length k, both of which are used to describe k queries.

The ith query updates the character in s at index queryIndices[i] to the character queryCharacters[i].

Return an array lengths of length k where lengths[i] is the length of the longest substring of s consisting of only one repeating character after the ith query is performed.

## Examples

**Example 1:**
```
Input: s = "babacc", queryCharacters = "bcb", queryIndices = [1,3,3]
Output: [3,3,4]
Explanation:
- After query 1: s = "bbbacc". Longest = "bbb" (3).
- After query 2: s = "bbbccc". Longest = "bbb" or "ccc" (3).
- After query 3: s = "bbbbcc". Longest = "bbbb" (4).
```

**Example 2:**
```
Input: s = "abyzz", queryCharacters = "aa", queryIndices = [2,1]
Output: [2,3]
```

## Constraints

- 1 <= s.length <= 10⁵
- s consists of lowercase English letters.
- k == queryCharacters.length == queryIndices.length
- 1 <= k <= 10⁵
- queryCharacters consists of lowercase English letters.
- 0 <= queryIndices[i] < s.length
