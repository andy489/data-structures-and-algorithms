# 3305. Count of Substrings Containing Every Vowel and K Consonants I

**Difficulty:** Medium  
**Link:** https://leetcode.com/problems/count-of-substrings-containing-every-vowel-and-k-consonants-i/

## Problem

You are given a string `word` and a **non-negative** integer `k`.

Return the total number of substrings of `word` that contain every vowel (`'a'`, `'e'`, `'i'`, `'o'`, and `'u'`) **at least** once and **exactly** `k` consonants.

## Examples

**Example 1:**
```
Input: word = "aeioqq", k = 1
Output: 0
Explanation: There is no substring with every vowel.
```

**Example 2:**
```
Input: word = "aeiou", k = 0
Output: 1
Explanation: The only substring with every vowel and zero consonants is word[0..4].
```

**Example 3:**
```
Input: word = "ieaouqqieaouqq", k = 1
Output: 3
Explanation:
- word[0..5] = "ieaouq"
- word[6..11] = "qieaou"
- word[7..12] = "ieaouq"
```

## Constraints

- `5 <= word.length <= 250`
- `word` consists only of lowercase English letters.
- `0 <= k <= word.length - 5`
