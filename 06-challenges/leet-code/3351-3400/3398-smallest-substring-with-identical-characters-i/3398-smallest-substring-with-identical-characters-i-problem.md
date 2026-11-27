# 3398. Smallest Substring With Identical Characters I

**Difficulty:** Hard
**Link:** https://leetcode.com/problems/smallest-substring-with-identical-characters-i/

---

## Problem Statement

You are given a binary string `s` and an integer `numOps`.

You may perform the following operation at most `numOps` times: choose any index `i` where `0 <= i < s.length` and flip `s[i]`.

Return the **minimum** length of the longest substring of `s` such that all the characters in the substring are identical, after performing the operations.

---

## Examples

**Example 1:**
```
Input:  s = "000001", numOps = 1
Output: 2
```
Explanation: Flip index 2 to get "001001". The longest run of identical characters is 2.

**Example 2:**
```
Input:  s = "0000", numOps = 2
Output: 1
```
Explanation: Flip indices 1 and 3 to get "0101". Every character runs for length 1.

**Example 3:**
```
Input:  s = "0101", numOps = 0
Output: 1
```
Explanation: No operations; already no run exceeds length 1.

---

## Constraints

- `1 <= n == s.length <= 1000`
- `s` consists only of `'0'` and `'1'`
- `0 <= numOps <= n`
