# 3441. Minimum Cost Good Caption

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/minimum-cost-good-caption/

## Problem

You are given a string `caption` of length `n`. A good caption is a string where every character appears in groups of at least 3 consecutive occurrences.

For example:
- `"aaabbb"` and `"aaaaccc"` are good captions.
- `"aabbb"` and `"ccccd"` are not good captions.

You can perform the following operation any number of times:

Choose an index `i` (where `0 <= i < n`) and change the character at that index to either:
- The character immediately before it in the alphabet (if `caption[i] != 'a'`).
- The character immediately after it in the alphabet (if `caption[i] != 'z'`).

Your task is to convert the given caption into a good caption using the minimum number of operations, and return it. If there are multiple possible good captions, return the lexicographically smallest one among them. If it is impossible to create a good caption, return an empty string `""`.

## Examples

**Example 1:**
```
Input: caption = "cdcd"
Output: "cccc"
```

**Example 2:**
```
Input: caption = "aca"
Output: "aaa"
```

**Example 3:**
```
Input: caption = "bc"
Output: ""
```

## Constraints

- `1 <= caption.length <= 5 * 10^4`
- `caption` consists only of lowercase English letters.
