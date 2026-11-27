# 3435. Frequencies of Shortest Supersequences

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/frequencies-of-shortest-supersequences/

## Problem

You are given an array of strings `words`. Find all shortest common supersequences (SCS) of `words` that are not permutations of each other.

A shortest common supersequence is a string of minimum length that contains each string in `words` as a subsequence.

Return a 2D array of integers `freqs` that represent all the SCSs. Each `freqs[i]` is an array of size 26, representing the frequency of each letter in the lowercase English alphabet for a single SCS. You may return the frequency arrays in any order.

## Examples

**Example 1:**
```
Input: words = ["ab","ba"]
Output: [[1,2,0,...],[2,1,0,...]]
Explanation: The two SCSs are "aba" and "bab".
```

**Example 2:**
```
Input: words = ["aa","ac"]
Output: [[2,0,1,0,...]]
Explanation: The two SCSs are "aac" and "aca". Since they are permutations, keep only "aac".
```

**Example 3:**
```
Input: words = ["aa","bb","cc"]
Output: [[2,2,2,0,...]]
```

## Constraints

- `1 <= words.length <= 256`
- `words[i].length == 2`
- All strings in `words` will altogether be composed of no more than 16 unique lowercase letters.
- All strings in `words` are unique.
