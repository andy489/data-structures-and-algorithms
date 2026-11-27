# 3900. Longest Balanced Substring After One Swap

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/longest-balanced-substring-after-one-swap/

## Problem Statement

You are given a binary string `s` consisting only of characters `'0'` and `'1'`.

A string is **balanced** if it contains an **equal** number of `'0'`s and `'1'`s.

You can perform **at most one** swap between any two characters in `s`. Then, you select a **balanced** substring from `s`.

Return an integer representing the **maximum** length of the **balanced** substring you can select.

## Examples

### Example 1
**Input:** `s = "100001"`
**Output:** `4`

**Explanation:**
- Swap positions 2 and 5. The string becomes `"101000"`.
- Select substring `"1010"`, which is balanced (two 0s and two 1s).

### Example 2
**Input:** `s = "111"`
**Output:** `0`

**Explanation:** No swaps can create a balanced substring. Return 0 (empty string).

## Constraints

- `1 <= s.length <= 10^5`
- `s` consists only of the characters `'0'` and `'1'`.
