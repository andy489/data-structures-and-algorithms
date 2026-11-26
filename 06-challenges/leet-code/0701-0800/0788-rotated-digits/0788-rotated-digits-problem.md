# 788. Rotated Digits

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/rotated-digits/

---

## Problem Statement

An integer `x` is a **good** integer if after rotating each digit individually by 180 degrees, we get a valid number that is different from `x`. Each digit must be rotated - we cannot choose to leave it alone.

A number is valid after rotation if each digit remains a digit after rotation. Valid digits after rotation: `0, 1, 2, 5, 6, 8, 9`. After rotation `2` becomes `5`, `5` becomes `2`, `6` becomes `9`, `9` becomes `6`. Everything else does not rotate to a valid digit.

Given an integer `n`, return the number of good integers in the range `[1, n]`.

---

## Examples

**Example 1:**
```
Input:  n = 10
Output: 4
Explanation: 2, 5, 6, 9 are good.
```

**Example 2:**
```
Input:  n = 1
Output: 0
```

**Example 3:**
```
Input:  n = 2
Output: 1
```

---

## Constraints

- `1 <= n <= 10^4`
