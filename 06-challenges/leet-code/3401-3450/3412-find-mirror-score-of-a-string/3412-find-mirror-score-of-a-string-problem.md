# 3412. Find Mirror Score of a String

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/find-mirror-score-of-a-string/

## Problem

The mirror of a letter is its counterpart when the alphabet is reversed (a↔z, b↔y, c↔x, etc.).

Iterate left to right through string s. At each index i, find the closest unmarked index j < i where s[j] is the mirror of s[i]. If found, mark both i and j, and add i-j to the score.

Return the total score.

## Examples

**Example 1:**

Input: s = "aczzx"
Output: 5

Explanation:
- i=2: mirror of 'z' is 'a', closest unmarked j=0. Mark 0,2. Add 2.
- i=4: mirror of 'x' is 'c', closest unmarked j=1. Mark 1,4. Add 3.
- Score = 5.

**Example 2:**

Input: s = "abcdef"
Output: 0

## Constraints

- 1 <= s.length <= 10^5
- s consists only of lowercase English letters.
