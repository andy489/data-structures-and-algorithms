# 3084. Count Substrings Starting And Ending With Given Character

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/count-substrings-starting-and-ending-with-given-character/

---

## Problem Statement

You are given a string `s` and a character `c`. Return the total number of substrings of `s` that start and end with `c`.

---

## Examples

**Example 1:**
```
Input:  s = "abada", c = "a"
Output: 6
```
Explanation: Substrings: a(0), a(2), a(4), aba(0-2), aa → wait: positions of a: 0,2,4. Substrings starting and ending with a: [0,0],[2,2],[4,4],[0,2],[0,4],[2,4] = 6.

**Example 2:**
```
Input:  s = "zzz", c = "z"
Output: 6
```
Explanation: All 6 substrings start and end with z.

---

## Constraints

- `1 <= s.length <= 10^5`
- `s and c consist only of lowercase English letters.`
