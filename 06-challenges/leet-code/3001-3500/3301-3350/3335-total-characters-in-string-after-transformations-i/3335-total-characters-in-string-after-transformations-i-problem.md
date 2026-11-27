# 3335. Total Characters in String After Transformations I

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/total-characters-in-string-after-transformations-i/

## Problem

You are given a string `s` and an integer `t`, representing the number of **transformations** to perform. In one **transformation**, every character in `s` is replaced according to the following rules:

- If the character is `'z'`, replace it with the string `"ab"`.
- Otherwise, replace it with the **next** character in the alphabet. For example, `'a'` is replaced with `'b'`, `'b'` is replaced with `'c'`, and so on.

Return the **length** of the resulting string after **exactly** `t` transformations.

Since the answer may be very large, return it **modulo** `10^9 + 7`.

## Examples

**Example 1:**

Input: `s = "abcyy"`, `t = 2`
Output: `7`

Explanation:
- First Transformation: `'a'→'b'`, `'b'→'c'`, `'c'→'d'`, `'y'→'z'`, `'y'→'z'` → `"bcdzz"`
- Second Transformation: `'b'→'c'`, `'c'→'d'`, `'d'→'e'`, `'z'→"ab"`, `'z'→"ab"` → `"cdeabab"`
- Final length: 7

**Example 2:**

Input: `s = "azbk"`, `t = 1`
Output: `5`

Explanation:
- First Transformation: `'a'→'b'`, `'z'→"ab"`, `'b'→'c'`, `'k'→'l'` → `"babcl"`
- Final length: 5

## Constraints

- `1 <= s.length <= 10^5`
- `s` consists only of lowercase English letters.
- `1 <= t <= 10^5`
