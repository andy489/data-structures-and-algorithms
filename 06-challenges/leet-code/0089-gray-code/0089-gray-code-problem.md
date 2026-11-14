# 89. Gray Code

**Difficulty:** Medium
**Link:** https://leetcode.com/problems/gray-code/

---

## Problem Statement

An **n-bit gray code sequence** is a sequence of `2^n` integers where:

- Every integer is in the inclusive range `[0, 2^n - 1]`,
- The first integer is `0`,
- An integer appears **no more than once**,
- The binary representation of every pair of adjacent integers differs by **exactly one bit**, and
- The binary representation of the **first** and **last** integers differs by exactly one bit.

Given an integer `n`, return any valid **n-bit gray code sequence**.

---

## Examples

**Example 1:**
```
Input:  n = 2
Output: [0,1,3,2]
Explanation:
  0 = 00
  1 = 01  (differs from 00 by 1 bit)
  3 = 11  (differs from 01 by 1 bit)
  2 = 10  (differs from 11 by 1 bit, and from 00 by 1 bit)
```

**Example 2:**
```
Input:  n = 1
Output: [0,1]
```

---

## Constraints

- `1 <= n <= 16`
