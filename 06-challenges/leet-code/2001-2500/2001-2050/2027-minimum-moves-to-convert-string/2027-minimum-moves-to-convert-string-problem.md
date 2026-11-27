# 2027. Minimum Moves to Convert String

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/minimum-moves-to-convert-string/

---

## Problem Statement

You are given a string `s` consisting of `'X'` and `'O'`. In one move, you can select **three consecutive characters** of `s` and change them all to `'O'`. Return the **minimum** number of moves required to convert all `'X'` to `'O'`.

---

## Examples

**Example 1:**
```
Input:  s = "XXX"
Output: 1
```
Explanation: One move on the whole string.

**Example 2:**
```
Input:  s = "XXOX"
Output: 2
```
Explanation: Move on [0,2] and [3,5] (padded).

**Example 3:**
```
Input:  s = "OOOO"
Output: 0
```
Explanation: No X's.

---

## Constraints

- `3 <= s.length <= 10^3`
- `s[i] is either 'X' or 'O'.`
