# 2042. Check If Numbers Are Ascending in a Sentence

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/check-if-numbers-are-ascending-in-a-sentence/

---

## Problem Statement

A sentence is a string of tokens separated by spaces. A token is either a **word** (sequence of lowercase letters) or a **number** (sequence of digits). Return `true` if all numbers in `s` are strictly increasing from left to right, `false` otherwise.

---

## Examples

**Example 1:**
```
Input:  s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles"
Output: true
```
Explanation: 1 < 3 < 4 < 6 < 12.

**Example 2:**
```
Input:  s = "hello world 5 x 5"
Output: false
```
Explanation: 5 is repeated.

**Example 3:**
```
Input:  s = "sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s"
Output: false
```
Explanation: 51 > 50.

---

## Constraints

- `3 <= s.length <= 200`
- `s consists of lowercase English letters, spaces, and digits.`
- `Numbers in s are in range [1, 100].`
