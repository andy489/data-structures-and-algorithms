# 3099. Harshad Number

**Difficulty:** Easy
**Link:** https://leetcode.com/problems/harshad-number/

---

## Problem Statement

An integer divisible by the sum of its digits is called a Harshad number. You are given an integer `x`.

Return the sum of the digits of `x` if `x` is a Harshad number, otherwise return `-1`.

---

## Examples

**Example 1:**
```
Input:  x = 18
Output: 9
```
Explanation: Sum of digits = 1+8 = 9. 18 % 9 = 0, so Harshad. Return 9.

**Example 2:**
```
Input:  x = 23
Output: -1
```
Explanation: Sum of digits = 5. 23 % 5 != 0. Return -1.

---

## Constraints

- `1 <= x <= 100`
