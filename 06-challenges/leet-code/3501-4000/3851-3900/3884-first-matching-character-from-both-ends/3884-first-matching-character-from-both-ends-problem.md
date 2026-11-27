# 3884. First Matching Character From Both Ends

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/first-matching-character-from-both-ends/

## Problem

You are given a string `s` of length `n` consisting of lowercase English letters.

Return the smallest index `i` such that `s[i] == s[n - i - 1]`.

If no such index exists, return -1.

## Examples

**Example 1:**
```
Input: s = "abcacbd"
Output: 1
Explanation: At index i=1, s[1] and s[5] are both 'b'. No smaller index satisfies the condition.
```

**Example 2:**
```
Input: s = "abc"
Output: 1
Explanation: At index i=1, the two compared positions coincide, so both characters are 'b'.
```

**Example 3:**
```
Input: s = "abcdab"
Output: -1
Explanation: For every index i, the characters at positions i and n-i-1 are different.
```

## Constraints

- `1 <= n == s.length <= 100`
- `s` consists of lowercase English letters.
