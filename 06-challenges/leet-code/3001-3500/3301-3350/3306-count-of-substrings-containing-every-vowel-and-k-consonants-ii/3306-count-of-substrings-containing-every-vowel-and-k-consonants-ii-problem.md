# 3306. Count of Substrings Containing Every Vowel and K Consonants II

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-ii/

## Problem

You are given a string `word` and a **non-negative** integer `k`.

Return the total number of substrings of `word` that contain every vowel (`'a'`, `'e'`, `'i'`, `'o'`, and `'u'`) **at least** once and **exactly** `k` consonants.

## Examples

**Example 1:**
```
Input: word = "aeioqq", k = 1
Output: 0
```

**Example 2:**
```
Input: word = "aeiou", k = 0
Output: 1
```

**Example 3:**
```
Input: word = "ieaouqqieaouqq", k = 1
Output: 3
```

## Constraints

- `5 <= word.length <= 2 * 10^5`
- `word` consists only of lowercase English letters.
- `0 <= k <= word.length - 5`
